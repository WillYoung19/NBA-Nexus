package github.nbanexus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import github.nbanexus.client.NbaStandingsClient;
import github.nbanexus.client.NbaTeamsClient;
import github.nbanexus.client.model.players.NBAPlayer;
import github.nbanexus.client.model.teams.NBATeam;
import github.nbanexus.client.model.teams.TeamPlayers;
import github.nbanexus.model.Player;
import github.nbanexus.model.Team;

@Service
public class PlayerService {

  @Autowired private NbaStandingsClient nbaStandingsClient;
  @Autowired private NbaTeamsClient nbaTeamsClient;

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
        .map(player -> ((Player) player).getName())
        .collect(Collectors.toList()));
    return team;
  }

  public List<Player> getPlayerNames(String teamId) throws Exception {
    List<Player> players = new ArrayList<>();
    TeamPlayers teamPlayers = nbaTeamsClient.getNbaTeamPlayers(teamId);
    System.out.println(teamPlayers);
    for (Object o : teamPlayers.getItems()) {
      String url = o.toString().replace("{$ref=", "").replace("}", "");
      NBAPlayer nbaPlayer = nbaTeamsClient.getTeamPlayers(url);
      Player player = new Player();
      player.setName(nbaPlayer.getDisplayName());
      player.setHeight(nbaPlayer.getDisplayHeight());
      player.setWeight(nbaPlayer.getDisplayWeight());
      player.setAge(nbaPlayer.getAge());
      player.setYearsPro(nbaPlayer.getExperience().toString());
      player.setPosition(nbaPlayer.getPosition().getName());
      players.add(player);
      System.out.println(player);
    }
    return players;
  }
  
}
