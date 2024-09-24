package github.nbanexus.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import github.nbanexus.client.model.players.NBAPlayer;
import github.nbanexus.client.model.teams.NBATeam;
import github.nbanexus.client.model.teams.TeamPlayers;

@Component
public class NbaTeamsClient {
  private static String BASE_URL = "http://sports.core.api.espn.com/v2/sports/basketball/leagues/nba/seasons/2024/teams/";

  @Autowired private RestTemplate restTemplate;
  @Autowired private ObjectMapper objectMapper;

  @Autowired
  public NbaTeamsClient(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public NBATeam getNbaTeam(String teamId) throws Exception {
    String url = BASE_URL + teamId;
    return objectMapper.convertValue(getClientResponse(url), NBATeam.class);
  }

  public TeamPlayers getNbaTeamPlayers(String teamId) throws Exception {
    String url = BASE_URL + teamId + "/athletes";
    return objectMapper.convertValue(getClientResponse(url), TeamPlayers.class);
  }

  public NBAPlayer getTeamPlayers(String url) throws Exception {
    return objectMapper.convertValue(getClientResponse(url), NBAPlayer.class);
  }

  JsonNode getClientResponse(String url) throws Exception{
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    return objectMapper.readTree(response.getBody());
  }
}
