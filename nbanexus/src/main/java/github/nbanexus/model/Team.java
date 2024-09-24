package github.nbanexus.model;

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
public class Team {
  private String teamId;
  private String teamName;
  private String abbreviation;
  private String teamCity;
  private String teamState;
  private String venueName;
  private List<String> playerNames;
  private String slug;
}
