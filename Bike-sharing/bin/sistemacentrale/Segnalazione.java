package sistemacentrale;

public class Segnalazione {

	private Enumeration categoria;
	private Operatore operatore;

	public Operatore getOperatore() {
		return this.operatore;
	}

	/**
	 * 
	 * @param operatore
	 */
	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

}