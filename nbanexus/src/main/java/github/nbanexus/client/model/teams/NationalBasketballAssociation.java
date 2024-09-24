package github.nbanexus.client.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import github.nbanexus.client.model.teams.conference.ConferenceChildrenGroup;
import github.nbanexus.client.model.teams.conference.ConferenceTeams;
import github.nbanexus.client.model.teams.standings.Standings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class NationalBasketballAssociation {
  private String uid;
  private String id;
  private String name;
  private String abbreviation;
  private String slug;
  private boolean isConference;
  private ConferenceTeams teams;
  private ConferenceChildrenGroup children;
  private Standings standings; //TODO
  private Object season; // TODO
}
