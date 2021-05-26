package aps;
import CONEXAO.Conect;
import VISUALIZACAO.JDialogAviso;
import VISUALIZACAO.JframeLogin;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class APS {

    public static void main(String[] args) throws SQLException {
        /* ABRE UMA CONEXÃO COM O SERVIDOR POSTGRES PARA VERIFICAR E CRIAR AS TABELAS */
        Connection conecta = new Conect().conect();
        String startSQL = "CREATE TABLE IF NOT EXISTS tb_pessoa(" +
                "idPessoa             SERIAL      PRIMARY KEY," +
                "nomePessoa           VARCHAR(60) NOT NULL UNIQUE," +
                "cpfPessoa            VARCHAR(11) UNIQUE," +
                "telefonePessoa       VARCHAR(14)," +
                "emailPessoa          VARCHAR(60)," +
                "enderecoPessoa       VARCHAR(50)," +
                "dataDeNascPessoa     VARCHAR(10)," +
                "sexoPessoa           VARCHAR(9)" +
                ");" +
                "CREATE TABLE IF NOT EXISTS tb_usuario(" +
                "nomeUsuario          VARCHAR(60) UNIQUE REFERENCES tb_pessoa(nomePessoa) ON UPDATE CASCADE ON DELETE CASCADE," +
                "senhaUsuario         VARCHAR(16)," +
                "salarioUsuario       FLOAT" +
                ");" +
                "CREATE TABLE IF NOT EXISTS tb_filme(" +
                "idFilme              SERIAL      PRIMARY KEY," +
                "nomeFilme            VARCHAR(40) NOT NULL," +
                "faixaEtariaFilme     VARCHAR(6)," +
                "lancamentoFilme      INTEGER," +
                "diretorFilme         VARCHAR(60)," +
                "generoFilme          VARCHAR(25) NOT NULL," +
                "disponivelFilme      INTEGER," +
                "sinopseFilme         VARCHAR(600)" +
                ");" +
                "CREATE TABLE IF NOT EXISTS tb_alugados(" +
                "idAlugados           SERIAL      PRIMARY KEY," +
                "clienteAlugados      VARCHAR(60) REFERENCES tb_pessoa(nomePessoa) ON UPDATE CASCADE," +
                "filmeAlugados        INTEGER     REFERENCES tb_filme(idFilme) ON UPDATE CASCADE," +
                "usuarioAlugados      varchar(60) REFERENCES tb_usuario(nomeUsuario) ON UPDATE CASCADE," +
                "retiradaAlugados     VARCHAR(10) NOT NULL," +
                "entregaAlugados      VARCHAR(10) NOT NULL," +
                "precoAlugados        FLOAT," +
                "ativoAlugados        BOOLEAN NOT NULL" +
                ");" +
                "INSERT INTO tb_pessoa(nomePessoa) " +
                "SELECT 'root' " +
                " WHERE NOT EXISTS (SELECT nomeUsuario FROM tb_usuario WHERE nomeUsuario = 'root');" +
                "INSERT INTO tb_usuario(nomeUsuario)" +
                "SELECT 'root'" +
                "    WHERE NOT EXISTS (SELECT senhaUsuario FROM tb_usuario WHERE nomeUsuario = 'root');" +
                "select * from tb_usuario;";
        PreparedStatement SQLStart = conecta.prepareStatement(startSQL);
        SQLStart.execute();
        /* VERIFICA SE O USUÁRIO ROOT TEM SENHA */
        String sql = "select senhaUsuario from tb_usuario where nomeUsuario = ?";
        try {
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setString(1, "root");
            ResultSet rs = stmt.executeQuery();
            String varx = "batata";
            while (rs.next()) {
                varx = (rs.getString("senhaUsuario"));
            }
            /* FORÇA UMA SENHA À SER CONFIGURADA NO USUÁRIO ROOT CASO A SENHA RETORNADA SEJA NULL */
            if (varx == null) {
                JDialogAviso Aviso = new JDialogAviso();
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        conecta.close();
        /* INVOCA A TELA DE LOGIN CASO O USUÁRIO ROOT TENHA UMA SENHA DEFINIDA*/
        JframeLogin Login = new JframeLogin();
        Login.setVisible(true);
        Login.setDefaultCloseOperation(JframeLogin.EXIT_ON_CLOSE);
        Login.setLocationRelativeTo(null);
    }
}


