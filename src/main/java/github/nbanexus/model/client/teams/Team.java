package github.nbanexus.model.client.teams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import github.nbanexus.model.client.players.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
  private long id;
  private String uid;
  private String guid;
  private String slug;
  private String location;
  private String name;
  private String abbreviation;
  private String displayName;
  private String shortDisplayName;
  private String color;
  private String alternateColor;
  private boolean isActive;
  private boolean isAllStar;
  private Object oddsRecords;
  private TeamPlayers athletes;
  //TODO: Complete

}
