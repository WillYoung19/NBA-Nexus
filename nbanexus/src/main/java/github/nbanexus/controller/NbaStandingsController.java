package github.nbanexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import github.nbanexus.client.NbaStandingsClient;
import github.nbanexus.client.model.teams.standings.Standings;

@RestController
public class NbaStandingsController {

  @Autowired private NbaStandingsClient nbaStandingsClient;

  @GetMapping("/standings")
  public Standings getStandings() throws Exception {
    return nbaStandingsClient.getNbaStandings();
  }
}
