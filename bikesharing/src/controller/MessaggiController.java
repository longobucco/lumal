package controller;

import javafx.fxml.Initializable;
import sistemacentrale.Utente;
import view.DataInitializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MessaggiController implements Initializable, DataInitializable<Utente> {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller di messaggi caricato");
    }

    @Override
    public void initializeData(Utente data) {

    }
}