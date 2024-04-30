# Task6.Tournament.2DArrayOfStrings
Task 6. Define a two-dimensional array of Strings representing the results of matches in a tournament

April 26, 2024

# Task 6

Define a two-dimensional array of `String`s representing the results of matches in a tournament, for example as below  

```java
        String[][] arr =
            { {"Germany",  "2", "Scotland", "1"},
              {"Poland",   "2", "Germany",  "0"},
              {"Germany",  "1", "Ireland",  "1"},
              {"Poland",   "2", "Scotland", "2"},
              {"Scotland", "1", "Ireland",  "0"},
              {"Ireland",  "1", "Poland",   "1"},
              {"Ireland",  "1", "Scotland", "1"},
              {"Germany",  "3", "Poland",   "1"},
              {"Scotland", "2", "Germany",  "3"},
              {"Ireland",  "1", "Germany",  "0"},
              {"Scotland", "2", "Poland",   "2"},
              {"Poland",   "2", "Ireland",  "1"} };
```

and a four-element array of `int`s representing scores of teams of Germany, Ireland, Poland and Scotland (in this order). The program calculates total score for each team (3 points for a win, 1 for a draw, 0 for a defeat), puts them into the array and then prints it.  

It will be very helpful to define a small function which, given the name of a country, returns its index in the array of total scores (`switch` expression would be appropriate here).

If a string `str` represents a number, like "435", you can get this number as an `int` using:  

```java
int n = Integer.parseInt(str);  
```

For data as above you should get scores [10, 6, 9, 6].  

Deadline: May 11 (inclusive)

# Solution  

```java
public class TournamentScores {
    public static void main(String[] args) {
        // Match results: [team1, score1, team2, score2]
        String[][] arr = {
              {"Germany",  "2", "Scotland", "1"},
              {"Poland",   "2", "Germany",  "0"},
              {"Germany",  "1", "Ireland",  "1"},
              {"Poland",   "2", "Scotland", "2"},
              {"Scotland", "1", "Ireland",  "0"},
              {"Ireland",  "1", "Poland",   "1"},
              {"Ireland",  "1", "Scotland", "1"},
              {"Germany",  "3", "Poland",   "1"},
              {"Scotland", "2", "Germany",  "3"},
              {"Ireland",  "1", "Germany",  "0"},
              {"Scotland", "2", "Poland",   "2"},
              {"Poland",   "2", "Ireland",  "1"}
        };

        // Scores for Germany, Ireland, Poland, and Scotland
        int[] scores = new int[4];

        // Calculate scores based on match results
        for (String[] match : arr) {
            String team1 = match[0];
            String team2 = match[2];
            int score1 = Integer.parseInt(match[1]);
            int score2 = Integer.parseInt(match[3]);

            // Update scores
            if (score1 > score2) {
                scores[getTeamIndex(team1)] += 3; // Team1 wins
            } else if (score1 == score2) {
                scores[getTeamIndex(team1)] += 1; // Draw
                scores[getTeamIndex(team2)] += 1;
            } else {
                scores[getTeamIndex(team2)] += 3; // Team2 wins
            }
        }

        // Print the scores
        System.out.println("Scores:");
        System.out.println("Germany: " + scores[0]);
        System.out.println("Ireland: " + scores[1]);
        System.out.println("Poland: " + scores[2]);
        System.out.println("Scotland: " + scores[3]);
    }

    // Helper function to get the index of a team in the scores array
    private static int getTeamIndex(String team) {
        switch (team) {
            case "Germany":
                return 0;
            case "Ireland":
                return 1;
            case "Poland":
                return 2;
            case "Scotland":
                return 3;
            default:
                throw new IllegalArgumentException("Invalid team name: " + team);
        }
    }
}
```
