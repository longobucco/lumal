package sistemacentrale;

public class Segnalazione {

	private String categoria;
	private String descrizione;

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

	public void setCategoria(String cat) {
		categoria = cat;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}