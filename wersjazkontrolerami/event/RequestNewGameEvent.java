package wersjazkontrolerami.event;

/**
 * Created by pwilkin on 22-Nov-18.
 */
public class RequestNewGameEvent implements TicTacToeEvent {

	private String wybor;

	public RequestNewGameEvent(String wybor) {
		this.wybor = wybor;
	}
	
	public String jakiWybor() {
		return wybor;
	}
}