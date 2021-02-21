package sistemacentrale;

import stazione.*;

import java.time.Duration;

public class Prenotazione {

	private Duration Timer;
	private String stazione;
	private String postazione;
	
	public String getStazione() {
		return stazione;
	}
	public void setStazione(String stazione) {
		this.stazione = stazione;
	}
	public String getPostazione() {
		return postazione;
	}
	public void setPostazione(String postazione) {
		this.postazione = postazione;
	}

}