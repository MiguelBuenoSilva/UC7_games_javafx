package br.senac.sp.gamesjavafx.ui.jogos;

import br.senac.sp.gamesjavafx.data.repository.JogoRepository;
import br.senac.sp.gamesjavafx.data.repository.PlataformaRepository;
import br.senac.sp.gamesjavafx.model.Jogo;
import br.senac.sp.gamesjavafx.model.Plataforma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

import java.time.LocalDate;
import java.util.Optional;


public class TelaJogo {


    private TextField tfId = new TextField();
    private TextField tfTitulo = new TextField();
    private TextField tfPreco = new TextField();
    private ComboBox<Plataforma> comboPlataforma = new ComboBox<>();
    private ComboBox<String> comboEstudio = new ComboBox<>();
    private ComboBox<String> comboCategoria = new ComboBox<>();
    private DatePicker dpDataLacamento = new DatePicker();
    private CheckBox cbFinalizado = new CheckBox("Finalizado");


    public TelaJogo(Jogo jogo) {
        PlataformaRepository plataformaRepository = new PlataformaRepository();

        tfId.setText(String.valueOf(jogo.getId()));
        tfTitulo.setText(jogo.getTitulo());
        tfPreco.setText(String.valueOf(jogo.getPreco()));
        comboPlataforma.setItems(plataformaRepository.getPlataformas());
        comboEstudio.setValue(jogo.getEstudio());
        comboCategoria.setValue(jogo.getCategoria());
        dpDataLacamento.setValue(jogo.getDataLancamento());
        cbFinalizado.setSelected(jogo.isFinalizado());


    }

    public TelaJogo() {
    }


    public void criarTela(Stage stagePai) {

        Stage stage = new Stage();
        stage.initOwner(stagePai);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setMaxWidth(500);
        stage.setHeight(500);
        stage.setTitle("Cadastro de Jogo");

        BorderPane raiz = new BorderPane();
        raiz.setTop(criarPainelTitulo());
        raiz.setCenter(criarFormulario());
        raiz.setBottom(criarPainelBotoes(stage));

        Scene cena = new Scene(raiz, 500, 700);


        stage.setResizable(false);
        stage.setScene(cena);
        stage.showAndWait();

    }

    public HBox criarPainelTitulo() {

        HBox painelTitulo = new HBox();

        painelTitulo.setPadding(new Insets(20, 0, 20, 20));
        painelTitulo.setStyle("-fx-background-color:#2e2b68; ");
        painelTitulo.setAlignment(Pos.CENTER_LEFT);

        Image image = new Image(getClass().getResourceAsStream("/imagens/icons/binoculars2.png"));
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        Label lblTitulo = new Label("Cadastro de Jogos");
        painelTitulo.getChildren().addAll(imageView, lblTitulo);
        lblTitulo.setStyle("-fx-font-size: 28; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: #ffffff;");

        return painelTitulo;
    }

    private VBox criarFormulario() {

        PlataformaRepository plataformaRepository = new PlataformaRepository();

        ObservableList<Plataforma> plataformas = plataformaRepository.getPlataformas();


        ObservableList<String> estudios = FXCollections.observableArrayList(
                "Rockstar Games", "Naughty Dog", "Santa Monica Studio", "Insomniac Games", "Ubisoft", "Electronic Arts", "Activision", "Bethesda Game Studios",
                "CD Projekt Red", "Square Enix", "Capcom", "Konami", "Bandai Namco", "343 Industries", "The Coalition", "Guerrilla Games", "FromSoftware",
                "Epic Games", "Valve", "Nintendo"
        );

        ObservableList<String> categoria = FXCollections.observableArrayList(
                "Ação", "Aventura", "RPG", "FPS", "Estratégia", "Simulação", "Esporte",
                "Corrida", "Luta", "Plataforma", "Terror"

        );

        VBox formulario = new VBox();
        formulario.setPadding(new Insets(20));

        GridPane gridFormulario = new GridPane(5, 5);
        gridFormulario.setGridLinesVisible(false);
        gridFormulario.setPadding(new Insets(20));
        gridFormulario.setStyle("-fx-border-width: 2; -fx-border-color: #2e2b68;-fx-border-radius: 32");


        // Criar os componentes que seram importados no grid
        Label lblId = new Label("ID:");
        tfId.setDisable(true);

        Label lblTitulo = new Label("Título: ");
        tfTitulo.setPromptText("Ex: Mario");

        Label lblPlataforma = new Label("Plataformas: ");
        comboPlataforma.setItems(plataformas);


        Label lblEstudio = new Label("Estudios:");
        comboEstudio.setItems(estudios);

        Label lblCategoria = new Label("Categoria:");
        comboCategoria.setItems(categoria);

        Label lblValor = new Label("Preco: ");
        tfPreco.setPromptText("Ex.9.99");

        Label lblDatalancamento = new Label("Data de Lançamento: ");
        dpDataLacamento = new DatePicker(LocalDate.now());


        // Add os componentes no GRID

        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);

        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);

        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);

        gridFormulario.add(lblEstudio, 0, 3);
        gridFormulario.add(comboEstudio, 1, 3);

        gridFormulario.add(lblCategoria, 0, 4);
        gridFormulario.add(comboCategoria, 1, 4);

        gridFormulario.add(lblValor, 0, 5);
        gridFormulario.add(tfPreco, 1, 5);

        gridFormulario.add(lblDatalancamento, 0, 6);
        gridFormulario.add(dpDataLacamento, 1, 6);

        gridFormulario.add(cbFinalizado, 1, 7);


        formulario.getChildren().add(gridFormulario);

        return formulario;
    }

    private HBox criarPainelBotoes(Stage stage) {
        HBox painelBotoes = new HBox(10);
        painelBotoes.setStyle("-fx-background-color: #832929");
        painelBotoes.setPadding(new Insets(10));
        painelBotoes.setAlignment(Pos.BOTTOM_RIGHT);

        Button btnSalvar = new Button();
        Image imgSalvar = new Image(getClass().getResourceAsStream("/imagens/icons/save.png"));
        ImageView ivSalvar = new ImageView(imgSalvar);
        btnSalvar.setGraphic(ivSalvar);
        btnSalvar.setTooltip(new Tooltip("Salvar dados do jogo"));

        btnSalvar.setOnAction(evento -> {
            Jogo jogo = new Jogo();
            jogo.setTitulo(tfTitulo.getText());
            jogo.setPlataforma(comboPlataforma.getValue().getId());
            jogo.setEstudio(comboEstudio.getValue());
            jogo.setDataLancamento(dpDataLacamento.getValue());
            jogo.setCategoria(comboCategoria.getValue());
            jogo.setFinalizado(cbFinalizado.isSelected());

            try {
                jogo.setPreco(Double.parseDouble(tfPreco.getText().replace(",",".")));
            } catch (NumberFormatException error) {
                Alert valorIncorreto = new Alert(Alert.AlertType.ERROR);
                valorIncorreto.setTitle("Valor Incorreto");
                valorIncorreto.setHeaderText("O valor digitado deve conter apenas números! \nUtilize ponto ou virgula como separador de decimal");
                valorIncorreto.showAndWait();
                tfPreco.requestFocus();
                return;
            }


            //Criar o repositorio para enviar o jogo
            JogoRepository repository = new JogoRepository();

            if (tfId.getText().equals("")) {
                repository.salvar(jogo);

                //Mostra a mensagem do pós-salvar
                Alert mensagemSalvar = new Alert(Alert.AlertType.CONFIRMATION);
                mensagemSalvar.setTitle("Cadastro de jogo");
                mensagemSalvar.setHeaderText("O jogo gravado com sucesso!");
                mensagemSalvar.setContentText("Deseja cadastrar outro jogo?");

                Optional<ButtonType> escolha = mensagemSalvar.showAndWait();

                if (escolha.get() == ButtonType.OK) {
                    limparCampos();
                } else {
                    stage.close();
                }


            } else {
                jogo.setId(Integer.parseInt(tfId.getText()));
                repository.editar(jogo);

                //Mostra mensagem a pós-editar
                Alert mensagemEditar = new Alert(Alert.AlertType.CONFIRMATION);
                mensagemEditar.setTitle("Atualização de jogo");
                mensagemEditar.setHeaderText("O jogo foi atualizado com sucesso!");

                mensagemEditar.showAndWait();
                stage.close();


            }

//            JOptionPane.showMessageDialog(
//                    null,
//                    "Jogo cadastrado com sucesso!",
//                    "Erro",
//                    JOptionPane.ERROR_MESSAGE
//            );

//            int resposta = JOptionPane.showConfirmDialog(
//                    null,
//                    "Jogo cadastrado com sucesso!\nDeseja cadastrar outro jogo?",
//                    "Cadastro",
//                    JOptionPane.YES_NO_OPTION
//
//            );
//
//            if (resposta != 0) {
//                stage.close();
//            }
        });

        Button btnCancelar = new Button();
        Image imgCancelar = new Image(getClass().getResourceAsStream("/imagens/icons/cancel.png"));
        ImageView ivCancelar = new ImageView(imgCancelar);
        btnCancelar.setGraphic(ivCancelar);
        btnCancelar.setTooltip(new Tooltip("Cancelar dados do jogo"));

        painelBotoes.getChildren().addAll(btnSalvar, btnCancelar);

        return painelBotoes;
    }

    private void limparCampos() {

        tfTitulo.clear();
        comboPlataforma.getSelectionModel().clearSelection();
        tfPreco.clear();
        comboEstudio.setValue("");
        cbFinalizado.setSelected(false);
        dpDataLacamento.setValue(LocalDate.now());
        tfTitulo.requestFocus();
    }
}


