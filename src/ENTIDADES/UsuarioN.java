/*É UMA ENTIDADE QUE REPRESENTA UM USUÁRIO, EXTENDENDO A PARTIR DA ENTIDADE QUE REPRESENTA UMA PESSOA*/
package ENTIDADES;

public class UsuarioN extends Pessoa{
    String senhaUsuario;
    float salarioUsuario;

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public float getSalarioUsuario() {
        return salarioUsuario;
    }

    public void setSalarioUsuario(float salarioUsuario) {
        this.salarioUsuario = salarioUsuario;
    }
}
