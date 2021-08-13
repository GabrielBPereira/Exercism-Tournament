/**
 * @author Gabriel Pereira
 * 
 * TeamResults é uma classe que contém as informações sobre um determinado time após suas partidas jogadas, armazena
 * o nome do time, quantas partidas foram jogadas, as vitórias, as derrotas, os pontos e os empates.
 * 
 */
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
		}

		public int getLoss() {
			return loss;
		}

		public void updateLoss() {
			this.loss++;
		}

		public int getDraw() {
			return draw;
		}

		public void updateDraw() {
			this.draw++;
		}

		public void updateMatchsPlayed() {
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
