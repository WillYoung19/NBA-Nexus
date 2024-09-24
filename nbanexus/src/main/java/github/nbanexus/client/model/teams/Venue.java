package github.nbanexus.client.model.teams;

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
public class Venue {
  private String id;
  private String fullName;
  private String shortName;
  private VenueAddress address;
  private boolean grass;
  private boolean indoor;
}
