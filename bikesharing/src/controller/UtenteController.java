package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import sistemacentrale.Segnalazione;
import sistemacentrale.Utente;
import view.DataInitializable;
import view.ViewDispatcher;
import view.ViewException;

public class UtenteController implements Initializable, DataInitializable<Utente> {

	@FXML
	private BorderPane principale;

	@FXML
	private TextArea campoNotifiche;

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
		this.dispatcher = ViewDispatcher.getIstance();
	}

	@Override
	public void initializeData(Utente data) {

	}

	@FXML
	public void prenotazioneAction(ActionEvent event) {
		try {
			var view = dispatcher.loadView("interfacciaPrenotazione").getView();
			principale.setCenter(view);
		} catch (ViewException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void segnalazioneAction(ActionEvent event) {
		try {
			var view = dispatcher.loadView("inviaSegnalazione").getView();
			principale.setCenter(view);
		} catch (ViewException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		campoNotifiche.setEditable(false);
		try {
			File notifiche = new File("C:/Users/Alessandro Di Cicco/lumal/bikesharing/data/notifiche.txt");
			if (notifiche.exists()) {
				var reader = new BufferedReader(
						new FileReader("C:/Users/Alessandro Di Cicco/lumal/bikesharing/data/notifiche.txt"));
				String titolo = reader.readLine();
				String descrizione = reader.readLine();
				reader.close();
				if (titolo != null && descrizione != null) {
					campoNotifiche.setText(titolo + "\n" + descrizione);
				}
			}
			if (!notifiche.exists()) {
				campoNotifiche.setText("Non hai nuove notifiche");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}