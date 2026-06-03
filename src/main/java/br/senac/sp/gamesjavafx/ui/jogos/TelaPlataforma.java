package br.senac.sp.gamesjavafx.ui.jogos;

import br.senac.sp.gamesjavafx.data.repository.PlataformaRepository;
import br.senac.sp.gamesjavafx.model.Plataforma;
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

import java.time.LocalDate;
import java.util.Optional;

public class TelaPlataforma {

    private TextField tfId = new TextField();
    private TextField tfNome = new TextField();
    private ComboBox <Plataforma> comboPlataforma = new ComboBox<>();
    private TextField tfValor = new TextField();
    private TextField tfFabricante= new TextField();
    private DatePicker dpDataLacamento = new DatePicker();


    public TelaPlataforma(Plataforma plataforma) {

        tfId.setText(String.valueOf(plataforma.getId()));
        tfNome.setText(plataforma.getNome());
        tfValor.setText(String.valueOf(plataforma.getValor()));
        tfFabricante.setText(plataforma.getFabricante());
        dpDataLacamento.setValue(plataforma.getDataLancamento());


    }

    public TelaPlataforma() {
    }


    public void criarTelaPlataforma(Stage stagePai) {
        Stage stage = new Stage();
        stage.initOwner(stagePai);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setMaxWidth(500);
        stage.setHeight(500);
        stage.setTitle("Cadastro de Plataformas");

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

//        ObservableList<String> plataformas = FXCollections.observableArrayList(
//                "PlayStation 1", "PlayStation 2", "PlayStation 3", "PlayStation 4", "PlayStation 5", "Xbox 360",
//                "Xbox One", "Xbox Series X", "Xbox Series S", "Super Nintendo", "Nintendo 64", "Nintendo Switch",
//                "Master System", "Mega Drive", "PC"
//        );
        PlataformaRepository plataformaRepository = new PlataformaRepository();

       ObservableList<Plataforma> plataformas = plataformaRepository.getPlataformas();



        VBox formulario = new VBox();
        formulario.setPadding(new Insets(20));

        GridPane gridFormulario = new GridPane(5, 5);
        gridFormulario.setGridLinesVisible(false);
        gridFormulario.setPadding(new Insets(20));
        gridFormulario.setStyle("-fx-border-width: 2; -fx-border-color: #2e2b68;-fx-border-radius: 32");


        // Criar os componentes que seram importados no grid
        Label lblId = new Label("ID:");
        tfId.setDisable(true);

        Label lblNome = new Label("Nome: ");
        tfNome.setPromptText("Ex: Mario");

        Label lblFabricante = new Label("Fabricante: ");
        tfFabricante.setPromptText("Ex: Mario");

        Label lblPlataforma = new Label("Plataformas: ");
        comboPlataforma.setItems(plataformas);

        Label lblValor = new Label("Valor: ");
        tfValor.setPromptText("Ex.9.99");

        Label lblDatalancamento = new Label("Data de Lançamento: ");
        dpDataLacamento = new DatePicker(LocalDate.now());


        // Add os componentes no GRID

        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);

        gridFormulario.add(lblNome, 0, 1);
        gridFormulario.add(tfNome, 1, 1);

        gridFormulario.add(lblFabricante, 0, 2);
        gridFormulario.add(tfFabricante,1,2);

        gridFormulario.add(lblValor, 0, 3);
        gridFormulario.add(tfValor, 1, 3);

        gridFormulario.add(lblDatalancamento, 0, 4);
        gridFormulario.add(dpDataLacamento, 1, 4);


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

            Plataforma plataforma = new Plataforma();
            plataforma.setNome(tfNome.getText());
            plataforma.setFabricante(tfFabricante.getText());
            plataforma.setValor(Double.parseDouble(tfValor.getText()));
            plataforma.setDataLancamento(dpDataLacamento.getValue());



            try {
                plataforma.setValor(Double.parseDouble(tfValor.getText().replace(",",".")));
            } catch (NumberFormatException error) {
                Alert valorIncorreto = new Alert(Alert.AlertType.ERROR);
                valorIncorreto.setTitle("Valor Incorreto");
                valorIncorreto.setHeaderText("O valor digitado deve conter apenas números! \nUtilize ponto ou virgula como separador de decimal");
                valorIncorreto.showAndWait();
                tfValor.requestFocus();
                return;
            }


            //Criar o repositorio para enviar o plataforma
            PlataformaRepository repository = new PlataformaRepository();

            if (tfId.getText().equals("")) {
                repository.salvar(plataforma);

                //Mostra a mensagem do pós-salvar
                Alert mensagemSalvar = new Alert(Alert.AlertType.CONFIRMATION);
                mensagemSalvar.setTitle("Cadastro de plataforma");
                mensagemSalvar.setHeaderText("O plataforma gravado com sucesso!");
                mensagemSalvar.setContentText("Deseja cadastrar outro plataforma?");

                Optional<ButtonType> escolha = mensagemSalvar.showAndWait();

                if (escolha.get() == ButtonType.OK) {
                    limparCampos();
                } else {
                    stage.close();
                }


            } else {
                plataforma.setId(Integer.parseInt(tfId.getText()));
                repository.editar(plataforma);

                //Mostra mensagem a pós-editar
                Alert mensagemEditar = new Alert(Alert.AlertType.CONFIRMATION);
                mensagemEditar.setTitle("Atualização de plataforma");
                mensagemEditar.setHeaderText("O plataforma foi atualizado com sucesso!");

                mensagemEditar.showAndWait();
                stage.close();


            }

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

        tfNome.clear();
        tfFabricante.clear();
        tfValor.clear();
        dpDataLacamento.setValue(LocalDate.now());
        tfNome.requestFocus();
    }
    }
