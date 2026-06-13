package br.senac.sp.gamesjavafx.data.repository;

import br.senac.sp.gamesjavafx.data.ConexaoSQLite;
import br.senac.sp.gamesjavafx.model.Estudio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EstudioRepository {

    public ObservableList<Estudio> getEstudios() {

        String sql = "SELECT * FROM tb_estudios";

        ObservableList<Estudio> listaEstudios = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Estudio estudio = new Estudio();
                int estudio_id = rs.getInt("estudio_id");
                String nome_estudio = rs.getString("nome_estudio");
                String nome_fundador = rs.getString("nome_fundador");
                LocalDate ano_fundacao = LocalDate.parse(rs.getString("ano_fundacao"));
                String pais_origem = rs.getString("pais_origem");

                //Popular o objeto Estudio com os dados
                estudio.setId(estudio_id);
                estudio.setNomeEstudio(nome_estudio);
                estudio.setNomeFundador(nome_fundador);
                estudio.setAnoFundacao(ano_fundacao);
                estudio.setPaisOrigem(pais_origem);

                listaEstudios.add(estudio);


            }
            ConexaoSQLite.fecharConexao();
            return listaEstudios;

        } catch (SQLException erro) {

            System.out.println("Ocorreu um erro na leitura dos dados.");
            erro.printStackTrace();
            return null;
        }
    }

    public void salvar(Estudio estudio) {
        //Instrução SQL para cadastrar um novo jogo no banco de dados
        String sql =
                "INSERT INTO tb_estudios( nome_estudio ,nome_fundador," +
                        "ano_fundacao, pais_origem) " +
                        " VALUES(?,?,?,? ); "; //Cada ponto de interrogação é o valor de cada campo á ser preenchido

        //Preparar a instrução SQL para ser enviada para o banco atráves
        //de uma conexão

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, estudio.getNomeEstudio());
            stm.setString(2, estudio.getNomeFundador());
            stm.setString(3, estudio.getAnoFundacao().toString());
            stm.setString(4, estudio.getPaisOrigem());

            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();

        } catch (SQLException erro) {
            System.out.println("Ocorreu um erro na gravação.");
            erro.printStackTrace();
        }
    }

    public int getTotalestudios() {
        String sql = "SELECT COUNT(estudio_id) as total_estudios FROM tb_estudios";
        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            rs.next();
            int totalEstudios = rs.getInt("total_estudios");
            ConexaoSQLite.fecharConexao();
            return totalEstudios;

        } catch (SQLException erro) {
            erro.printStackTrace();
            return 0;
        }
    }

    public int excluir(int id) {
        String sql = "DELETE FROM tb_plataformas WHERE estudio_id = ?";

        try {
            PreparedStatement stm = ConexaoSQLite
                    .getConexao().
                    prepareStatement(sql);
            stm.setInt(1, id);
            int resultado = stm.executeUpdate();

            ConexaoSQLite.fecharConexao();

            return resultado;
        } catch (SQLException erro) {
            erro.printStackTrace();
            return 0;
        }
    }

    public void editar(Estudio estudio){
        String sql ="UPDATE tb_plataformas SET " +
                 "nome = ?," +
                "fabricante = ?," +
                "valor = ?," +
                "data_lancamento = ?," +
                " WHERE  plataforma_id = ?;";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1,estudio.getNomeEstudio());
            stm.setString(2,estudio.getNomeFundador());
            stm.setString(3,estudio.getAnoFundacao().toString());
            stm.setString(4,estudio.getPaisOrigem());

            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();

        }catch (SQLException erro){
            System.out.println("Ococrreu um erro na gravação.");
            erro.printStackTrace();

        }
    }
}
