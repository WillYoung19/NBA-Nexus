package github.nbanexus.client.model.teams.conference;

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
public class Conference {
  private String uid;
  private String id;
  private String name;
  private String abbreviation;
  private String slug;
  private boolean isConference;
  private ConferenceTeams teams;
  // TODO: Complete
}
