package github.nbanexus.client;

import java.util.ArrayList;
import java.util.List;

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
import github.nbanexus.client.model.teams.standings.Standings;

@Component
public class NbaStandingsClient {

  private static String BASE_URL = "http://sports.core.api.espn.com/v2/sports/basketball/leagues/nba/seasons/2024/";

  @Autowired private RestTemplate restTemplate;
  @Autowired private ObjectMapper objectMapper;

  @Autowired
  public NbaStandingsClient(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public Standings getNbaStandings() throws Exception{
    String ESPN_API_URL = BASE_URL + "types/2/groups/7/standings";
    ResponseEntity<String> response = restTemplate.getForEntity(ESPN_API_URL, String.class);
    String responseBody = response.getBody();

    JsonNode jsonNode = objectMapper.readTree(responseBody);
    Standings nbaStandings = objectMapper.convertValue(jsonNode, Standings.class);

    return nbaStandings;
  }
}
