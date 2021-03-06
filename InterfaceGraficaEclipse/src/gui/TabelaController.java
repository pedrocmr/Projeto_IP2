package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Hotel;
import modelo.Quarto;
import repositorio.RepositorioHotelArray;


public class TabelaController extends Application implements Initializable{
	 public static ArrayList<Quarto> quartoss = new ArrayList<Quarto>();
	private static Stage stage;
	
	@FXML private AnchorPane root;
    @FXML private TableView<Hotel> tabela;
    @FXML private TableColumn<Hotel, Boolean> selectCol;
    @FXML private TableColumn<Hotel, String> clnNome;
    @FXML private TableColumn<Hotel, Integer> clnQuartos;
    @FXML private TableColumn<Hotel, String> clnEndereco;
    @FXML private Button btVoltar;
    @FXML private Text txtTitulo;
    @FXML private Button btAvancar;
    @FXML private ImageView imagem;
    

    @FXML
    void avancaTela(ActionEvent event) {
    	
    	btAvancar.setOnMouseClicked((MouseEvent mouse) -> {
    		if(tabela.getSelectionModel().getSelectedItem() != null) {
			        	
    				RepositorioHotelArray repoHotel = new RepositorioHotelArray();
    				Hotel hotel ;
    				if(tabela.getSelectionModel().getSelectedItem().equals(repoHotel.getHoteis().get(0)) ) {
    					  quartoss =  repoHotel.getHoteis().get(0).getQuartos();
    					telaReserva(quartoss);
    				}
    				else if(tabela.getSelectionModel().getSelectedItem().equals(repoHotel.getHoteis().get(1))){
    					 quartoss =  repoHotel.getHoteis().get(1).getQuartos();
    					telaReserva(quartoss);
    				}
    				
    				else if(tabela.getSelectionModel().getSelectedItem().equals(repoHotel.getHoteis().get(2))){
    					 quartoss =  repoHotel.getHoteis().get(2).getQuartos();
    					telaReserva(quartoss);
    				}
    				
    			
    		}
		});
    
    }

    @FXML
    void voltar(ActionEvent event) {

    	btVoltar.setOnMouseClicked((MouseEvent mouse) -> {
			proximaTela();
		});
		
		btVoltar.setOnKeyPressed((KeyEvent enter) -> {
			if(enter.getCode().equals(KeyCode.ENTER)) {
			proximaTela();
			}
		});
    }

    
	@Override
	public void start(Stage stage) throws Exception {
		
		AnchorPane root = FXMLLoader.load(getClass().getResource("Tabela.fxml"));
		Scene scene = new Scene(root, 735, 500);

		// COLOCANDO T�TULO
		stage.setTitle("HOST4U - Hot�is");
		Image imagem = new Image("imagens/iconehotel.png");
		stage.getIcons().add(imagem);

		// GERANDO TELA
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
		setStage(stage);
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		inicializaTabela();
		RepositorioHotelArray repHotel ;
		repHotel = new RepositorioHotelArray();
		repHotel.listarHotelPG(0);
		repHotel.listarHotelBV(1);
		repHotel.listarHotelTM(2);
		
		
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		TabelaController.stage = stage;
	}
	
	public void fecharTela() {
		TabelaController.getStage().close();
	}
	
	public void proximaTela() {
		
		HomeController hc = new HomeController();
		
		
		try {
			hc.start(new Stage());
			fecharTela();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void telaReserva(ArrayList<Quarto> q) {
		
		ReservaController rc = new ReservaController();
		
		
		try {
			rc.start(new Stage());
			fecharTela();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
   public void inicializaTabela() {
	    selectCol.setCellValueFactory(new PropertyValueFactory<>("Selecionado"));
		clnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		clnQuartos.setCellValueFactory(new PropertyValueFactory<>("qtdQuartos"));
		clnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		
		 selectCol.setCellFactory(
				CheckBoxTableCell.forTableColumn(selectCol)
				);
		
		tabela.setItems(listaTabela());
		
	}
   
   public ObservableList<Hotel> listaTabela(){
		RepositorioHotelArray rH = new RepositorioHotelArray();
		return FXCollections.observableArrayList(rH.listarHoteis());
	}
  
   
	public static void main(String[] args) {

		launch(args);
	}

	

}
