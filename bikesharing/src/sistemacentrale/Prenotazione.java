package sistemacentrale;

import stazione.*;

import java.time.Duration;

public class Prenotazione {

	private Duration timer;
	private String stazione;
	
	public Prenotazione() {
		//imposto timer
	}
	
	public String getStazione() {
		return stazione;
	}
	public void setStazione(String stazione) {
		this.stazione = stazione;
	}

}