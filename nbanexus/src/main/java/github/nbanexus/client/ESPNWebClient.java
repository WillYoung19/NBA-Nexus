// package github.nbanexus.client;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.reactive.function.client.WebClient;

// import github.nbanexus.model.Player;
// import reactor.core.publisher.Mono;

// @Component
// public class ESPNWebClient {

//   private static final String BASE_URL = "https://site.api.espn.com/apis/site/v2/sports/basketball/nba/teams/";

//   private final WebClient webClient;

//   @Autowired
//   public ESPNWebClient(WebClient.Builder webClientBuilder) {
//     this.webClient = webClientBuilder.baseUrl(BASE_URL)..build();
//   }

//   public List<Player> fetchNBAPlayers() {
//     // Make a GET request to the NBA players endpoint
//     Mono<Map<String, Object>> responseMono = this.webClient.get()
//         .uri(NBA_PLAYERS_ENDPOINT)
//         .retrieve()
//         .bodyToMono(Map.class);

//     // Block the reactive call and get the response synchronously (for simplicity)
//     Map<String, Object> response = responseMono.block();

//     // Parse the response to extract player data
//     return parsePlayerData(response);
//   }

//   // Method to parse JSON data from API response
//   private List<Player> parsePlayerData(Map<String, Object> response) {
//     List<Player> players = new ArrayList<>();

//     // Assume the API structure contains a "players" key with player details
//     List<Map<String, Object>> playerData = (List<Map<String, Object>>) response.get("players");

//     for (Map<String, Object> playerMap : playerData) {
//       String name = (String) playerMap.get("fullName");
//       String team = (String) ((Map<String, Object>) playerMap.get("team")).get("displayName");
//       String position = (String) playerMap.get("position");
//       String age = String.valueOf(playerMap.get("age"));
//       String height = (String) playerMap.get("height");
//       String weight = String.valueOf(playerMap.get("weight"));
//       String pointsPerGame = (String) ((Map<String, Object>) playerMap.get("statistics")).get("ppg");
//       String reboundsPerGame = (String) ((Map<String, Object>) playerMap.get("statistics")).get("rpg");
//       String assistsPerGame = (String) ((Map<String, Object>) playerMap.get("statistics")).get("apg");

//       Player player = new Player(name, team, position, age, height, weight, pointsPerGame, reboundsPerGame,
//           assistsPerGame);
//       players.add(player);
//     }

//     return players;
//   }
// }
