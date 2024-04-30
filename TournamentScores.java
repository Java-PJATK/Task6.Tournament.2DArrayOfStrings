public class TournamentScores {
    public static void main(String[] args) {
        // Match results: [team1, score1, team2, score2]
        String[][] arr = {
                { "Germany", "2", "Scotland", "1" },
                { "Poland", "2", "Germany", "0" },
                { "Germany", "1", "Ireland", "1" },
                { "Poland", "2", "Scotland", "2" },
                { "Scotland", "1", "Ireland", "0" },
                { "Ireland", "1", "Poland", "1" },
                { "Ireland", "1", "Scotland", "1" },
                { "Germany", "3", "Poland", "1" },
                { "Scotland", "2", "Germany", "3" },
                { "Ireland", "1", "Germany", "0" },
                { "Scotland", "2", "Poland", "2" },
                { "Poland", "2", "Ireland", "1" }
        };

        // Scores for each team (array with size 4)
        int[] scores = new int[4];

        // Calculate scores based on match results. parseInt changes type from String to
        // Int
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
        System.out.println("Scores");
        System.out.println("Germany \t" + scores[0]);
        System.out.println("Ireland \t" + scores[1]);
        System.out.println("Poland \t\t" + scores[2]);
        System.out.println("Scotland \t" + scores[3]);
    }

    // Helper function to get the index of a team in the scores array
    private static int getTeamIndex(String team) {
        return switch (team) {
            case "Germany" -> 0;
            case "Ireland" -> 1;
            case "Poland" -> 2;
            case "Scotland" -> 3;
            default -> throw new IllegalArgumentException("Invalid team name: " + team);
        };
    }
}