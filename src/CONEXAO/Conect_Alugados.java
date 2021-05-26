package CONEXAO;
import ENTIDADES.Alugados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conect_Alugados {
    private Connection conect;
    public Conect_Alugados() {
        this.conect = new Conect().conect();
    }
    /*  FUNÇÃO PARA INSERIR DADOS DOS CAMPOS DA GUI NO BANCO DE DADOS;
     *   COMO É UM ALUGUEL NOVO, A FLAG "ATIVO" É SETTADA PARA TRUE POR PADRÃO. */
    public void salvar(Alugados a) {
        String sql = "insert into tb_alugados (clienteAlugados,filmeAlugados,retiradaAlugados,entregaAlugados,precoAlugados,usuarioAlugados, ativoAlugados)" +
                "values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, a.getCliente());
            stmt.setInt(2, a.getFilme());
            stmt.setString(3, a.getRetirada());
            stmt.setString(4, a.getEntrega());
            stmt.setFloat(5, a.getPreco());
            stmt.setString(6, a.getVendedor());
            stmt.setBoolean(7, true);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*  FUNÇÃO PARA ALTERAR A ENTRADA SELECIONADA
     *   NÃO ALTERA O ESTADO DA LOCAÇÃO! */
    public void alterar(Alugados a) {
        String sql = "UPDATE tb_alugados SET clienteAlugados = ?, filmeAlugados = ?, retiradaAlugados = ?, entregaAlugados = ?, precoAlugados = ?, usuarioAlugados = ?" +
                "WHERE idAlugados = ?";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, a.getCliente());
            stmt.setInt(2, a.getFilme());
            stmt.setString(3, a.getRetirada());
            stmt.setString(4, a.getEntrega());
            stmt.setFloat(5, a.getPreco());
            stmt.setString(6, a.getVendedor());
            stmt.setInt(7, a.getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /* FUNÇÃO PARA MARCAR UM ALUGUEL COMO INATIVO*/
    public void deletar(Alugados a) {
        String sql = "UPDATE tb_alugados SET ativoAlugados = false WHERE idAlugados = ?";
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setInt(1, a.getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /* FUNÇÃO PARA ATUALIZAR A TABELA COM TODOS OS ALUGUEIS ATIVOS*/
    public List < Alugados > listarTodos() {
        String sql = "SELECT * FROM tb_alugados WHERE ativoAlugados = true ORDER BY idAlugados";
        ResultSet resultadoDB;
        List < Alugados > alugados = new ArrayList < Alugados > ();

        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            resultadoDB = stmt.executeQuery();
            while (resultadoDB.next()) {
                Alugados alugado = new Alugados();
                alugado.setId(Integer.parseInt(resultadoDB.getString("idAlugados")));
                alugado.setCliente(resultadoDB.getString("clienteAlugados"));
                alugado.setFilme(resultadoDB.getInt("filmeAlugados"));
                alugado.setRetirada(resultadoDB.getString("retiradaAlugados"));
                alugado.setEntrega(resultadoDB.getString("entregaAlugados"));
                alugado.setPreco(Float.parseFloat(resultadoDB.getString("precoAlugados")));
                alugado.setVendedor(resultadoDB.getString("usuarioAlugados"));
                alugados.add(alugado);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alugados;
    }
    /* FUNÇÃO UTILIZADA NA JANELA DE HISTÓRICO, LISTA OS DADOS COM A FLAG "false" NO CAMPO INATIVO */
    public List < Alugados > listarInativos() {
        String sql = "SELECT * FROM tb_alugados WHERE ativoAlugados = false ORDER BY idAlugados";
        ResultSet resultadoDB;
        List < Alugados > alugados = new ArrayList < Alugados > ();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            resultadoDB = stmt.executeQuery();
            while (resultadoDB.next()) {
                Alugados alugado = new Alugados();
                alugado.setId(Integer.parseInt(resultadoDB.getString("idAlugados")));
                alugado.setCliente(resultadoDB.getString("clienteAlugados"));
                alugado.setFilme(resultadoDB.getInt("filmeAlugados"));
                alugado.setRetirada(resultadoDB.getString("retiradaAlugados"));
                alugado.setEntrega(resultadoDB.getString("entregaAlugados"));
                alugado.setPreco(Float.parseFloat(resultadoDB.getString("precoAlugados")));
                alugado.setVendedor(resultadoDB.getString("usuarioAlugados"));
                alugados.add(alugado);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alugados;
    }
    /* MESMA FUNÇÃO ACIMA PORÉM FILTRA POR ID */
    public List < Alugados > listarInativosID(int ID) {
        String sql = "SELECT * FROM tb_alugados WHERE ativoAlugados = false and idAlugados = ?";
        ResultSet resultadoDB;
        List < Alugados > alugados = new ArrayList < Alugados > ();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setInt(1, ID);
            resultadoDB = stmt.executeQuery();

            while (resultadoDB.next()) {
                Alugados alugado = new Alugados();
                alugado.setId(Integer.parseInt(resultadoDB.getString("idAlugados")));
                alugado.setCliente(resultadoDB.getString("clienteAlugados"));
                alugado.setFilme(resultadoDB.getInt("filmeAlugados"));
                alugado.setRetirada(resultadoDB.getString("retiradaAlugados"));
                alugado.setEntrega(resultadoDB.getString("entregaAlugados"));
                alugado.setPreco(Float.parseFloat(resultadoDB.getString("precoAlugados")));
                alugado.setVendedor(resultadoDB.getString("usuarioAlugados"));
                alugados.add(alugado);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alugados;
    }
    /* MESMA FUNÇÃO ACIMA PORÉM FILTRA POR NOME DE CLIENTE */
    public List < Alugados > listarInativosCliente(String nomeCliente) {
        String sql = "SELECT * FROM tb_alugados WHERE ativoAlugados = false and clienteAlugados = ? ORDER BY idAlugados";
        ResultSet resultadoDB;
        List < Alugados > alugados = new ArrayList < Alugados > ();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, nomeCliente);
            resultadoDB = stmt.executeQuery();

            while (resultadoDB.next()) {
                Alugados alugado = new Alugados();
                alugado.setId(Integer.parseInt(resultadoDB.getString("idAlugados")));
                alugado.setCliente(resultadoDB.getString("clienteAlugados"));
                alugado.setFilme(resultadoDB.getInt("filmeAlugados"));
                alugado.setRetirada(resultadoDB.getString("retiradaAlugados"));
                alugado.setEntrega(resultadoDB.getString("entregaAlugados"));
                alugado.setPreco(Float.parseFloat(resultadoDB.getString("precoAlugados")));
                alugado.setVendedor(resultadoDB.getString("usuarioAlugados"));
                alugados.add(alugado);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alugados;
    }
    /* MESMA FUNÇÃO ACIMA PORÉM FILTRA POR NOME DE FILME*/
    public List < Alugados > listarInativosFilme(int filmeAlugados) {
        String sql = "SELECT * FROM tb_alugados WHERE ativoAlugados = false and filmeAlugados = ? ORDER BY idAlugados";
        ResultSet resultadoDB;
        List < Alugados > alugados = new ArrayList < Alugados > ();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setInt(1, filmeAlugados);
            resultadoDB = stmt.executeQuery();

            while (resultadoDB.next()) {
                Alugados alugado = new Alugados();
                alugado.setId(Integer.parseInt(resultadoDB.getString("idAlugados")));
                alugado.setCliente(resultadoDB.getString("clienteAlugados"));
                alugado.setFilme(resultadoDB.getInt("filmeAlugados"));
                alugado.setRetirada(resultadoDB.getString("retiradaAlugados"));
                alugado.setEntrega(resultadoDB.getString("entregaAlugados"));
                alugado.setPreco(Float.parseFloat(resultadoDB.getString("precoAlugados")));
                alugado.setVendedor(resultadoDB.getString("usuarioAlugados"));
                alugados.add(alugado);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alugados;
    }
    /* MESMA FUNÇÃO ACIMA PORÉM FILTRA POR NOME DE FUNCIONÁRIO*/
    public List < Alugados > listarInativosFuncionario(String usuarioAlugados) {
        String sql = "SELECT * FROM tb_alugados WHERE ativoAlugados = false and usuarioAlugados = ? ORDER BY idAlugados";
        ResultSet resultadoDB;
        List < Alugados > alugados = new ArrayList < Alugados > ();
        try {
            PreparedStatement stmt = conect.prepareStatement(sql);
            stmt.setString(1, usuarioAlugados);
            resultadoDB = stmt.executeQuery();

            while (resultadoDB.next()) {
                Alugados alugado = new Alugados();
                alugado.setId(Integer.parseInt(resultadoDB.getString("idAlugados")));
                alugado.setCliente(resultadoDB.getString("clienteAlugados"));
                alugado.setFilme(resultadoDB.getInt("filmeAlugados"));
                alugado.setRetirada(resultadoDB.getString("retiradaAlugados"));
                alugado.setEntrega(resultadoDB.getString("entregaAlugados"));
                alugado.setPreco(Float.parseFloat(resultadoDB.getString("precoAlugados")));
                alugado.setVendedor(resultadoDB.getString("usuarioAlugados"));
                alugados.add(alugado);
            }
            resultadoDB.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alugados;
    }
}