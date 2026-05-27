package br.senac.sp.gamesjavafx.ui.jogos;

import br.senac.sp.gamesjavafx.model.Plataforma;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PainelPlataformas {
    private Stage stage;

    public VBox criarPainelPlataforma() {
        VBox painelPlataformas = new VBox();
        painelPlataformas.setPadding(new Insets(5, 20, 20, 20));
        painelPlataformas.setStyle("-fx-background-color: #2e2b68");


        // Título painel jogos
        Label lblTitulo = new Label("Listagem de Plataformas");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff; -fx-font-weight: bold");

        //Linha abaixo do label
        Separator linha = new Separator();

        TableView<Plataforma> tabelaPlataforma = new TableView<>();


        //Adicionar o label no painel
        painelPlataformas.getChildren().addAll(lblTitulo, linha, tabelaPlataforma);


        //Criar colunas da tabela

        TableColumn<Plataforma, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(40);

        TableColumn<Plataforma, String> colunaNome = new TableColumn<>("NOME");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaNome.setPrefWidth(100);

        TableColumn<Plataforma, String> colunaFabricante = new TableColumn<>("FABRICANTE");
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        colunaFabricante.setPrefWidth(100);

        TableColumn<Plataforma, Double> colunaPreco = new TableColumn<>("PREÇO");
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colunaPreco.setPrefWidth(70);

        TableColumn<Plataforma, LocalDate> colunaDataLancamento = new TableColumn<>("LANÇAMENTO");
        colunaDataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        colunaDataLancamento.setPrefWidth(100);

        tabelaPlataforma.getColumns().addAll(colunaId, colunaNome, colunaFabricante,colunaDataLancamento, colunaPreco);



        HBox painelBotoes = new HBox(10);

//        Button botaoAdicionar = criarBotao("Adicionar", "/imagens/icons/plus-add.png");
//
//        Button btnVisualizar = criarBotao("Visualizar", "/imagens/icons/binoculars.png");
//
//
//        Button btnEditar = criarBotao("Editar", "/imagens/icons/pen.png");
//
//
//        Button btnExcluir = criarBotao("Excluir", "/imagens/icons/letter-x.png");

        return painelPlataformas;
    }
//    private Button criarBotao(String textoBotao, String urlImagem) {
//        Image image = new Image(getClass().getResourceAsStream(urlImagem));
//        ImageView imageView = new ImageView(image);
//
//        imageView.setFitWidth(20);
//        imageView.setFitHeight(20);
//        Button button = new Button();
//        button.setPrefWidth(110);
//        button.setPrefHeight(50);
//        button.setText(textoBotao);
//        button.setGraphic(imageView);
//
//        return button;
//
//
//    }

}
