/*É UMA ENTIDADE QUE REPRESENTA UMA LOCAÇÃO*/
package ENTIDADES;

public class Alugados {
    int id;
    String usuario;
    String cliente;
    int filme;
    float preco;
    String retirada;
    String entrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendedor() {
        return usuario;
    }

    public void setVendedor(String vendedor) {
        this.usuario = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getFilme() {
        return filme;
    }

    public void setFilme(int filme) {
        this.filme = filme;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getRetirada() {
        return retirada;
    }

    public void setRetirada(String retirada) {
        this.retirada = retirada;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }
    
    
    
    
    
}
