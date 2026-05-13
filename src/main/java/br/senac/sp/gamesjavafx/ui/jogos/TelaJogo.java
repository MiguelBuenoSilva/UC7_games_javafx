package br.senac.sp.gamesjavafx.ui.jogos;

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
//import javax.swing.*;

public class TelaJogo {


    private TextField tfId;
    private TextField tfTitulo;
    private TextField tfValor;
    private ComboBox<String> comboPlataforma;
    private ComboBox<String> comboEstudio;
    private DatePicker dpDataLacamento;
    private CheckBox cbFinalizado;

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
        raiz.setBottom(criarPainelBotoes());

        Scene cena = new Scene(raiz, 500, 700);

//        stage.setHeight(400);
//        stage.setWidth(500);
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
        ObservableList<String> plataformas = FXCollections.observableArrayList(
                "Super Nintendo","Mega Drive","PlayStation1","PC","Xbox"
        );

        ObservableList<String> estudios = FXCollections.observableArrayList(
                "Capcom", "Activision"," Blizzard","Bandai Namco","Rockstar Games","PlayStation Studios"
        );

        VBox formulario = new VBox();
        formulario.setPadding(new Insets(20));

        GridPane gridFormulario = new GridPane(5,5);
        gridFormulario.setGridLinesVisible(false);
        gridFormulario.setPadding(new Insets(20));
        gridFormulario.setStyle("-fx-border-width: 2; -fx-border-color: #2e2b68;-fx-border-radius: 32");


        // Criar os componentes que seram importados no grid
        Label lblId = new Label("ID:");
        tfId = new TextField();
        tfId.setEditable(false);

        Label lblTitulo = new Label("Título: ");
        tfTitulo = new TextField();
        tfTitulo.setPromptText("Ex: Mario");

        Label lblPlataforma = new Label("Plataformas: ");
        comboPlataforma = new ComboBox<>(plataformas);

        Label lblEstudio = new Label("Estudios:");
        comboEstudio = new ComboBox<>(estudios);

        Label lblValor = new Label("Valor: ");
        tfValor = new TextField();
        tfValor.setPromptText("Ex.9.99");

        Label lblDatalancamento = new Label("Data de Lançamento: ");
        dpDataLacamento = new DatePicker(LocalDate.now());

        cbFinalizado = new CheckBox("Finalizado");


        // Add os componentes GRID

        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);

        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);

        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);

        gridFormulario.add(lblEstudio, 0, 3);
        gridFormulario.add(comboEstudio, 1, 3);

        gridFormulario.add(lblValor, 0,4);
        gridFormulario.add(tfValor,1,4);

        gridFormulario.add(lblDatalancamento,0,5);
        gridFormulario.add(dpDataLacamento,1,5);

        gridFormulario.add(cbFinalizado,1,6);


        formulario.getChildren().add(gridFormulario);

        return formulario;
    }

    private HBox criarPainelBotoes(){
        HBox painelBotoes = new HBox(10);
        painelBotoes.setStyle("-fx-background-color: #832929");
        painelBotoes.setPadding(new Insets(10));
        painelBotoes.setAlignment(Pos.BOTTOM_RIGHT);

        Button btnSalvar = new Button();
        Image imgSalvar = new Image(getClass().getResourceAsStream("/imagens/icons/save.png"));
        ImageView ivSalvar = new ImageView(imgSalvar);
        btnSalvar.setGraphic(ivSalvar);
        btnSalvar.setTooltip(new Tooltip("Salvar dados do jogo"));

        Button btnCancelar = new Button();
        Image imgCancelar = new Image(getClass().getResourceAsStream("/imagens/icons/cancel.png"));
        ImageView ivCancelar = new ImageView(imgCancelar);
        btnCancelar.setGraphic(ivCancelar);
        btnCancelar.setTooltip(new Tooltip("Cancelar dados do jogo"));

        painelBotoes.getChildren().addAll(btnSalvar,btnCancelar);

        return painelBotoes;
    }

}

