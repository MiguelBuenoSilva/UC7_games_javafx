package br.senac.sp.gamesjavafx.ui.jogos;

import br.senac.sp.gamesjavafx.model.Estudio;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PainelEstudios {

    private Stage stage;

    public VBox criarPainelEstudio (){
        VBox painelEstudios = new VBox();
        painelEstudios.setPadding(new Insets(5, 20, 20, 20));
        painelEstudios.setStyle("-fx-background-color: #2e2b68");


        // Título painel jogos
        Label lblTitulo = new Label("Listagem de Estudios");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff; -fx-font-weight: bold");

        //Linha abaixo do label
        Separator linha = new Separator();

        //Criar uma tabela de listagem de dados
        TableView<Estudio> tabelaEstudios = new TableView<>();

        //Criar colunas na tabela Estudios
        TableColumn<Estudio,Integer> colunaEstudio_Id= new TableColumn<>("Estudio_ID");
        colunaEstudio_Id.setCellValueFactory(new PropertyValueFactory<>("estudio_id"));
        colunaEstudio_Id.setPrefWidth(40);
        //Adicionar o label no painel
        painelEstudios.getChildren().addAll(lblTitulo, linha);

        return painelEstudios;
    }
}
