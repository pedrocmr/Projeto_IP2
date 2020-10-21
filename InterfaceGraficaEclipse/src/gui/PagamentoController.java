package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PagamentoController extends Application {

	private static Stage stage;

	public void start(Stage stage) throws Exception {

		AnchorPane root = FXMLLoader.load(getClass().getResource("/gui/Pagamento.fxml"));

		Scene scene = new Scene(root, 700, 500);

		stage.setTitle("HOST4U - Pagamento");
		Image imagem = new Image("imagens/iconehotel.png");
		stage.getIcons().add(imagem);

		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

		setStage(stage);// SETTANDO CENA

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		PagamentoController.stage = stage;
	}

	public static void main(String[] args) {

		launch(args);
	}

}
