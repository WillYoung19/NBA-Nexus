package github.nbanexus.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import github.nbanexus.model.client.teams.Team;
import github.nbanexus.model.client.teams.standings.Standings;

@Component
public class NbaStandingsClient {

  private static String ESPN_API_URL = "http://sports.core.api.espn.com/v2/sports/basketball/leagues/nba/seasons/2024/types/2/groups/7/standings?lang=en&region=us";

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  @Autowired
  public NbaStandingsClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
    this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public Standings getNbaStandings() throws Exception{
    ResponseEntity<String> response = restTemplate.getForEntity(ESPN_API_URL, String.class);
    String responseBody = response.getBody();

    JsonNode jsonNode = objectMapper.readTree(responseBody);
    Standings nbaStandings = objectMapper.convertValue(jsonNode, Standings.class);

    return nbaStandings;
  }

  public Team getNbaTeam(String teamId) throws Exception {
    ESPN_API_URL = "http://sports.core.api.espn.com/v2/sports/basketball/leagues/nba/seasons/2024/teams/"+teamId+"?lang=en&region=us";
    ResponseEntity<String> response = restTemplate.getForEntity(ESPN_API_URL, String.class);
    String responseBody = response.getBody();

    JsonNode jsonNode = objectMapper.readTree(responseBody);
    Team nbaTeam = objectMapper.convertValue(jsonNode, Team.class);

    return nbaTeam;
  }
}
