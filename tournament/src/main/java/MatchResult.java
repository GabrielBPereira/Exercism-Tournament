/**
 * @author Gabriel Pereira
 * 
 * MatchResult é enumeração criada para armazenar o resultado da partida entre duas equipes. 
 */
public enum MatchResult {
	
	WIN("win"), LOSS("loss"), DRAW("draw");
	
	private String matchResult;
	
	MatchResult(String value) {
		this.matchResult = value;
	}

	public String getValue() {
		return matchResult;
	}
}
