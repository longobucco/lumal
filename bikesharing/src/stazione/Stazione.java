package stazione;

import java.util.LinkedList;
import java.util.List;

import sistemacentrale.Prenotazione;

public class Stazione /* implements consegnaBici */ {

	private String name;
	private static int totali;
	private List<Postazione> stato;
	private int libere;
	private String ID;

	public Stazione(String name) {
		this.name = name;
		stato = new LinkedList<Postazione>();
		stato.add(new Postazione());
		totali = stato.size();
		libere = totali;

	}

	public List<Postazione> getStato() {
		return stato;
	}

	/**
	 *
	 * @param stato
	 */

	public int getOccupazione() {
		return libere-totali;
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