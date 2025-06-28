package github.nbanexus.model;

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
public class Player {
  private long id;
  private String fullName;
  private String displayName;
  private String shortName;
  private int age;
  private String height;
  private String weight;
  private int yearsPro;
  private String position;
}
