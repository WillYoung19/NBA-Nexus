package github.nbanexus.client.model.teams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import github.nbanexus.client.model.players.NBAPlayer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamPlayers {
  private int count;
  private int pageIndex;
  private int pageSize;
  private int pageCount;
  private List<Object> items;
}
