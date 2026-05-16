package br.senac.sp.gamesjavafx;

import br.senac.sp.gamesjavafx.data.repository.JogoRepository;
import br.senac.sp.gamesjavafx.model.Jogo;
import javafx.application.Application;

import java.time.LocalDate;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(TelaPrincipal.class, args);

//        Jogo jogo = new Jogo(0,"testeTitulo","Testando");
//        jogo.setEstudio("Estudio teste");
//        jogo.setCategoria("Teste categoria");
//        jogo.setPreco(99.99);
//        jogo.setDataLancamento(LocalDate.now());
//        jogo.setFinalizado(true);
//
//        JogoRepository repository = new JogoRepository();
//        repository.salvar(jogo);

    }
}
