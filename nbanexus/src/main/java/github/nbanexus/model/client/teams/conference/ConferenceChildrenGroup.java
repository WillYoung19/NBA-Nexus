package github.nbanexus.model.client.teams.conference;

import java.util.List;

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
public class ConferenceChildrenGroup {
  private int count;
  private int pageIndex;
  private int pageSize;
  private int pageCount;
  private List<Conference> items;
}
