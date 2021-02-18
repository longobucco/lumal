package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import sistemacentrale.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import view.DataInitializable;

public class SegnalazioneController implements Initializable, DataInitializable<Utente> {

    @FXML
    private TextField testoSegnalazione;
	
    @FXML
    private ChoiceBox<String> sceltaSegnalazione;

    @FXML
    private Button invioSegnalazione;

    @FXML
    void invioButton(ActionEvent event) {
    	try {
    		  // ATTENZIONE: modificare percorso
              File file = new File ("C:/Users/user/git/lumal/bikesharing/data/" + "segnalazioni.txt");
              BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
              bw.append( sceltaSegnalazione.getValue().toString()+ "\n");     
              bw.append( testoSegnalazione.getText().toString()+ "\n");   
              bw.close();
              
        	// Conferma invio
      		Alert successAlert = new Alert(AlertType.CONFIRMATION);
      		successAlert.setHeaderText("Conferma");
      		successAlert.setContentText("La tua segnalazione è stata inviata al Supporto");
      		successAlert.showAndWait();
            } catch (IOException e) {
              e.printStackTrace();
        	  Alert errorAlert = new Alert(AlertType.ERROR);
          	  errorAlert.setHeaderText("Errore");
          	  errorAlert.setContentText("Si è verificato un problema");
              errorAlert.showAndWait();
            }
    }

	public void initialize(URL location, ResourceBundle resources) {
		sceltaSegnalazione.getItems().addAll("Sblocco", "Pagamento", "Postazione", "Prenotazione", "Veicolo", "Altro");
		
	}

	@Override
	public void initializeData(Utente data) {
		// TODO Auto-generated method stub
		
	};
    
}
