package sistemacentrale;

public class Segnalazione {

	// Questa dovrebbe essere una enumerazione implementata in un altro file!
	private int categoria;
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