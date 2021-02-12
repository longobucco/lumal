package stazione;

public class Stazione {

	private Boolean stato;
	private Double occupazione;
	private String ID;

	public Boolean getStato() {
		return this.stato;
	}

	/**
	 * 
	 * @param stato
	 */
	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public Double getOccupazione() {
		return this.occupazione;
	}

	public void notificaConsegnaBici() {
		// TODO - implement Stazione.notificaConsegnaBici
		throw new UnsupportedOperationException();
	}

}