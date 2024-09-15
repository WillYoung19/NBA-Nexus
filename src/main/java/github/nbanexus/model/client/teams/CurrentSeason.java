package github.nbanexus.model.client.teams;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import github.nbanexus.model.client.teams.conference.ConferenceChildrenGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentSeason {
  private String id;
  private String type;
  private String name;
  private String abbreviation;
  private int year;
  private Date startDate;
  private Date endDate;
  private boolean hasGroups;
  private boolean hasStandings;
  private boolean hasLegs;
  private String slug;
  private ConferenceChildrenGroup groups;
  private Object weeks;
  private Object corrections;
  private Object leaders; //TO complete
}
