package github.nbanexus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import github.nbanexus.client.NbaStandingsClient;
import github.nbanexus.model.Player;
import github.nbanexus.model.Team;
import github.nbanexus.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "NBA Team & Player Controller")
public class NbaTeamsController {
  @Autowired private PlayerService service;

  @GetMapping("/team/{teamId}")
  @Operation(summary = "Get Team Information", description = "Retrieve the information for a given team")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful response"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
  public Team getTeam(@PathVariable final String teamId) throws Exception {
    return service.getTeam(teamId);
  }

  @GetMapping("/team/{teamId}/players/names")
  @Operation(summary = "Get Team Players", description = "Retrieve the player information for a given team")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful response"),
      @ApiResponse(responseCode = "404", description = "Not found")
  })
  public List<Player> getPlayersNamesForTeam(@PathVariable final String teamId) throws Exception {
    return service.getPlayerNames(teamId);
  }
}
