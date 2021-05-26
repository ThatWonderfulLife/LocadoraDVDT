package CONEXAO;
import ENTIDADES.UsuarioN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conect_UsuarioN {
    private Connection Conect;
    public Conect_UsuarioN() {
        this.Conect = new Conect().conect();
    }
    /*FUNÇÃO QUE CRIA UM USUARIO DE ACORDO COM OS PARAMETROS INDICADOS*/
    public void salvar(UsuarioN f) {
        String sql = "INSERT INTO tb_pessoa(nomePessoa,cpfPessoa,telefonePessoa,emailPessoa,enderecoPessoa,dataDeNascPessoa,sexoPessoa) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = Conect.prepareStatement(sql);
            stmt.setString(1, f.getNomePessoa());
            stmt.setString(2, f.getCpfPessoa());
            stmt.setString(3, f.getTelefonePessoa());
            stmt.setString(4, f.getEmailPessoa());
            stmt.setString(5, f.getEnderecoPessoa());
            stmt.setString(6, f.getDataDeNascPessoa());
            stmt.setString(7, f.getSexoPessoa());
            stmt.execute();
            stmt.close();
            sql = "INSERT INTO tb_usuario(nomeUsuario, senhaUsuario, salarioUsuario) "
            + "VALUES(?,?,?)";
            PreparedStatement stmt1 = Conect.prepareStatement(sql);
            stmt1.setString(1, f.getNomePessoa());
            stmt1.setString(2, f.getSenhaUsuario());
            stmt1.setFloat(3, f.getSalarioUsuario());
            stmt1.execute();
            stmt1.close();
        } catch (Exception e) { throw new RuntimeException(e); }
    }
    /*FUNÇÃO QUE ALTERA OS DADOS ANTIGOS PARA OS DADOS DIGITADOS DE UM USUARIO DE ACORDO COM O ID ESCOLHIDO */
    public void alterar(UsuarioN f) {
        String sql = "UPDATE tb_pessoa SET nomePessoa = ?, cpfPessoa = ?, telefonePessoa = ?, emailPessoa = ?, enderecoPessoa = ?, dataDeNascPessoa = ?, sexoPessoa = ?"
                + "WHERE idPessoa = ?";
        try {
            PreparedStatement stmt = Conect.prepareStatement(sql);
            stmt.setString(1, f.getNomePessoa());
            stmt.setString(2, f.getCpfPessoa());
            stmt.setString(3, f.getTelefonePessoa());
            stmt.setString(4, f.getEmailPessoa());
            stmt.setString(5, f.getEnderecoPessoa());
            stmt.setString(6, f.getDataDeNascPessoa());
            stmt.setString(7, f.getSexoPessoa());
            stmt.setInt(8, f.getIdPessoa());
            stmt.execute();
            stmt.close();
            sql = "UPDATE tb_usuario SET senhaUsuario = ?, salarioUsuario = ? "
                    + "WHERE nomeUsuario = ?";
            PreparedStatement stmt1 = Conect.prepareStatement(sql);
            stmt1.setString(1, f.getSenhaUsuario());
            stmt1.setFloat(2, f.getSalarioUsuario());
            stmt1.setString(3, f.getNomePessoa());
            stmt1.execute();
            stmt1.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*FUNÇÃO QUE DELETA UM USUÁRIO A PARTIR DA ID SELECIONADA*/
    public void deletar(UsuarioN f) {
        String sql = "DELETE FROM tb_pessoa WHERE idPessoa = ?";
        try {
            PreparedStatement stmt = Conect.prepareStatement(sql);
            stmt.setInt(1, f.getIdPessoa());
            stmt.execute();
            stmt.close();
        } catch (Exception e) { System.out.println(e); }
    }
    /*FUNÇÃO QUE LISTA TODOS OS USUÁRIOS PRESENTES NA LISTA DE USUÁRIOS*/
    public List<UsuarioN> listarTodos() {
        String sql = "Select p.*, u.*" +
                "From tb_pessoa p " +
                "INNER JOIN tb_usuario u on p.nomePessoa = u.nomeUsuario " +
                "ORDER BY idPessoa";
        ResultSet resultadoDB;
        List<UsuarioN> usuarios = new ArrayList<UsuarioN>();
        try {
            PreparedStatement stmt = Conect.prepareStatement(sql);
            resultadoDB = stmt.executeQuery();
            while (resultadoDB.next()) {
                UsuarioN usuario = new UsuarioN();
                usuario.setIdPessoa(Integer.parseInt(resultadoDB.getString("idPessoa")));
                try {usuario.setNomePessoa(resultadoDB.getString("nomePessoa"));}
                catch (Exception e) {usuario.setNomePessoa("N/A");}
                try {usuario.setCpfPessoa(resultadoDB.getString("cpfPessoa"));}
                catch (Exception e) {usuario.setCpfPessoa("N/A");}
                try {usuario.setEmailPessoa(resultadoDB.getString("emailPessoa"));}
                catch (Exception e) {usuario.setEmailPessoa("N/A");}
                try {usuario.setEnderecoPessoa(resultadoDB.getString("enderecoPessoa"));}
                catch (Exception e) {usuario.setEnderecoPessoa("N/A");}
                try {usuario.setDataDeNascPessoa(resultadoDB.getString("dataDeNascPessoa"));}
                catch (Exception e) {usuario.setDataDeNascPessoa("N/A");}
                try {usuario.setSexoPessoa(resultadoDB.getString("sexoPessoa"));}
                catch (Exception e) {usuario.setSexoPessoa("N/A");}
                try {usuario.setTelefonePessoa(resultadoDB.getString("telefonePessoa"));}
                catch (Exception e) {usuario.setTelefonePessoa("N/A");}
                try {usuario.setSalarioUsuario(Float.parseFloat(resultadoDB.getString("salarioUsuario")));}
                catch (Exception e) {usuario.setSalarioUsuario(0.0f);}
                usuarios.add(usuario);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e){ System.out.println(e); }
        return usuarios;
    }
}