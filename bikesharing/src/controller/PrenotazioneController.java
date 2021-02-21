package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sistemacentrale.*;
import stazione.Stazione;
import view.DataInitializable;
import view.ViewDispatcher;

public class PrenotazioneController implements Initializable, DataInitializable<Utente> {

    @FXML
    private TableView<Stazione> prenotazioneTable;
    @FXML
    private TableColumn<Stazione,String> stazioneColumn;
    @FXML
    private TableColumn<Stazione,Button> prenotaColumn;

    private ViewDispatcher dispatcher;
    private ServiziUtente service;

    public PrenotazioneController() {
        this.dispatcher = ViewDispatcher.getIstance();
        Utente utente = new Utente();
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @Override
    public void initializeData(Utente data) {
        // this.utente=utente;
        // prenotazione = new Prenotazione(utente);
        stazioneColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        prenotaColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Stazione, Button>,ObservableValue<Button>>(){
                    @Override
                    public ObservableValue<Button> call(CellDataFeatures<Stazione, Button> param) {
                        final Button prenotaButton = new Button("Prenota");
                        prenotaButton.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent event) {

                                dispatcher.renderView("prenotazione", null);
                            }
                        });
                        return new SimpleObjectProperty<Button>(prenotaButton);
                    }

                });
        
        
        ObservableList<Stazione> allStazioni = FXCollections.observableArrayList(service.getAllStazioni());
        prenotazioneTable.setItems(allStazioni);

    }

}