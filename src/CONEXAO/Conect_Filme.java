package CONEXAO;
import ENTIDADES.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conect_Filme {
    private Connection conect;
    public Conect_Filme() {
        this.conect = new Conect().conect();
    }
    /*FUNÇÃO PARA SALVAR OS DADOS DE UM FILME NOVO*/
    public void salvar(Filme i){
        String sql = "insert into tb_filme (nomeFilme ,faixaEtariaFilme ,lancamentoFilme ,diretorFilme ,generoFilme,disponivelFilme ,sinopseFilme )"
                    + "values (?,?,?,?,?,?,?)";
        try {
        PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getFaixa());
            stmt.setInt(3, i.getAnoLancamento());
            stmt.setString(4, i.getDiretor());
            stmt.setString(5, i.getGenero());
            stmt.setInt(6, i.getDisponiveis());
            stmt.setString(7, i.getSinopse());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }           
    }
    /*FUNÇÃO PARA ALTERAR OS DADOS DE UM FILME NO BANCO DE DADOS PELO ID*/
    public void alterar(Filme i) {
        String sql = "UPDATE tb_filme SET nomeFilme = ?, faixaEtariaFilme = ?, lancamentoFilme = ?, diretorFilme = ?, generoFilme = ?,disponivelFilme = ?, sinopseFilme = ?"
                + "WHERE idFilme = ?";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
                stmt.setString(1, i.getNome());
                stmt.setString(2, i.getFaixa());
                stmt.setInt(3, i.getAnoLancamento());
                stmt.setString(4, i.getDiretor());
                stmt.setString(5, i.getGenero());
                stmt.setInt(6, i.getDisponiveis());
                stmt.setString(7, i.getSinopse());
                stmt.setInt(8, i.getId());
                stmt.execute();
                stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*FUNÇÃO PARA DELETAR UM FILME DO BANCO DE DADOS PELO ID*/
    public void deletar(Filme i) {
        String sql = "DELETE FROM tb_filme WHERE idFilme = ?";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
                stmt.setInt(1, i.getId());
                stmt.execute();
                stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*LISTA TODOS OS FILMES POR ORDEM DE ID*/
    public List<Filme> listarTodos() {
        String sql = "SELECT * FROM tb_filme ORDER BY idFilme";
        ResultSet resultadoDB;
        List<Filme> filmes = new ArrayList<Filme>();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            resultadoDB = stmt.executeQuery();
            while (resultadoDB.next()) {
                Filme filme = new Filme();
                filme.setId(Integer.parseInt(resultadoDB.getString("idFilme")));
                filme.setNome(resultadoDB.getString("nomeFilme"));
                filme.setFaixa(resultadoDB.getString("faixaEtariaFilme"));
                filme.setAnoLancamento(resultadoDB.getInt("lancamentoFilme"));
                filme.setDiretor(resultadoDB.getString("diretorFilme"));
                filme.setGenero(resultadoDB.getString("generoFilme"));
                filme.setDisponiveis(resultadoDB.getInt("disponivelFilme"));
                filme.setSinopse(resultadoDB.getString("sinopseFilme"));
                filmes.add(filme);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e){
            System.out.println(e);
        }
        return filmes;
    }
}