package br.senac.sp.gamesjavafx.data.repository;

import br.senac.sp.gamesjavafx.data.ConexaoSQLite;
import br.senac.sp.gamesjavafx.model.Plataforma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlataformaRepository {

    public ObservableList<Plataforma> getPlataformas() {

        String sql = "SELECT * FROM  tb_plataformas";

        ObservableList<Plataforma> listaPlataformas = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Plataforma plataforma= new Plataforma();
                int plataforma_id = rs.getInt("plataforma_id");
                String nome = rs.getString("nome");
                String fabricante = rs.getString("fabricante");
                double valor = rs.getDouble("valor");
                LocalDate dataLancamento = LocalDate.parse(rs.getString("data_lancamento"));


                //Popular o objeto jogo com os dados
                plataforma.setId(plataforma_id);
                plataforma.setNome(nome);
                plataforma.setFabricante(fabricante);
                plataforma.setValor(valor);
                plataforma.setDataLancamento(dataLancamento);

                listaPlataformas.add(plataforma);

            }
            ConexaoSQLite.fecharConexao();
          return listaPlataformas;

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na leitura dos dados.");
            e.printStackTrace();
            return null;
        }


    }
    public void salvar(Plataforma plataforma) {
        //Instrução SQL para cadastrar um novo jogo no banco de dados
        String sql = "INSERT INTO tb_plataformas (nome, fabricante, data_lacamento, valor" +")" +
                "VALUES(?,?,?,?,?,?,?);";//Cada ponto de interrogação é o valor de cada campo á ser preenchido

        //Preparar a instrução SQL para ser enviada para o banco atráves
        //de uma conexão

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, plataforma.getNome());
            stm.setString(2, plataforma.getFabricante());
            stm.setDouble(3, plataforma.getValor());
            stm.setString(4, plataforma.getDataLancamento().toString());

            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();
        } catch (SQLException erro) {
            System.out.println("Ocorreu um erro na gravação.");
            erro.printStackTrace();
        }

    }
    // Contar a quantidade de jogos gravados
    public int getTotalJogos(){
        String sql = "SELECT COUNT(id) as total_plataformas FROM tb_plataformas";
        try {
            PreparedStatement stm =ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            rs.next();
            int total = rs.getInt("total_plataformas");
            ConexaoSQLite.fecharConexao();
            return total;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int excluir (int id){
        String sql = "DELETE FROM tb_plataformas WHERE id = ?";

        try {
            PreparedStatement stm = ConexaoSQLite
                    .getConexao().
                    prepareStatement(sql);
            stm.setInt(1,id);
            int resultado = stm.executeUpdate();

            ConexaoSQLite.fecharConexao();

            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void editar(Plataforma plataforma) {
        String sql =
                "UPDATE tb_plataformas SET" +
                        " nome = ?," +
                        "fabricante = ?," +
                        "valor = ?," +
                        "data_lancamento = ?," +
                        " WHERE  plataforma_id = ?;";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, plataforma.getNome());
            stm.setString(2, plataforma.getFabricante());
            stm.setDouble(3, plataforma.getValor());
            stm.setString(4, plataforma.getDataLancamento().toString());
            stm.setInt(5,plataforma.getId());

            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();
        } catch (SQLException erro) {
            System.out.println("Ocorreu um erro na gravação.");
            erro.printStackTrace();
        }
    }

}
