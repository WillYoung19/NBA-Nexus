package github.nbanexus.model.client.teams;

import java.util.Date;

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
public class Season {
  private String year;
  private String displayName;
  private Date startDate;
  private Date endDate;
  private Object rankings;
  private Object powerIndexes;
  private Object powerIndexLeaders;
  private Object coaches;
  private Athletes athletes;
  private Object futures;
  private Object leaders;
  private CurrentSeason type;
  private Object types;
}
