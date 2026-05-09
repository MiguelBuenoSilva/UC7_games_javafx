package br.senac.sp.gamesjavafx.data.repository;

import br.senac.sp.gamesjavafx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JogoRepository {

    public ObservableList<Jogo> getJogos() {

        ObservableList<Jogo> listaJogos = FXCollections
                .observableArrayList(
                        new Jogo(1, "Mortal Kombat X", "PC"),
                        new Jogo(2, "Teken", "Mega Drive"),
                        new Jogo(3, "FIFA", "One x"),
                        new Jogo(4, "PES", "PS5")
        );


        return listaJogos;
    }
}
