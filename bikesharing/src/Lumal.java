import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewDispatcher;

public class Lumal extends Application {
    private static String vista;

    public static void main(String[] args) {
        vista = args[0];
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Lumal");
        String vistaCaricata = "";

        // Inserite le altre viste qui
        if (vista.equals("1"))
            vistaCaricata = "dashboard";

        var view = ViewDispatcher.getIstance().loadView(vistaCaricata);
        stage.setScene(new Scene(view.getView(), 800, 600));
        stage.show();
    }
}