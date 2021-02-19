package sistemacentrale;

import stazione.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestoreStazioni {

	private Map<Stazione,Integer> statoStazioni;
	private static GestoreStazioni istance = new GestoreStazioni();
	//serve per tenere traccia degli utenti che iniziano una nuova corsa prenotata
	private List<Prenotazione> prenotazioni;
	
	private GestoreStazioni() {
		//metodo che prende in input le stazioni
		statoStazioni = new HashMap<Stazione,Integer>();
	}

	/**
	 * 
	 * @param prenotazione
	 */
	public boolean prenotazione(Prenotazione prenotazione) {
		/*gli viene passata una prenotazione e riserva un posto in una stazione
		*all'utente della prenotazione*/
		int libere = statoStazioni.get(prenotazione.getStazione());
		if(libere > 0) {
			statoStazioni.replace(prenotazione.getStazione(), libere--);
			prenotazioni.add(prenotazione);
			return true;
		}
		return false;
	}
	
	public void cancellaPrenotazione(Prenotazione prenotazione) {
		int libere = statoStazioni.get(prenotazione.getStazione());
		statoStazioni.replace(prenotazione.getStazione(), libere++);
		prenotazioni.remove(prenotazione);
	}

	/**
	 * 
	 * @param corsa
	 */
	public boolean nuovaCorsa(Corsa corsa) {
		
		
		throw new UnsupportedOperationException();
	}

	public List<Stazione> getStatoStazioni() {
		// TODO - implement Gestorestazioni.getStatoStazioni
		throw new UnsupportedOperationException();
	}
	public static GestoreStazioni getIstance() {
		return istance;
	}

}
