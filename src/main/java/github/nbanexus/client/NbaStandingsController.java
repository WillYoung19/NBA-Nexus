package github.nbanexus.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import github.nbanexus.model.client.teams.Team;
import github.nbanexus.model.client.teams.standings.Standings;

@RestController
public class NbaStandingsController {

  private final NbaStandingsClient nbaStandingsClient;

  @Autowired
  public NbaStandingsController(NbaStandingsClient nbaStandingsClient) {
    this.nbaStandingsClient = nbaStandingsClient;
  }

  @GetMapping("/standings")
  public Standings getStandings() throws Exception {
    return nbaStandingsClient.getNbaStandings();
  }

  @GetMapping("/team/{teamId}")
  public Team getTeam(@PathVariable final String teamId) throws Exception {
    return nbaStandingsClient.getNbaTeam(teamId);
  }
}
