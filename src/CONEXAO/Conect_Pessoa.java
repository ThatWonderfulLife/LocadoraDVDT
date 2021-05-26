package CONEXAO;
import ENTIDADES.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conect_Pessoa {
    private Connection conect;
    public Conect_Pessoa() {
        this.conect = new Conect().conect();
    }
    /*FUNÇÃO QUE SALVA OS DADOS DE UMA PESSOA NO BANCO DE DADOS*/
    public void salvar(Pessoa p){
        String sql = "insert into tb_pessoa (nomePessoa,cpfPessoa,telefonePessoa,emailPessoa,enderecoPessoa,dataDeNascPessoa,sexoPessoa)"
                + "values (?,?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, p.getNomePessoa());
            stmt.setString(2, p.getCpfPessoa());
            stmt.setString(3, p.getTelefonePessoa());
            stmt.setString(4, p.getEmailPessoa());
            stmt.setString(5, p.getEnderecoPessoa());
            stmt.setString(6, p.getDataDeNascPessoa());
            stmt.setString(7, p.getSexoPessoa());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*FUNÇÃO QUE ALTERA OS DADOS DE UMA PESSOA DE ACORDO COM O ID ESCOLHIDO*/
    public void alterar(Pessoa p) {
        String sql = "UPDATE tb_pessoa SET nomePessoa = ?, cpfPessoa = ?, telefonePessoa = ?, emailPessoa = ?, enderecoPessoa = ?, dataDeNascPessoa = ?, sexoPessoa = ?"
                + "WHERE idPessoa = ?";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, p.getNomePessoa());
            stmt.setString(2, p.getCpfPessoa());
            stmt.setString(3, p.getTelefonePessoa());
            stmt.setString(4, p.getEmailPessoa());
            stmt.setString(5, p.getEnderecoPessoa());
            stmt.setString(6, p.getDataDeNascPessoa());
            stmt.setString(7, p.getSexoPessoa());
            stmt.setInt(8, p.getIdPessoa());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*FUNÇÃO QUE DELETA OS DADOS DE UMA PESSOA DE ACORDO COM O ID ESCOLHIDO*/
    public void deletar(Pessoa p) {
        String sql = "DELETE FROM tb_pessoa WHERE idPessoa = ?";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setInt(1, p.getIdPessoa());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*FUNÇÃO QUE LISTA TODAS AS PESSOAS DENTRO DA TABELA NO BANCO DE DADOS*/
    public List<Pessoa> listarTodos() {
        String sql = "SELECT * FROM tb_pessoa ORDER BY idPessoa";
        ResultSet resultadoDB;
        List<Pessoa> clientes = new ArrayList<Pessoa>();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            resultadoDB = stmt.executeQuery();
            while (resultadoDB.next()) {
                Pessoa cliente = new Pessoa();
                cliente.setIdPessoa(Integer.parseInt(resultadoDB.getString("idPessoa")));
                cliente.setNomePessoa(resultadoDB.getString("nomePessoa"));
                cliente.setCpfPessoa(resultadoDB.getString("cpfPessoa"));
                cliente.setTelefonePessoa(resultadoDB.getString("telefonePessoa"));
                cliente.setEmailPessoa(resultadoDB.getString("emailPessoa"));
                cliente.setEnderecoPessoa(resultadoDB.getString("enderecoPessoa"));
                cliente.setDataDeNascPessoa(resultadoDB.getString("datadenascPessoa"));
                cliente.setSexoPessoa(resultadoDB.getString("sexoPessoa"));
                clientes.add(cliente);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e){ System.out.println(e); }
        return clientes;
    }
}