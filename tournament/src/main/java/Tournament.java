import java.util.TreeMap;
import java.util.stream.Collectors;


public class Tournament {

	private TreeMap<String, TeamResults> teamsResults;

	private static final String HEADER_TEAMS = "Team                           | MP |  W |  D |  L |  P\n";

	public Tournament() {
		teamsResults = new TreeMap<>();
	}

	public String printTable() {
		return teamsResults.values().stream().sorted().map(TeamResults::toString).collect(Collectors.joining("", HEADER_TEAMS ,""));
	}

	public void applyResults(String string) {

		// Quebra a string do parâmetro para verificar o resultado de cada partida
		for(String result : string.split("\n")) {

			// Quebra a linha para obter um array com os valores do resultado cada partida
			String[] valuesResult = result.split(";");

			TeamResults teamA = teamsResults.computeIfAbsent(valuesResult[0], value -> new TeamResults(value, 0, 0, 0));
			TeamResults teamB = teamsResults.computeIfAbsent(valuesResult[1],  value -> new TeamResults(value, 0, 0, 0));

			// Verifica e atribui as pontuações de cada time
			if(valuesResult[2].contains("win")) {
				teamA.updateWin();
				teamB.updateLoss();
			} else if(valuesResult[2].contains("loss")) {
				teamA.updateLoss();
				teamB.updateWin();
			} else {
				teamA.updateDraw();
				teamB.updateDraw();
			}
		}
	}

	public class TeamResults implements Comparable<TeamResults>{

		private String team;
		private int matchsPlayed;
		private int win;
		private int loss;
		private int draw;


		public TeamResults() { }

		public TeamResults(String team, int win, int loss, int draw) {
			this.team = team;
			this.win = win;
			this.loss = loss;
			this.draw = draw;
		}

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public int getMatchsPlayed() {
			return matchsPlayed;
		}

		public int getWin() {
			return win;
		}

		public void updateWin() {
			this.win++;
			this.matchsPlayed++;
		}

		public int getLoss() {
			return loss;
		}

		public void updateLoss() {
			this.loss++;
			this.matchsPlayed++;
		}

		public int getDraw() {
			return draw;
		}

		public void updateDraw() {
			this.draw++;
			this.matchsPlayed++;
		}

		public int getPoints( ) {
			return 3 * this.win + this.draw;
		}

		@Override
		public int compareTo(TeamResults otherResults) {
			int comparePoints = Integer.compare(otherResults.getPoints(), this.getPoints());
			return comparePoints == 0 ? this.team.compareTo(otherResults.team) : comparePoints;
		}

		@Override
		public String toString() {
			return String.format("%-30s | %2d | %2d | %2d | %2d | %2d\n", team, matchsPlayed,
					win, draw, loss, getPoints());
		}

	}

}