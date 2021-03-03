package stazione;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import sistemacentrale.Prenotazione;

public class Stazione /* implements consegnaBici */ {

	private String name;
	private static int totali;
	private Map<String,Postazione> stato;
	private int libere;
	private String ID;

	public Stazione(String name) {
		this.name = name;
		stato = new HashMap<String,Postazione>();
		stato.put("12354",new Postazione());
		stato.put("45656",new Postazione());
		stato.put("g5dr5",new Postazione());
		stato.put("bjt5d",new Postazione());
		totali = stato.size();libere = totali;

	}

	public List<Postazione> getStato() {
		return new LinkedList<Postazione>(stato.values());
	}

	public int getOccupazione() {
		return libere-totali;
	}

	public int getLiberi() {return libere;}

	public void setLiberi(int l) {
		libere = l;
	}

	public void notificaConsegnaBici() {

		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		
	}


}