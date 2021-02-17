package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import sistemacentrale.Utente;
import view.DataInitializable;
import view.ViewDispatcher;
import view.ViewException;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable, DataInitializable<Utente> {
    @FXML
    private Button invioNotificheButton;

    @FXML
    private BorderPane visualizzatore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invioNotificheButton.setOnAction(event -> caricaVista("inviaMessaggi"));
    }

    @Override
    public void initializeData(Utente data) {

    }

    private void caricaVista(String vista) {
        try {
            var view = ViewDispatcher.getIstance().loadView(vista).getView();
            view.maxWidth(Double.MAX_VALUE);
            visualizzatore.setCenter(view);
        } catch (ViewException e) {
            e.printStackTrace();
        }
    }
}
