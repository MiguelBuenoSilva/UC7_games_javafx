package br.senac.sp.gamesjavafx.ui.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PainelHome {

    public VBox criarPainelHome() {
        //Painel principal, representa a tela toda
        VBox painelPrincipal = new VBox();
        painelPrincipal.setAlignment(Pos.TOP_CENTER);
        painelPrincipal.setStyle("-fx-background-color: #242359");
        painelPrincipal.setPadding(new Insets(5, 20, 20, 20));

        //Painel de Título
        VBox painelTitulo = new VBox();
        painelTitulo.setStyle("-fx-background-color: transparent");
        Label lblTitulo = new Label("Seja Bem-vindo!");
        lblTitulo.setStyle("-fx-font-size: 24;-fx-font-weight: bold; -fx-text-fill: #ffffff");

        painelTitulo.getChildren().addAll(lblTitulo, new Separator());

        VBox painelLogo = new VBox();
        painelLogo.setAlignment(Pos.CENTER);
        painelLogo.setStyle("-fx-background-color: transparent");

        //Imagem da aplicação
        Image imgLogo = new Image(getClass().getResourceAsStream("/imagens/games.png"));
        ImageView ivLogo = new ImageView(imgLogo);
        VBox.setVgrow(painelLogo, Priority.ALWAYS);

        //Textos com nome e descrição da aplicação
        Label lblNomeApp = new Label("GameAdmin PRO");
        lblNomeApp.setStyle("-fx-font-weight: bold; -fx-font-size: 36;-fx-text-fill: #ffffff");

        Label lblDescApp = new Label("Software para gestão de jogos | Versão 1.0");
        lblDescApp.setStyle("-fx-font-weight: normal; -fx-font-size: 18;-fx-text-fill: #ffffff");


        //Criar painel de contatos

        VBox painelContatos = new VBox(5);
        painelContatos.setStyle("-fx-background-color: #8c90fb;-fx-border-width: 4;-fx-border-color: #3b1f70; -fx-border-radius: 32;-fx-background-radius: 32");
        painelContatos.setMaxWidth(600);
        painelContatos.setPadding(new Insets(20));
       VBox.setMargin(painelContatos,new Insets(30,10,30,10));

        Label lblTituloEmail = new Label("E-mail para suporte:");
        lblTituloEmail.setStyle("-fx-font-size: 16;-fx-font-weight: bold; -fx-text-fill: black");

        Label lblEmail = new Label("agiotasuporte@gmail.com.br:");
        lblEmail.setStyle("-fx-font-size: 14");

        Label lblTituloTelefone = new Label("Telefone para suporte:");
        lblTituloTelefone.setStyle("-fx-font-size: 16;-fx-font-weight: bold; -fx-text-fill: black");

        Label lblTelefone = new Label("(11)4002-8922");
        lblTelefone.setStyle("-fx-font-size: 14");

        painelContatos.getChildren().addAll(
                lblTituloEmail,
                lblEmail,
                lblTituloTelefone,
                lblTelefone
        );

            Label lblDesenvolvidoPor = new Label("Desenvolvido por Miguel -2026");
            lblDesenvolvidoPor.setStyle("-fx-font-weight: bold;-fx-font-size: 18;-fx-text-fill: #ffffff");

        painelLogo.getChildren().addAll(
                ivLogo,
                lblNomeApp,
                lblDescApp,
                painelContatos,
                lblDesenvolvidoPor

        );


        painelPrincipal.getChildren().addAll(
                painelTitulo,
                painelLogo

        );


        return painelPrincipal;
    }
}
