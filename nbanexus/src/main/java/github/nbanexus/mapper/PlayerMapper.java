package github.nbanexus.mapper;

import java.time.Year;

import org.springframework.stereotype.Component;

import github.nbanexus.client.model.players.NBAPlayer;
import github.nbanexus.model.Player;
import github.nbanexus.model.PlayerSearch;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayerMapper {
  
  public Player nbaPlayerToPlayer(NBAPlayer nbaPlayer) {
    return Player.builder()
        .id(nbaPlayer.getId())
        .displayName(nbaPlayer.getDisplayName())
        .fullName(nbaPlayer.getFullName())
        .shortName(nbaPlayer.getShortName())
        .height(String.valueOf(nbaPlayer.getHeight()))
        .weight(String.valueOf(nbaPlayer.getWeight()))
        .age(nbaPlayer.getAge())
        .position(nbaPlayer.getPosition().getName())
        .yearsPro((nbaPlayer.getDraft() == null ?  nbaPlayer.getExperience().getYears() : Year.now().getValue()
            - nbaPlayer.getDraft().getYear()))
        .build();
  }

  public PlayerSearch playerToPlayerSearch(Player player) {
    return PlayerSearch.builder()
        .id(player.getId())
        .displayName(player.getDisplayName())
        .fullName(player.getFullName())
        .build();
  }
}
