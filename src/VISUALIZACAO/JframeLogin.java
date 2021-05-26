package VISUALIZACAO;
import CONEXAO.Conect;
import CONEXAO.Conect_UsuarioN;
import ENTIDADES.UsuarioN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

public class JframeLogin extends javax.swing.JFrame {
    public String getUserLogado() { return userLogado; }
    public void setUserLogado(String userLogado) { this.userLogado = userLogado; }
    private String userLogado = null;
    public JframeLogin() {
        initComponents();
        comboBoxItens();
    }
    /* CRIA UMA COMBOBOX COM UMA LISTA DE TODOS OS FUNCIONÁRIOS CADASTRADOS */
    public void comboBoxItens() {
        Conect_UsuarioN uUsuario = new Conect_UsuarioN();
        List < UsuarioN > usuario = uUsuario.listarTodos();
        int i = 0;
        while (usuario.size() > i) {
            UserCombo.addItem(usuario.get(i).getNomePessoa());
            i++;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogarButton = new javax.swing.JButton();
        SenhaField = new javax.swing.JPasswordField();
        UserCombo = new javax.swing.JComboBox < > ();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("User:");
        jLabel2.setText("Senha:");
        LogarButton.setText("Logar");
        LogarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogarButtonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LogarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SenhaField)
                                                        .addComponent(UserCombo, 0, 119, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(UserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(SenhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(LogarButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    } // </editor-fold>//GEN-END:initComponents

    private void LogarButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_LogarButtonActionPerformed
        String logado = (String) UserCombo.getSelectedItem();
        String senha = SenhaField.getText();
        Connection conecta = new Conect().conect();
        String sql = "select senhaUsuario from tb_usuario where nomeUsuario = ?";
        try {
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setString(1, logado);
            ResultSet rs = stmt.executeQuery();
            String varx = "batata";
            while (rs.next()) {
                varx = (rs.getString("senhaUsuario"));
            }

            if (varx.equals(senha)) {
                this.dispose();
                this.userLogado = logado;
                JframeInicial Inicial = new JframeInicial(this.userLogado);
                Inicial.setVisible(true);
                Inicial.setDefaultCloseOperation(JframeInicial.EXIT_ON_CLOSE);
                Inicial.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "Senha Incorreta!", "Aviso", 1);
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    } //GEN-LAST:event_LogarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogarButton;
    private javax.swing.JPasswordField SenhaField;
    private javax.swing.JComboBox < String > UserCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}