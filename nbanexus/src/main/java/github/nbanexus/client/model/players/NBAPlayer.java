package github.nbanexus.client.model.players;

import java.util.Date;
import java.util.Map;

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
public class NBAPlayer {
  private long id;
  private String uid;
  private String guid;
  private String type;
  private Map<String, String> alternateIds;
  private String firstName;
  private String lastName;
  private String fullName;
  private String displayName;
  private String shortName;
  private double weight;
  private String displayWeight;
  private double height;
  private String displayHeight;
  private int age;
  private Date dateOfBirth;
  private int debutYear;
  private BirthPlace birthPlace;
  private String slug;
  private Position position;
  private boolean linked;
  private NBATeam team;
  private Object contract;
  private Object statistics;
  private Object experience;
  private boolean active;
  private Object contracts;
  private NBADraftInformation draft;
  private PlayerStatus status;
  private Object statisticslog;
  private Object seasons;


}
