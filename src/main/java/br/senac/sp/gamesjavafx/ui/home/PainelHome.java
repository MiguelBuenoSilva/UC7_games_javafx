package br.senac.sp.gamesjavafx.ui.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PainelHome {

    public VBox criarPainelHome(){
        //Painel principal, representa a tela toda
        VBox painelPrincipal = new VBox();
        painelPrincipal.setAlignment(Pos.TOP_CENTER);
        painelPrincipal.setStyle("-fx-background-color: #242359");
        painelPrincipal.setPadding(new Insets(5,20,20,20));

        //Painel de Título
        VBox painelTitulo = new VBox();
        painelTitulo.setStyle("-fx-background-color: #fff300");
        Label lblTitulo = new Label("Seja Bem-vindo!");
        lblTitulo.setStyle("-fx-font-size: 24;-fx-font-weight: bold");

        painelTitulo.getChildren().addAll(lblTitulo, new Separator());

        //Imagem da aplicação
        Image imgLogo = new Image(getClass().getResourceAsStream("/imagens/arcade-machine.png"));
        ImageView ivLogo = new ImageView(imgLogo);

        //Textos com nome e descrição da aplicação
        Label lblNomeApp = new Label("GameAdmin PRO");
        lblNomeApp.setStyle("-fx-font-weight: bold; -fx-font-size: 36;-fx-text-fill: #ffffff");

        Label lblDescApp = new Label("Software para gestão de jogos | Versão 1.0");
        lblDescApp.setStyle("-fx-font-weight: regular; -fx-font-size: 18;-fx-text-fill: #ffffff");

        painelPrincipal.getChildren().addAll(
                painelTitulo,
                ivLogo,
                lblNomeApp,
                lblDescApp

                );




        return painelPrincipal;
    }
}
