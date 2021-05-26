package VISUALIZACAO;
import CONEXAO.Conect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class JDialogAviso extends javax.swing.JDialog {

    public JDialogAviso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDialogAviso() {
        initComponents();
        pack();
        setModal(true);
        setVisible(true);
        setDefaultCloseOperation(JDialogAviso.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        ConfirmarBotao = new javax.swing.JButton();
        PasswordFieldConfirm = new javax.swing.JPasswordField();
        PasswordFieldNova = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        VoltarBotao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ConfirmarBotao.setText("Confirmar");
        ConfirmarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarBotaoActionPerformed(evt);
            }
        });
        PasswordFieldConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldConfirmActionPerformed(evt);
            }
        });
        jLabel4.setText("Digite sua senha:");
        jLabel5.setText("Confirme sua senha:");
        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("NÃO PERCA ESTA SENHA!!!!!");
        jLabel1.setText("Opa! Esta parece ser sua primeira Inicialização do programa!");
        jLabel2.setText("Defina uma senha para o usuario mestre.");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(83, 83, 83))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(VoltarBotao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ConfirmarBotao))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(PasswordFieldNova, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(PasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(PasswordFieldNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(PasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(VoltarBotao)
                                        .addComponent(ConfirmarBotao))
                                .addContainerGap())
        );
        pack();
    } // </editor-fold>//GEN-END:initComponents
    private void ConfirmarBotaoActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_ConfirmarBotaoActionPerformed
        /* VERIFICA SE AMBAS AS SENHAS DIGITADAS DO CAMPO SÃO IGUAIS, EM CASO AFIRMATIVO, ATRIBUI ESSA SENHA AO USUÁRIO ROOT*/
        if (PasswordFieldNova.getText().equals(PasswordFieldConfirm.getText())) {
            Connection conecta = new Conect().conect();
            String sql = "update tb_usuario set senhaUsuario = ? where nomeUsuario = 'root'";
            try {
                PreparedStatement stmt = conecta.prepareStatement(sql);
                stmt.setString(1, PasswordFieldNova.getText());
                stmt.execute();
                stmt.close();

                JOptionPane.showMessageDialog(this, "Senha configurada com sucesso! parabens!", "Aviso", 1);
                this.dispose();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem!", "Aviso", 1);
        }
    } //GEN-LAST:event_ConfirmarBotaoActionPerformed
    private void PasswordFieldConfirmActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_PasswordFieldConfirmActionPerformed
        // TODO add your handling code here:
    } //GEN-LAST:event_PasswordFieldConfirmActionPerformed
    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_VoltarBotaoActionPerformed
        System.exit(0);
    } //GEN-LAST:event_VoltarBotaoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmarBotao;
    private javax.swing.JPasswordField PasswordFieldConfirm;
    private javax.swing.JPasswordField PasswordFieldNova;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}