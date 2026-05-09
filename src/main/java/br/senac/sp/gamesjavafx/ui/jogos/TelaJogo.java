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
//import javax.swing.*;

public class TelaJogo {


    private TextField tfId;
    private TextField tfTitulo;
    private TextField tfValor;
    private ComboBox<String> comboPlataforma;
    private ComboBox<String> comboEstudio;
    private DatePicker dtDataLacamento;
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
        Scene cena = new Scene(raiz, 500, 400);

        stage.setHeight(400);
        stage.setWidth(500);
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
                "Super Nintendo",
                "Mega Drive",
                "PS1",
                "PC",
                "Xbox"
        );

        VBox formulario = new VBox();

        GridPane gridFormulario = new GridPane();

        // Criar os componentes que seram importados no grid
        Label lblId = new Label("ID:");
        tfId = new TextField();
        tfId.setEditable(false);

        Label lblTitulo = new Label("Título:");
        tfTitulo = new TextField();
        tfTitulo.setPromptText("Ex: Mario");

        Label lblPlataforma = new Label("Plataformas:");
        comboPlataforma = new ComboBox<>(plataformas);

        // Add os componentes GRID
        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);
        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);
        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);

        formulario.getChildren().add(gridFormulario);

        return formulario;
    }

}

