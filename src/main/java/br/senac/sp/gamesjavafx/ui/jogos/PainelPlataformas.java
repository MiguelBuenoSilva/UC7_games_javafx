package br.senac.sp.gamesjavafx.ui.jogos;

import br.senac.sp.gamesjavafx.model.Plataforma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


        // Título painel PLATAFORMAS
        Label lblTitulo = new Label("Listagem de Plataformas");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff; -fx-font-weight: bold");

        //Linha abaixo do label
        Separator linha = new Separator();

        TableView<Plataforma> tabelaPlataformas = new TableView<>();

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

        TableColumn<Plataforma, Double> colunaValor = new TableColumn<>("VALOR");
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaValor.setPrefWidth(70);

        TableColumn<Plataforma, LocalDate> colunaDataLancamento = new TableColumn<>("LANÇAMENTO");
        colunaDataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        colunaDataLancamento.setPrefWidth(100);

        tabelaPlataformas.getColumns().addAll(colunaId, colunaNome, colunaFabricante,colunaDataLancamento, colunaValor);



        // Criar botões de ações
        HBox painelBotoes = new HBox(10);

        Button botaoAdicionar = criarBotao("Adicionar", "/imagens/icons/plus-add.png");
//        TelaPlataforma telaPlataforma = new TelaPlataforma();
//        telaPlataforma.criarTelaPlataforma(stage);
//       // tabelaPlataformas.setItems(repository.getJogos());
//
//    });

        Button btnVisualizar = criarBotao("Visualizar", "/imagens/icons/binoculars.png");
//        btnVisualizar.setOnAction(event -> {
//        Plataforma visualizarPlataforma = tabelaPlataformas.getSelectionModel().getSelectedItem();
//        TelaPlataforma telaPlataforma = new TelaPlataforma(visualizarPlataforma);
//        telaPlataforma.criarTelaPlataforma(stage);
//
//    });


        Button btnEditar = criarBotao("Editar", "/imagens/icons/pen.png");
//              btnEditar.setOnAction(event -> {
//
//        //Recuperar jogo que quero editar
//        Jogo editarJogo = tabelaJogos.getSelectionModel().getSelectedItem();
//        TelaPlataforma telaPlataforma = new TelaPlataforma(editarPlataforma);
//        telaPlataforma.criarTela(stage);
//        tabelaPlataformas.setItems(repository.getJogos());
//
//    });

        Button btnExcluir = criarBotao("Excluir", "/imagens/icons/letter-x.png");

//    Plataforma excluirPlataforma = tabelaJogos.getSelectionModel().getSelectedItem();
//
//            if (excluirPlataforma == null){
//        Alert alertaJogoNaoSelecionado = new Alert(Alert.AlertType.WARNING);
//        alertaJogoNaoSelecionado.setTitle("Exclusão de Plataforma");
//        alertaJogoNaoSelecionado.setHeaderText("Para excluir uma plataforma você deve selecioná-lo na lista.");
//        alertaJogoNaoSelecionado.showAndWait();
//        return;
//    }
//
//    Alert confirmaExclusao = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmaExclusao.setTitle("Exclusão de Plataforma");
//            confirmaExclusao.setHeaderText("Você está prestes a excluir uma plataforma.");
//            confirmaExclusao.setContentText("Tem certeza que deseja continuar?");
//
//    Optional<ButtonType> resposta = confirmaExclusao.showAndWait();
//    ButtonType botaoSelecionado = resposta.get();
//
//            if (botaoSelecionado == ButtonType.OK) {
//        repository.excluir(excluirPlataforma.getId());
//        tabelaJogos.setItems(repository.getJogos());
//    }
//
//});
        painelBotoes.setAlignment(Pos.BOTTOM_RIGHT);
        painelBotoes.getChildren().addAll(botaoAdicionar, btnEditar,  btnVisualizar, btnExcluir);

        //Adicionar o label no painel
        painelPlataformas.getChildren().addAll(lblTitulo, linha, tabelaPlataformas, painelBotoes);

        return painelPlataformas;
    }



    private Button criarBotao(String textoBotao, String urlImagem) {
        Image image = new Image(getClass().getResourceAsStream(urlImagem));
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Button button = new Button();
        button.setPrefWidth(110);
        button.setPrefHeight(50);
        button.setText(textoBotao);
        button.setGraphic(imageView);

        return button;

    }

}
