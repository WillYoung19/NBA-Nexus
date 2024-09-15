package github.nbanexus.model.client.teams.conference;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import github.nbanexus.model.client.teams.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConferenceTeams {
  private int count;
  private int pageIndex;
  private int pageSize;
  private int pageCount;
  private List<Team> items;
}
