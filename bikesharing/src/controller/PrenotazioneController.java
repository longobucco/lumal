package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sistemacentrale.*;
import stazione.Stazione;
import view.DataInitializable;
import view.ViewDispatcher;

public class PrenotazioneController implements Initializable, DataInitializable<Object> {

	@FXML
	private TableView<Stazione> prenotazioneTable;

	@FXML
	private TableColumn<Stazione, Integer> biciColumn;

	@FXML
	private TableColumn<Stazione, String> stazioneColumn;

	@FXML
	private Button prenotaButton;

	@FXML
	private Label infoLabel;

	private ServiziUtente service;

	private Stazione selezionata;
	private Stazione prenotata;

	public PrenotazioneController() {
		Utente utente = new Utente();
		service = new ServiziUtente(utente);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// stazioneColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		stazioneColumn.setCellValueFactory(features -> new SimpleStringProperty(features.getValue().getName()));
		// biciColumn.setCellValueFactory(new PropertyValueFactory<>("occupazione"));
		biciColumn.setCellValueFactory(features -> new SimpleIntegerProperty(features.getValue().getLiberi()).asObject());

		// var stazioniObsv = FXCollections.observableArrayList(stazioni);
		var stazioniObsv = FXCollections.observableList(service.getAllStazioni());
		prenotazioneTable.setItems(stazioniObsv);

		prenotazioneTable.getSelectionModel().selectedItemProperty().addListener(((o, previous, current) -> updateSelezione(current)));
	}

	private void updateSelezione(Stazione stazione) {
		if (prenotata != null) {
			infoLabel.setText("Hai gia' prenotato un veicolo nella stazione \"" + prenotata.getName() + "\"");
			prenotaButton.setDisable(true);
		} else if (stazione.getLiberi() == 0) {
			infoLabel.setText("La stazione selezionata non ha mezzi disponibili!");
			prenotaButton.setDisable(true);
		} else {
			infoLabel.setText("");
			selezionata = stazione;
			prenotaButton.setDisable(false);
		}
	}

	@Override
<<<<<<< HEAD
	public void initializeData(Object data) {
		// this.utente=utente;
		// prenotazione = new Prenotazione(utente);
		System.out.println("vfmk");
		stazioneColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		biciColumn.setCellValueFactory(new PropertyValueFactory<>("libere"));
		prenotaColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Stazione, Button>, ObservableValue<Button>>() {
					@Override
					public ObservableValue<Button> call(CellDataFeatures<Stazione, Button> param) {
						final Button prenotaButton = new Button("Prenota");
						prenotaButton.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {

								dispatcher.renderView("prenotazione", null);
							}
						});
						return new SimpleObjectProperty<Button>(prenotaButton);
					}

				});

		ObservableList<Stazione> allStazioni = FXCollections.observableList(service.getAllStazioni());

		prenotazioneTable.setItems(allStazioni);
=======
	public void initializeData(Utente data) {
>>>>>>> refs/remotes/origin/main

	}

	@FXML
	private void onPrenota(ActionEvent event) {
		selezionata.setLiberi(selezionata.getLiberi() - 1);
		prenotata = selezionata;
		prenotaButton.setDisable(true);

		// Forza aggiornamento valori
		var obs = prenotazioneTable.getItems();
		obs.removeAll();
		FXCollections.copy(obs, service.getAllStazioni());

		infoLabel.setText("Prenotazione effettuata con successo!");
	}
}