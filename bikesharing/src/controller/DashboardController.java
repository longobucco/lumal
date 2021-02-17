package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sistemacentrale.Utente;
import view.DataInitializable;
import view.ViewDispatcher;
import view.ViewException;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class DashboardController implements Initializable, DataInitializable<Utente> {
    @FXML
    private Button invioMessaggiButton;

    @FXML
    private AnchorPane visualizzatore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invioMessaggiButton.setOnAction(event -> caricaVista("inviaMessaggi"));
    }

    @Override
    public void initializeData(Utente data) {

    }

    private void caricaVista(String vista) {
        try {
            visualizzatore.getChildren().add(ViewDispatcher.getIstance().loadView(vista).getView());
        } catch (ViewException e) {
            e.printStackTrace();
        }
    }
}
