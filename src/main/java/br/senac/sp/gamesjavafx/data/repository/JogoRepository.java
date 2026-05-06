package br.senac.sp.gamesjavafx.data.repository;

import br.senac.sp.gamesjavafx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JogoRepository {

    public ObservableList<Jogo> getJogos (){

        ObservableList<Jogo> listaJogos = FXCollections
                .observableArrayList();
            new Jogo(1,"Mortal Kombat X","Desktop,Ps4");
            new Jogo(2,"Mortal Kombat X","Desktop,Ps4");
            new Jogo(3,"Mortal Kombat X","Desktop,Ps4");
            new Jogo(4,"Mortal Kombat X","Desktop,Ps4");

        return listaJogos;
    }
}
