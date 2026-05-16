package br.senac.sp.gamesjavafx.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {

    public static Connection getConexao(){

        //String de conexão - URl do Banco de Dados
        String url = "jdbc:sqlite:/C:/Users/miguel.bsilva5/Downloads/banco_de_dados/db_games.db";

        try {
            Connection conexao = DriverManager.getConnection(url);
            System.out.println("Sucesso");
            return conexao;
        } catch (SQLException erro) {
            System.out.println("Ocorreu um erro durante a conexão com o banco.");
            erro.printStackTrace();//Imprime toda pilha de erro
            return null;
        }

    }


}
