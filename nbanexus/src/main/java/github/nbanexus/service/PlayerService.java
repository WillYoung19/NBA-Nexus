package github.nbanexus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import github.nbanexus.client.NbaTeamsClient;
import github.nbanexus.client.model.players.NBAPlayer;
import github.nbanexus.client.model.teams.NBATeam;
import github.nbanexus.client.model.teams.TeamPlayers;
import github.nbanexus.mapper.PlayerMapper;
import github.nbanexus.model.Player;
import github.nbanexus.model.PlayerBase;
import github.nbanexus.model.PlayerSearch;
import github.nbanexus.model.Team;

@Service
public class PlayerService {

  @Autowired private NbaTeamsClient nbaTeamsClient;
  @Autowired private PlayerMapper playerMapper;
  @Autowired private ObjectMapper objectMapper;

  @Autowired
  public PlayerService(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public Team getTeam(String teamId) throws Exception{
    NBATeam nbaTeam = nbaTeamsClient.getNbaTeam(teamId);
    Team team = new Team();
    team.setTeamId(String.valueOf(nbaTeam.getId()));
    team.setTeamName(nbaTeam.getDisplayName());
    team.setAbbreviation(nbaTeam.getAbbreviation());
    team.setTeamCity(nbaTeam.getVenue().getAddress().getCity());
    team.setTeamState(nbaTeam.getVenue().getAddress().getState());
    team.setSlug(nbaTeam.getSlug());
    team.setVenueName(nbaTeam.getVenue().getFullName());
    team.setPlayerNames(getPlayerNames(teamId).stream()
        .map(player -> ((Player) player).getDisplayName())
        .collect(Collectors.toList()));
    return team;
  }

  public List<Player> getPlayerNames(String teamId) throws Exception {
    List<Player> players = new ArrayList<>();
    TeamPlayers teamPlayers = nbaTeamsClient.getNbaTeamPlayers(teamId);
    for (Object o : teamPlayers.getItems()) {
      String url = o.toString().replace("{$ref=", "").replace("?lang=en&region=us}", "");
      NBAPlayer nbaPlayer = nbaTeamsClient.getTeamPlayer(url);
      players.add(playerMapper.nbaPlayerToPlayer(nbaPlayer));
    }
    getPlayerSearches(players);
    return players;
  }

  public List<String> getAllPlayers() throws Exception {
    List<Player> players = new ArrayList<>();
    List<String> playerBase = new ArrayList<>();
    for(int i = 1; i <= 30; i++){
    TeamPlayers teamPlayers = nbaTeamsClient.getNbaTeamPlayers(String.format("%d", i));
    for (Object o : teamPlayers.getItems()) {
      String url = o.toString().replace("{$ref=", "").replace("?lang=en&region=us}", "");
      NBAPlayer nbaPlayer = nbaTeamsClient.getTeamPlayer(url);
      players.add(playerMapper.nbaPlayerToPlayer(nbaPlayer));
    }
  }
  playerBase = getPlayerSearches(players);
    return playerBase;
  }

  List<String> getPlayerSearches(List<Player> players) {
    List<String> list = new ArrayList<>();
    for (Player player : players) {
      PlayerSearch searchedPlayer = playerMapper.playerToPlayerSearch(player);
      System.out.println(String.format("list.add(new PlayerSearch(%d, \"%s\", \"%s\"));", searchedPlayer.getId(), searchedPlayer.getFullName(), searchedPlayer.getDisplayName()));
      list.add(String.format("list.add(new PlayerSearch(%d, \"%s\", \"%s\"));", searchedPlayer.getId(), searchedPlayer.getFullName(), searchedPlayer.getDisplayName()));
    }
    return list;
  }

  public Player getPlayerByName(String name) throws Exception{
    name = name.strip();
    PlayerBase playerBase = new PlayerBase();
    for (PlayerSearch player : playerBase.getPlayerBase()) {
      if(name.equalsIgnoreCase(player.getDisplayName().strip())) {
        NBAPlayer nbaPlayer = nbaTeamsClient.getPlayer(String.format("%d", player.getId()));
        return playerMapper.nbaPlayerToPlayer(nbaPlayer);
      }
    }
    return null;
  }

  public NBAPlayer getPlayer(String playerId) throws Exception {
    NBAPlayer nbaPlayer = nbaTeamsClient.getPlayer(playerId);
    System.out.println(nbaPlayer);
    return nbaPlayer;
  }
  
}
