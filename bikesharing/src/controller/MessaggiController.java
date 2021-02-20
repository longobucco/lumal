package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import sistemacentrale.Utente;
import view.DataInitializable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
    @FXML
    void inviaNotifica(ActionEvent event) {
        System.out.println("Invio notifiche");
    	try {
  		  // ATTENZIONE: modificare percorso
            File file = new File ("C:/Users/Alessandro Di Cicco/lumal/bikesharing/data/notifiche.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            bw.append( titoloField.getText().toString()+ "\n");     
            bw.append( contenutoField.getText().toString()+ "\n");   
            bw.close();
            
      	// Conferma invio
    		Alert successAlert = new Alert(AlertType.CONFIRMATION);
    		successAlert.setHeaderText("Conferma");
    		successAlert.setContentText("La notifica è stata inviata con successo");
    		successAlert.showAndWait();
          } catch (IOException e) {
            e.printStackTrace();
      	  Alert errorAlert = new Alert(AlertType.ERROR);
        	  errorAlert.setHeaderText("Errore");
        	  errorAlert.setContentText("Si è verificato un problema");
            errorAlert.showAndWait();
          }
    }
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/maca99/lumal
}