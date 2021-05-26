package VISUALIZACAO;
import CONEXAO.Conect;
import CONEXAO.Conect_UsuarioN;
import ENTIDADES.UsuarioN;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class JframeEditarUsuario extends javax.swing.JFrame {
    public String getUserLogado() { return userLogado; }

    public void setUserLogado(String userLogado) { this.userLogado = userLogado; }

    private String userLogado = null;

    public JframeEditarUsuario(String usuario) {
        initComponents();
        this.userLogado = usuario;
        SenhaTextField.setEnabled(this.userLogado.equals("root"));
        listarTabelaClientes();
    }

    public void listarTabelaClientes() {
        DefaultTableModel valor = (DefaultTableModel) UsuariosTable.getModel();
        valor.getDataVector().removeAllElements();
        Conect_UsuarioN cUsuario = new Conect_UsuarioN();
        List<UsuarioN> usuario = cUsuario.listarTodos();
        int i = 0;
        while (usuario.size() > i) {
            valor.addRow(new Object[]{String.valueOf(
                usuario.get(i).getIdPessoa()),
                usuario.get(i).getNomePessoa(),
                usuario.get(i).getCpfPessoa(),
                usuario.get(i).getTelefonePessoa(),
                usuario.get(i).getEmailPessoa(), //errado
                usuario.get(i).getEnderecoPessoa(),
                usuario.get(i).getSalarioUsuario()
            });
            i++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        VoltarBotao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SalarioTextBox = new javax.swing.JTextField();
        CpfTextBox = new javax.swing.JTextField();
        NomeTextBox = new javax.swing.JTextField();
        IdTextBox = new javax.swing.JTextField();
        ConfirmarBotao = new javax.swing.JButton();
        CriarRadioButton = new javax.swing.JRadioButton();
        AlterarRadioButton = new javax.swing.JRadioButton();
        DeletarRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsuariosTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        SenhaTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TelefoneText = new javax.swing.JTextField();
        EmailText = new javax.swing.JTextField();
        EnderecoText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Salário:");

        ConfirmarBotao.setText("Confirmar");
        ConfirmarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarBotaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(CriarRadioButton);
        CriarRadioButton.setSelected(true);
        CriarRadioButton.setText("Criar Funcionário");
        CriarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(AlterarRadioButton);
        AlterarRadioButton.setText("Alterar Funcionário");
        AlterarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(DeletarRadioButton);
        DeletarRadioButton.setText("Deletar Funcionário");
        DeletarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarRadioButtonActionPerformed(evt);
            }
        });

        UsuariosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "E-mail", "Endereço", "Salário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(UsuariosTable);
        IdTextBox.setEnabled(false);

        UsuariosTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (UsuariosTable.getSelectedRow() > -1){
                    try{ IdTextBox.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 0).toString());}
                    catch (Exception e) { IdTextBox.setText("0");}
                    try {NomeTextBox.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 1).toString());}
                    catch (Exception e) {NomeTextBox.setText("N/A");}
                    try{ CpfTextBox.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 2).toString());}
                    catch (Exception e) {CpfTextBox.setText("N/A");}
                    try { TelefoneText.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 3).toString());}
                    catch (Exception e) {TelefoneText.setText("N/A");}
                    try { EmailText.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 4).toString());}
                    catch (Exception e) {EmailText.setText("N/A");}
                    try { EnderecoText.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 5).toString());}
                    catch (Exception e) {EnderecoText.setText("N/A");}
                    try { SalarioTextBox.setText(UsuariosTable.getValueAt(UsuariosTable.getSelectedRow(), 6).toString());}
                    catch (Exception e) {SalarioTextBox.setText("0");}

                }
            }
        });

        jLabel6.setText("Senha:");

        jLabel5.setText("Telefone:");

        jLabel7.setText("E-mail:");

        jLabel8.setText("Endereço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EnderecoText))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VoltarBotao)
                        .addGap(70, 70, 70)
                        .addComponent(CriarRadioButton)
                        .addGap(78, 78, 78)
                        .addComponent(AlterarRadioButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TelefoneText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)
                                .addComponent(CpfTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeletarRadioButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SalarioTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(SenhaTextField)))
                    .addComponent(ConfirmarBotao))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IdTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NomeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(EnderecoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CpfTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TelefoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(SenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(SalarioTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CriarRadioButton)
                        .addComponent(AlterarRadioButton)
                        .addComponent(DeletarRadioButton))
                    .addComponent(ConfirmarBotao)
                    .addComponent(VoltarBotao))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBotaoActionPerformed
        this.dispose();
        JframeInicial telaInicial = new JframeInicial(userLogado);
        telaInicial.setVisible(true);
        telaInicial.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaInicial.setLocationRelativeTo(null);     
    }//GEN-LAST:event_VoltarBotaoActionPerformed

    private void CriarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarRadioButtonActionPerformed
            IdTextBox.setText(null);
            NomeTextBox.setEnabled(true);
            NomeTextBox.setText(null);
            CpfTextBox.setEnabled(true);
            CpfTextBox.setText(null);
            SalarioTextBox.setEnabled(true);
            SalarioTextBox.setText(null);
            EmailText.setEnabled(true);
            EmailText.setText(null);
            EnderecoText.setEnabled(true);
            EnderecoText.setText(null);
            SenhaTextField.setEnabled(true);
            SenhaTextField.setText(null);
            TelefoneText.setEnabled(true);
            TelefoneText.setText(null);

    }//GEN-LAST:event_CriarRadioButtonActionPerformed

    private void ConfirmarBotaoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ConfirmarBotaoActionPerformed
        /*VERIFICA QUAL BOTAO FOI SELECIONADO E PROCEDE PARA A EXECUÇÃO DO CÓDIGO DEPENDENDO DE QUAL BOTAO FOI SELECIONADO*/
            if (CriarRadioButton.isSelected()){
                try {
                    UsuarioN u = new UsuarioN();
                    u.setNomePessoa(NomeTextBox.getText());
                    u.setCpfPessoa(CpfTextBox.getText());
                    u.setTelefonePessoa(TelefoneText.getText());
                    u.setEnderecoPessoa(EnderecoText.getText());
                    u.setEmailPessoa(EmailText.getText());
                    try{ u.setSalarioUsuario(Float.parseFloat(SalarioTextBox.getText()));}
                    catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Salário deve ser um número!", "Erro de tipo!", 1);;}
                    u.setSalarioUsuario(Float.parseFloat(SalarioTextBox.getText()));
                    u.setSenhaUsuario(SenhaTextField.getText());
                    Conect_UsuarioN uConect = new Conect_UsuarioN();
                    uConect.salvar(u);
                    JOptionPane.showMessageDialog(this, "Salvo com sucesso!", "Aviso", 1);
                    listarTabelaClientes();
                } catch(Exception e) {
                    System.out.println(e);
                }
            } else if (AlterarRadioButton.isSelected()) {
                try {
                    UsuarioN u = new UsuarioN();
                    Connection conecta = new Conect().conect();
                    String sql1 = "Select p.*, u.*" +
                            "From tb_pessoa p " +
                            "INNER JOIN tb_usuario u on p.nomePessoa = u.nomeUsuario " +
                            "WHERE idPessoa = ?";
                    PreparedStatement stmt = conecta.prepareStatement(sql1);
                    stmt.setInt(1, Integer.parseInt(IdTextBox.getText()));
                    ResultSet rs = stmt.executeQuery();
                    String tempNome = null;
                    String tempCpf = null;
                    String tempTelefone = null;
                    String tempEmail = null;
                    String tempEndereco = null;
                    float tempSalario = 0.0f;
                    String tempSenha = null;
                    /*VERIFICA SE OS CAMPOS ESTÃO PREENCHIDOS OU NÃO, CASO NÃO ESTEJAM, SEU VALOR SERÁ ENVIADO COM O MESMO VALOR ANTERIORMENTE ESTABELECIDO NO BANCO DE DADOS*/
                    while (rs.next()) {
                        tempNome = rs.getString("nomePessoa");
                        tempCpf = rs.getString("cpfPessoa");
                        tempTelefone = rs.getString("telefonePessoa");
                        tempEmail = rs.getString("emailPessoa");
                        tempEndereco = rs.getString("enderecoPessoa");
                        tempSalario = rs.getFloat("salarioUsuario");
                        tempSenha = rs.getString("senhaUsuario");
                    }
                    u.setIdPessoa(Integer.parseInt(IdTextBox.getText()));
                    if (NomeTextBox.getText().equals(tempNome)) { u.setNomePessoa(tempNome); }
                    else { u.setNomePessoa(NomeTextBox.getText()); }
                    if (CpfTextBox.getText().equals(tempCpf)) { u.setCpfPessoa(tempCpf); }
                    else { u.setCpfPessoa(CpfTextBox.getText()); }
                    if (TelefoneText.getText().equals(tempTelefone)) { u.setTelefonePessoa(tempTelefone); }
                    else { u.setTelefonePessoa(TelefoneText.getText()); }
                    if (EmailText.getText().equals(tempEmail)) { u.setEmailPessoa(tempEmail); }
                    else { u.setEmailPessoa(EmailText.getText()); }
                    if (EnderecoText.getText().equals(tempEndereco)) { u.setEnderecoPessoa(tempEndereco); }
                    else { u.setEnderecoPessoa(EnderecoText.getText()); }
                    if (Float.parseFloat(SalarioTextBox.getText()) == (tempSalario)) { u.setSalarioUsuario(tempSalario); }
                    else { try{ u.setSalarioUsuario(Float.parseFloat(SalarioTextBox.getText()));}
                    catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Salário deve ser um número!", "Erro de tipo!", 1);;} }
                    if (SenhaTextField.getText().equals(tempSenha)) { u.setSenhaUsuario(tempSenha); }
                    else { u.setSenhaUsuario(SenhaTextField.getText()); }
                    Conect_UsuarioN uConect = new Conect_UsuarioN();
                    uConect.alterar(u);
                    listarTabelaClientes();
                    JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Aviso", 1);
                } catch(Exception e) {
                    System.out.println(e);
                }
            } else if (DeletarRadioButton.isSelected()){
                /*VERIFICA A ID SELECIONADA E CASO A ID ESTEJA PRESENTE,OS DADOS EM TAL ID SÃO DELETADOS*/
                try {
                    UsuarioN u = new UsuarioN();
                    u.setIdPessoa(Integer.parseInt(IdTextBox.getText()));
                    Conect_UsuarioN uConect = new Conect_UsuarioN();
                    uConect.deletar(u);
                    listarTabelaClientes();
                    JOptionPane.showMessageDialog(this, "Deletado com sucesso!", "Aviso", 1);
                } catch(Exception e) {
                    System.out.println(3);
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Valores Incorretos foram inseridos!", "Aviso", 1);
                }
            }          
    }//GEN-LAST:event_ConfirmarBotaoActionPerformed

    private void DeletarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarRadioButtonActionPerformed
            EmailText.setEnabled(false);
            EnderecoText.setEnabled(false);
            TelefoneText.setEnabled(false);
            NomeTextBox.setEnabled(false);
            CpfTextBox.setEnabled(false);
            SalarioTextBox.setEnabled(false);
            SenhaTextField.setEnabled(false);
    }//GEN-LAST:event_DeletarRadioButtonActionPerformed

    private void AlterarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarRadioButtonActionPerformed
            NomeTextBox.setEnabled(true);
            CpfTextBox.setEnabled(true);
            SalarioTextBox.setEnabled(true);
            SenhaTextField.setEnabled(userLogado.equals("root"));
    }//GEN-LAST:event_AlterarRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AlterarRadioButton;
    private javax.swing.JButton ConfirmarBotao;
    private javax.swing.JTextField CpfTextBox;
    private javax.swing.JRadioButton CriarRadioButton;
    private javax.swing.JRadioButton DeletarRadioButton;
    private javax.swing.JTextField EmailText;
    private javax.swing.JTextField EnderecoText;
    private javax.swing.JTextField IdTextBox;
    private javax.swing.JTextField NomeTextBox;
    private javax.swing.JTextField SalarioTextBox;
    private javax.swing.JTextField SenhaTextField;
    private javax.swing.JTextField TelefoneText;
    private javax.swing.JTable UsuariosTable;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
