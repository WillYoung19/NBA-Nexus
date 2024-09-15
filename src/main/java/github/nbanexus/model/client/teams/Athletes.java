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
public class Athletes {
  private int count;
  private int pageIndex;
  private int pageSize;
  private int pageCount;
  private List<Player> items;
}
