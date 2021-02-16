package view;

import java.io.IOException;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import sistemacentrale.Utente;

public class ViewDispatcher {
	
	private static final String FXML_SUFFIX = ".fxml";
	private static final String RESOURCE_BASE = "/view/";
	public static ViewDispatcher istance = new ViewDispatcher();
	
	private Stage stage;
	private BorderPane layout;

	private ViewDispatcher() {
	}
	
	public void loginView(Stage stage) throws ViewException {
		
		this.stage = stage;
		stage.setResizable(false);
		Parent loginView = loadView("login").getView();
		Scene scene = new Scene(loginView);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void loggedIn(Utente utente) {
		try {
		View <Utente> layoutView = loadView("layout");
		//Deve essere invocato il metodo initializeData per fornire al controllore di
		//layout l'utente
		DataInitializable<Utente> layoutController = layoutView.getController();
		layoutController.initializeData(utente);
		layout = (BorderPane) layoutView.getView();
		//Anche in questo caso viene passato l'utente perche' nella vista di
		//benvenuto il testo varia a seconda se e' docente od utente
		renderView("home", utente);
		Scene scene = new Scene(layout);
		
		scene.getStylesheets().add(
				getClass().getResource(RESOURCE_BASE + "style.css").toExternalForm());
		stage.setScene(scene);
		} catch (ViewException e) {
		renderError(e);
		}
		}

	public void renderError(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	public <T> View<T> loadView(String viewName) throws ViewException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(RESOURCE_BASE + viewName + FXML_SUFFIX));

			Parent parent = (Parent) loader.load();
			return new View<>(parent, loader.getController());
		} catch (IOException e) {
			throw new ViewException(e);
		}
	}
	
	public static ViewDispatcher getIstance() {
		return istance;
	}

	public void logout() {
		try {
		Parent loginView = loadView("login").getView();
		Scene scene = new Scene(loginView);
		stage.setScene(scene);
		} catch (ViewException e) {
		renderError(e);
		}
	}
	//metodo per la registrazione
	public void signIn(String utente) {
		try {
			Parent loginView = loadView("sign"+ utente ).getView();
			Scene scene = new Scene(loginView);
			stage.setScene(scene);
		} catch(ViewException e) {
			renderError(e);
		}
		
	}
	
	
	public <T> void renderView(String viewName, T data) {
		try {
			
			View<T> view = loadView(viewName);
			DataInitializable<T> controller = view.getController();
			controller.initializeData(data);
			layout.setCenter(view.getView());
			
		} catch (ViewException e) {
			renderError(e);
		}
	}
	
}



