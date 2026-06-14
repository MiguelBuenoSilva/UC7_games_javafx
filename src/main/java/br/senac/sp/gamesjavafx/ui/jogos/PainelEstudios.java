package br.senac.sp.gamesjavafx.ui.jogos;

import br.senac.sp.gamesjavafx.data.repository.EstudioRepository;
import br.senac.sp.gamesjavafx.model.Estudio;
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
import java.util.Optional;

public class PainelEstudios {

    private Stage stage;

    public VBox criarPainelEstudio() {
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
        TableColumn<Estudio, Integer> colunaEstudio_Id = new TableColumn<>("ESTUDIO_ID");
        colunaEstudio_Id.setCellValueFactory(new PropertyValueFactory<>("estudio_id"));
        colunaEstudio_Id.setPrefWidth(100);

        TableColumn<Estudio, String> colunaNomeFundador = new TableColumn<>("NOME_FUNDADOR");
        colunaNomeFundador.setCellValueFactory(new PropertyValueFactory<>("nome_fundador"));
        colunaNomeFundador.setPrefWidth(100);

        TableColumn<Estudio, String> colunaNomeEstudio = new TableColumn<>("NOME_ESTUDIO");
        colunaNomeEstudio.setCellValueFactory(new PropertyValueFactory<>("nome_estudio"));
        colunaNomeEstudio.setPrefWidth(100);

        TableColumn<Estudio, LocalDate> colunaAnoFundacao = new TableColumn<>("ANO_FUNDAÇÃO");
        colunaAnoFundacao.setCellValueFactory(new PropertyValueFactory<>("ano_fundacao"));
        colunaAnoFundacao.setPrefWidth(100);

        TableColumn<Estudio, String> colunaPaisOrigem = new TableColumn<>("PAÍS_ORIGEM");
        colunaPaisOrigem.setCellValueFactory(new PropertyValueFactory<>("pais_origem"));
        colunaPaisOrigem.setPrefWidth(50);


        //Obter os dados que serão exibidos na Tabela

        EstudioRepository estudioRepo = new EstudioRepository();

        tabelaEstudios.getColumns().addAll(colunaEstudio_Id, colunaNomeEstudio, colunaNomeFundador,
                colunaAnoFundacao, colunaPaisOrigem);

        // Adicionando a lista de jogos na tabela
        tabelaEstudios.setItems(estudioRepo.getEstudios());

        // Criar botões de ações
        HBox painelBotoes = new HBox(10);

        Button botaoAdicionar = criarBotao("Adicionar", "/imagens/icons/plus-add.png");

        botaoAdicionar.setOnAction(e -> {
            TelaEstudio telaEstudio = new TelaEstudio();
            telaEstudio.criarTelaEstudio(stage);
            tabelaEstudios.setItems(estudioRepo.getEstudios());
        });


        Button btnVisualizar = criarBotao("Visualizar", "/imagens/icons/binoculars.png");

        btnVisualizar.setOnAction(event -> {

            Estudio visualizarEstudios = tabelaEstudios.getSelectionModel().getSelectedItem();

            if (visualizarEstudios == null) {
                Alert alertaJogoNaoSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaJogoNaoSelecionado.setTitle("Visualização de Plataforma");
                alertaJogoNaoSelecionado.setHeaderText("Para visualizar um plataforma você deve selecioná-lo na lista.");
                alertaJogoNaoSelecionado.showAndWait();
                return;
            }
            TelaEstudio telaEstudio = new TelaEstudio(visualizarEstudios);
            telaEstudio.criarTelaEstudio(stage);

        });


        Button btnEditar = criarBotao("Editar", "/imagens/icons/pen.png");

        btnEditar.setOnAction(event -> {
            Estudio editarEstudio = tabelaEstudios.getSelectionModel().getSelectedItem();

            //Recuperar plataforma que quero editar
            if (editarEstudio == null) {

                Alert alertaJogoNaoSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaJogoNaoSelecionado.setTitle("Edição de Plataforma");
                alertaJogoNaoSelecionado.setHeaderText("Para editar um plataforma você deve selecioná-lo na lista.");
                alertaJogoNaoSelecionado.showAndWait();
                return;
            }
            TelaEstudio telaEstudio = new TelaEstudio(editarEstudio);
            telaEstudio.criarTelaEstudio(stage);
            tabelaEstudios.setItems(estudioRepo.getEstudios());

        });

        Button btnExcluir = criarBotao("Excluir", "/imagens/icons/letter-x.png");
//
        Estudio excluirEstudio = tabelaEstudios.getSelectionModel().getSelectedItem();

        btnExcluir.setOnAction(event -> {
            if (excluirEstudio == null) {
                Alert alertaJogoNaoSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaJogoNaoSelecionado.setTitle("Exclusão de Plataforma");
                alertaJogoNaoSelecionado.setHeaderText("Para excluir uma plataforma você deve selecioná-lo na lista.");
                alertaJogoNaoSelecionado.showAndWait();
                return;
            }
            Alert confirmaExclusao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmaExclusao.setTitle("Exclusão de Plataforma");
            confirmaExclusao.setHeaderText("Você está prestes a excluir uma plataforma.");
            confirmaExclusao.setContentText("Tem certeza que deseja continuar?");

            Optional<ButtonType> resposta = confirmaExclusao.showAndWait();
            ButtonType botaoSelecionado = resposta.get();

            if (botaoSelecionado == ButtonType.OK) {
                estudioRepo.excluir(excluirEstudio.getId());

                tabelaEstudios.setItems(estudioRepo.getEstudios());
            }

        });
        //Adicionar o label no painel
        painelEstudios.getChildren().addAll(lblTitulo, linha, tabelaEstudios, painelBotoes);

        painelBotoes.setAlignment(Pos.BOTTOM_RIGHT);

        painelBotoes.getChildren().addAll(botaoAdicionar, btnEditar, btnVisualizar, btnExcluir);

        return painelEstudios;

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
