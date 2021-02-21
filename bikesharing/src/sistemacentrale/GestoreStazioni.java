package sistemacentrale;

import stazione.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestoreStazioni /* implements riconsegnaBici,corsa,prenotazione */ {

	// mappa per mantenere lo stato delle prenotazioni
	private Map<Stazione, Integer> statoStazioni;
	// mappa che associa i nomi alle relative stazioni
	private Map<String, Stazione> cercaStazioni;

	// serve per tenere traccia degli utenti che iniziano una nuova corsa prenotata
	private List<Prenotazione> prenotazioni;
	// liste delle corse in corso
	private List<Corsa> corse;

	private static GestoreStazioni istance = new GestoreStazioni();

	public GestoreStazioni() {
		// metodo che prende in input le stazioni
		Stazione stazione1 = new Stazione("San Donato");
		Stazione stazione2 = new Stazione("Porta Nuova");
		statoStazioni = new HashMap<Stazione, Integer>();
		cercaStazioni = new HashMap<String, Stazione>();
		prenotazioni = new LinkedList<Prenotazione>();
		statoStazioni.put(stazione1, 7);
		cercaStazioni.put(stazione1.getName(), stazione1);
		statoStazioni.put(stazione2, 7);
		cercaStazioni.put(stazione2.getName(), stazione2);
		corse = new LinkedList<Corsa>();
		prenotazioni = new LinkedList<Prenotazione>();
		System.out.println(cercaStazioni.get(stazione1.getName()).getName());
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
	public boolean nuovaCorsa(Corsa corsa) {

		throw new UnsupportedOperationException();
	}

	public boolean nuovaCorsaPrenotata(Prenotazione prenotazione) {
		throw new UnsupportedOperationException();
	}

	public Map<Stazione, Integer> getStatoStazioni() {
		return statoStazioni;
	}

	public List<Stazione> getStazioni() {
		System.out.println("OK");
		return new LinkedList<Stazione>(statoStazioni.keySet());
	}

	public static GestoreStazioni getIstance() {
		return istance;
	}

}