/**
 * @author Gabriel Pereira
 * 
 * A classe MatchInfo armazena informações sobre a partida entre duas equipes, sendo o nome das duas equipes e o resultado da partida. 
 */
public class MatchInfo {
	private String teamA;
	private String teamB;
	private MatchResult result;
	
	public MatchInfo() { }

	public MatchInfo(String teamA, String teamB, String result) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.result = result.compareTo(MatchResult.WIN.getMatchResult()) == 0 ? MatchResult.WIN : (result.compareTo(MatchResult.LOSS.getMatchResult()) == 0 ? MatchResult.LOSS : MatchResult.DRAW);
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	public MatchResult getResult() {
		return result;
	}

	public void setResult(MatchResult result) {
		this.result = result;
	}
}
