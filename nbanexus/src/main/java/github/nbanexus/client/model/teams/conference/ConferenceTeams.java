package github.nbanexus.client.model.teams.conference;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import github.nbanexus.client.model.teams.NBATeam;
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
  private List<NBATeam> items;
}
