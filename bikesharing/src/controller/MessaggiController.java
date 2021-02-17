package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sistemacentrale.Utente;
import view.DataInitializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MessaggiController implements Initializable, DataInitializable<Utente> {
    @FXML
    private TextField titoloField;

    @FXML
    private TextField contenutoField;

    @FXML
    private Label warningLabel;

    @FXML
    private Button invioButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titoloField.textProperty().addListener((o -> updateLimiti()));
        contenutoField.textProperty().addListener(o -> updateLimiti());
        invioButton.setOnAction(e -> inviaNotifica());
    }

    @Override
    public void initializeData(Utente data) {

    }

    private void updateLimiti() {
        String titolo = titoloField.getText();
        String contenuto = contenutoField.getText();

        if (titolo.length() > 30) {
            warningLabel.setText("Il titolo della notifica non deve superare i 30 caratteri!");
            invioButton.setDisable(true);
        }
        else if (contenuto.length() > 50) {
            warningLabel.setText("Il contenuto della notifica non deve superare i 50 caratteri!");
            invioButton.setDisable(true);
        }
        else if (titolo.length() == 0 || contenuto.length() == 0) {
            warningLabel.setText("");
            invioButton.setDisable(true);
        }
        else {
            warningLabel.setText("");
            invioButton.setDisable(false);
        }
    }

    private void inviaNotifica() {
        titoloField.setText("");
        contenutoField.setText("");
        warningLabel.setText("Notifica inviata agli utenti!");
    }
}