package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sistemacentrale.Segnalazione;
import sistemacentrale.Utente;
import view.DataInitializable;

public class SegnalazioniRicevuteController implements Initializable, DataInitializable<Utente> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initializeData(Utente data) { }
}