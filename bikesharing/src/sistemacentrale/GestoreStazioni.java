package sistemacentrale;

import stazione.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestoreStazioni {

	// mappa per mantenere lo stato delle prenotazioni
	private Map<Stazione, Integer> statoStazioni;
	// mappa che associa i nomi alle relative stazioni
	private Map<String, Stazione> cercaStazioni;

	// serve per tenere traccia degli utenti che iniziano una nuova corsa prenotata
	private List<Prenotazione> prenotazioni;
	// liste delle corse in corso
	private List<Corsa> corse;
	private static GestoreStazioni instance = new GestoreStazioni();
	
	private GestoreStazioni() {
		// metodo che prende in input le stazioni
		statoStazioni = new HashMap<Stazione, Integer>();
		cercaStazioni = new HashMap<String, Stazione>();
		prenotazioni = new LinkedList<Prenotazione>();
		corse = new LinkedList<Corsa>();
		prenotazioni = new LinkedList<Prenotazione>();
	}

	/**
	 * 
	 * @param prenotazione
	 */
	public boolean prenotazione(Prenotazione prenotazione) {
		/*
		 * gli viene passata una prenotazione e riserva un posto in una stazione
		 * all'utente della prenotazione
		 */
		Stazione stazione = cercaStazioni.get(prenotazione.getStazione());
		int libere = statoStazioni.get(stazione);
		if (libere > 0) {
			statoStazioni.replace(stazione, libere - 1);
			prenotazioni.add(prenotazione);
			return true;
		}
		return false;
	}

	public boolean cancellaPrenotazione(Prenotazione prenotazione) {

		if (prenotazioni.remove(prenotazione)) {
			Stazione stazione = cercaStazioni.get(prenotazione.getStazione());
			int libere = statoStazioni.get(stazione);
			statoStazioni.replace(stazione, libere + 1);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param corsa
	 */

	public Map<Stazione, Integer> getStatoStazioni() {
		return statoStazioni;
	}

	public List<Stazione> getStazioni() {
		return new LinkedList<Stazione>(cercaStazioni.values());
	}
	
	public static GestoreStazioni getInstance() {
		return instance;
	}

}