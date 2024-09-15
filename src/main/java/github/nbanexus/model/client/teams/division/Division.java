package github.nbanexus.model.client.teams.division;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Division {
  private String uid;
  private String id;
  private String name;
  private String abbreviation;
  private String slug;
  private boolean isConference;
  private DivisionTeams teams;
  private Object parent; //conference
  private Object season;
  private Object standings;
}
