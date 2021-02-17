package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import view.DataInitializable;

public class SegnalazioneController {

    @FXML
    private TextField testoSegnalazione;
	
    @FXML
    private ChoiceBox<String> sceltaSegnalazione;

    @FXML
    private Button invioSegnalazione;

    @FXML
    void invioButton(ActionEvent event) {
    	try {
            // Crea file segnalazione
        	  
              StringBuilder sb =  new StringBuilder();
              sb.append( sceltaSegnalazione.getValue().toString()+ "\n");   
              sb.append( testoSegnalazione.getText().toString()+ "\n");       

              File file = new File ("segnalazioni" + ".txt");
              // if (!file.exists()) {
              FileWriter W = null;
              W = new FileWriter (file);
              W.write(sb.toString());
              W.close();
              
              File file1 = new File ("segnalazioni" + ".txt");
              BufferedWriter bw = new BufferedWriter(new FileWriter(file1, true));
              bw.append( sceltaSegnalazione.getValue().toString()+ "\n");     
              bw.append( testoSegnalazione.getText().toString()+ "\n");   
              bw.close();
              
        	// Success alert
      		Alert successAlert = new Alert(AlertType.CONFIRMATION);
      		successAlert.setHeaderText("Conferma");
      		successAlert.setContentText("La tua segnalazione è stata inviata al Supporto");
      		successAlert.showAndWait();
            } catch (IOException e) {
              e.printStackTrace();
            }
    }

	public void initialize(URL location, ResourceBundle resources) {
		sceltaSegnalazione.getItems().addAll("Sblocco", "Pagamento", "Postazione", "Prenotazione", "Veicolo", "Altro");
		
	};
    
}
