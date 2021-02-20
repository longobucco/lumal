import stazione.Stazione;

public class ServiziUtente /* implements *****/  {

    private ServiziUtente istance;
    private Prenotazione prenotazione;
    private Corsa corsa;
    private Abbonamento abbonamento;
    private Utente utente;

    public ServiziUtente(Utente utente) {
        this.setUtente(utente);
        prenotazione=null;
        corsa=null;
        //facciamo finta che venga preso da un DB
        abbonamento = new Abbonamento();
    }

    private boolean verificaAbbonamento() {
        return false;

    }

    private boolean iniziaCorsa(String stazione) {
        if(corsa != null) return false;

        // se si Ã¨ giÃ  prenotati basta iniziare una corsa e
        if(prenotazione != null) {

        }
        return false;


    }

    public boolean prenotazione(Stazione stazione) {
        return false;

    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }


}