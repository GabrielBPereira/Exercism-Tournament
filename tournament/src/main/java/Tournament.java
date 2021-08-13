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
		for(String valueMatch : string.split("\n")) {

			// Recupera o objeto match info com os resultados da partida atual
			MatchInfo matchInfo = valueMatchToMatchInfo(valueMatch);

			TeamResults teamA = teamsResults.computeIfAbsent(matchInfo.getTeamA(), value -> new TeamResults(value, 0, 0, 0));
			TeamResults teamB = teamsResults.computeIfAbsent(matchInfo.getTeamB(),  value -> new TeamResults(value, 0, 0, 0));
			
			// Verifica e atribui as pontuações de cada time
			if(matchInfo.getResult() == MatchResult.WIN) {
				teamA.updateWin();
				teamA.updateMatchsPlayed();
				teamB.updateLoss();
				teamB.updateMatchsPlayed();
			} else if(matchInfo.getResult() == MatchResult.LOSS) {
				teamA.updateLoss();
				teamA.updateMatchsPlayed();
				teamB.updateWin();
				teamB.updateMatchsPlayed();
			} else {
				teamA.updateDraw();
				teamA.updateMatchsPlayed();
				teamB.updateDraw();
				teamB.updateMatchsPlayed();
			}
		}
	}
	
	/*
	 * Mapeia os valores string de uma partida para o objeto representante MatchInfo
	 */
	public MatchInfo valueMatchToMatchInfo(String valueMatch) {
		return new MatchInfo(valueMatch.split(";")[0], valueMatch.split(";")[1], valueMatch.split(";")[2]);
	}
	
} // Fechamento da classe Tournament