package sistemacentrale;

import stazione.*;

import java.time.LocalTime;

public class Corsa {

	private LocalTime inizio,fine;
	private String stazionePartenza,stazioneArrivo;
	private String postazionePartenza,postazioneArrivo;

	/**
	 *
	 * @param postazione
	 * @throws Exception 
	 */

	//prende la stringa mandata dall'utente che scannerizza il qr code
	public Corsa(String coordinate ) throws Exception {
		if(coordinate.length() != 10)throw new Exception();
			inizio = LocalTime.now();
			stazionePartenza = coordinate.substring(0, 4);
			postazionePartenza = coordinate.substring(5, 9);
	}

	/**
	 *
	 * @param postazione
	 */
	public void fineCorsa(String coordinate) {
		fine = LocalTime.now();
		stazionePartenza = coordinate.substring(0, 4);
		stazioneArrivo = coordinate.substring(5, 9);
	}

	public String getStazionePartenza() {
		return stazionePartenza;
	}

	public String getPostazionePartenza() {
		return postazionePartenza;
	}

}