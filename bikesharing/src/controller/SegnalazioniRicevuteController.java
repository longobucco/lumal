package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import sistemacentrale.Segnalazione;
import sistemacentrale.Utente;
import view.DataInitializable;

public class SegnalazioniRicevuteController implements Initializable, DataInitializable<Utente> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox segnalazioneBox;

    @FXML
    private Label categoriaSegnalazione;

    @FXML
    private Label descrizioneSegnalazione;

    @FXML
    private Label vuotoLabel;

    @FXML
    private ListView<Segnalazione> segnalazioniList;

    private ObservableList<Segnalazione> segnalazioni;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        segnalazioni = FXCollections.observableArrayList();
        segnalazioniList.setItems(segnalazioni);

        caricaSegnalazioni();

        setCellFactory();
        setSelectionListener();
    }

    @Override
    public void initializeData(Utente data) { }

    /**
     * Per ogni Segnalazione nella lista ne mostra la categoria
     */
    private void setCellFactory() {
        segnalazioniList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Segnalazione s, boolean empty) {
                super.updateItem(s, empty);
                if (empty)
                    setText("");
                else setText(s.getCategoria());
            }
        });
    }

    /**
     * Aggiorna la sezione del titolo e della descrizione ogni volta che si seleziona un elemento nella lista
     */
    private void setSelectionListener() {
        segnalazioniList.getSelectionModel().selectedItemProperty().addListener((o, previous, current) -> {
            if (current == null) {
                categoriaSegnalazione.setText("");
                descrizioneSegnalazione.setText("");
            } else {
                categoriaSegnalazione.setText(current.getCategoria());
                descrizioneSegnalazione.setText(current.getDescrizione());
            }
        });
    }

    private void caricaSegnalazioni() {
        try {
            int i = 0;
            var reader = new BufferedReader(new FileReader( "C:/Users/Alessandro Di Cicco/lumal/bikesharing/data/" + "segnalazioni.txt"));
            String line = reader.readLine();
            Segnalazione segnalazione = new Segnalazione();

            for (; line != null; i++) {
                if (i % 2 == 0) segnalazione.setCategoria(line);
                else if (i % 2 == 1)
                {
                    segnalazione.setDescrizione(line);
                    segnalazioni.add(segnalazione);
                    segnalazione = new Segnalazione();
                }

                line = reader.readLine();
            }
            reader.close();

            if (i == 0) vuotoLabel.setText("Non ci sono segnalazioni!");
            else segnalazioneBox.setVisible(true);

        } catch (IOException e) { e.printStackTrace(); }
    }
}