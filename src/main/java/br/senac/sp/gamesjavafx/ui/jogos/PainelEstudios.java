package br.senac.sp.gamesjavafx.ui.jogos;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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

        //Adicionar o label no painel
        painelEstudios.getChildren().addAll(lblTitulo, linha);

        return painelEstudios;
    }
}
