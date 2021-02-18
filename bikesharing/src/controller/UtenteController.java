package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import sistemacentrale.Utente;
import view.DataInitializable;
import view.ViewDispatcher;

public class UtenteController implements  Initializable, DataInitializable<Utente>{

    @FXML
    private BorderPane principale;
    @FXML
    private Button prenotaButton;
    @FXML
    private Button corsaButton;
    @FXML
    private Button abbonamentoButton;
    @FXML
    private Button segnalazioneButton;
    private Utente utente;
    private ViewDispatcher dispatcher;

    public UtenteController() {
        this.dispatcher=ViewDispatcher.getIstance();
    }


    @Override
    public void initializeData(Utente data) {


    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    @FXML
    public void prenotazioneAction(ActionEvent event) {

    }
    @FXML
    public void segnalazioneAction(ActionEvent event) {

    }



}