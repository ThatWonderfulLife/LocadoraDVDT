package VISUALIZACAO;
import CONEXAO.Conect;
import ENTIDADES.Pessoa;
import CONEXAO.Conect_Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class JframeEditarCliente extends javax.swing.JFrame {
    public String getUserLogado() { return userLogado; }

    public void setUserLogado(String userLogado) { this.userLogado = userLogado; }

    private String userLogado = null;

    public JframeEditarCliente(String usuario) {
        initComponents();
        this.userLogado = usuario;
        DeletarRadioBotao.setEnabled(userLogado.equals("root"));
        listarTabelaClientes();
    }

    public void listarTabelaClientes() {
        DefaultTableModel valor = (DefaultTableModel) TabelaCliente.getModel();
        valor.getDataVector().removeAllElements();
        Conect_Pessoa cCliente = new Conect_Pessoa();
        List<Pessoa> cliente = cCliente.listarTodos();
        int i = 0;
        while (cliente.size() > i) {
            valor.addRow(new Object[]{String.valueOf(
            cliente.get(i).getIdPessoa()),
            cliente.get(i).getNomePessoa(),
            cliente.get(i).getTelefonePessoa(),
            cliente.get(i).getEmailPessoa(),
            cliente.get(i).getEnderecoPessoa(),
            cliente.get(i).getDataDeNascPessoa(),
            cliente.get(i).getSexoPessoa(),
            cliente.get(i).getCpfPessoa()});
            i++;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        VoltarBotao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IdTextBox = new javax.swing.JTextField();
        NomeTextBox = new javax.swing.JTextField();
        TelefoneTextBox = new javax.swing.JTextField();
        EmailTextBox = new javax.swing.JTextField();
        EnderecoTextBox = new javax.swing.JTextField();
        DataDeNascTextBox = new javax.swing.JTextField();
        SexoTextBox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CpfTextBox = new javax.swing.JTextField();
        CriarRadioButton = new javax.swing.JRadioButton();
        AlterarRadioButton = new javax.swing.JRadioButton();
        DeletarRadioBotao = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCliente = new javax.swing.JTable();
        ConfirmarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("E-Mail");

        jLabel5.setText("Endereço:");

        jLabel6.setText("Data De Nascimento:");

        jLabel7.setText("Sexo:");

        jLabel8.setText("CPF:");

        CpfTextBox.setText(" ");

        buttonGroup1.add(CriarRadioButton);
        CriarRadioButton.setSelected(true);
        CriarRadioButton.setText("Criar");
        CriarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(AlterarRadioButton);
        AlterarRadioButton.setText("Alterar");
        AlterarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(DeletarRadioBotao);
        DeletarRadioBotao.setText("Deletar");
        DeletarRadioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarRadioBotaoActionPerformed(evt);
            }
        });

        TabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "E-Mail", "Endereço", "Data de Nascimento", "Sexo", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaCliente);
        TabelaCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (TabelaCliente.getSelectedRow() > -1){
                    try{ IdTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 0).toString());}
                    catch (Exception e) { IdTextBox.setText("0");}
                    try {NomeTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 1).toString());}
                    catch (Exception e) {NomeTextBox.setText("N/A");}
                    try{ TelefoneTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 2).toString());}
                    catch (Exception e) {TelefoneTextBox.setText("N/A");}
                    try { EmailTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 3).toString());}
                    catch (Exception e) {EmailTextBox.setText("N/A");}
                    try { EnderecoTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 4).toString());}
                    catch (Exception e) {EnderecoTextBox.setText("N/A");}
                    try { DataDeNascTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 5).toString());}
                    catch (Exception e) {DataDeNascTextBox.setText("N/A");}
                    try { SexoTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 6).toString());}
                    catch (Exception e) {SexoTextBox.setText("N/A");}
                    try { CpfTextBox.setText(TabelaCliente.getValueAt(TabelaCliente.getSelectedRow(), 7).toString());}
                    catch (Exception e) {CpfTextBox.setText("N/A");}

                }
            }
        });
        ConfirmarButton.setText("Confirmar");
        IdTextBox.setEnabled(false);
        ConfirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VoltarBotao)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EmailTextBox)
                                        .addComponent(TelefoneTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(EnderecoTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(DataDeNascTextBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CriarRadioButton)
                                            .addComponent(AlterarRadioButton)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CpfTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(SexoTextBox))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DeletarRadioBotao)
                                            .addComponent(ConfirmarButton))))))
                        .addGap(0, 350, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IdTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NomeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TelefoneTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(EmailTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(VoltarBotao))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(EnderecoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CriarRadioButton))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(DataDeNascTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AlterarRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(SexoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeletarRadioBotao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(CpfTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConfirmarButton))))
                .addGap(1, 1, 1))
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
        IdTextBox.setEditable(false);
        IdTextBox.setText(null);
        NomeTextBox.setEditable(true);
        NomeTextBox.setText(null);
        TelefoneTextBox.setEditable(true);
        TelefoneTextBox.setText(null);
        CpfTextBox.setEditable(true);
        CpfTextBox.setText(null);
        EmailTextBox.setEditable(true);
        EmailTextBox.setText(null);
        EnderecoTextBox.setEditable(true);
        EnderecoTextBox.setText(null);
        DataDeNascTextBox.setEditable(true);
        DataDeNascTextBox.setText(null);
        SexoTextBox.setEditable(true);
        SexoTextBox.setText(null);

    }//GEN-LAST:event_CriarRadioButtonActionPerformed

    private void AlterarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarRadioButtonActionPerformed
        IdTextBox.setEnabled(false);
        NomeTextBox.setEnabled(true);
        TelefoneTextBox.setEnabled(true);
        CpfTextBox.setEnabled(true);
        EmailTextBox.setEnabled(true);
        EnderecoTextBox.setEnabled(true);
        DataDeNascTextBox.setEnabled(true);
        SexoTextBox.setEnabled(true);
    }//GEN-LAST:event_AlterarRadioButtonActionPerformed

    private void DeletarRadioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarRadioBotaoActionPerformed
        IdTextBox.setEnabled(false);
        NomeTextBox.setEnabled(false);
        TelefoneTextBox.setEnabled(false);
        CpfTextBox.setEnabled(false);
        EmailTextBox.setEnabled(false);
        EnderecoTextBox.setEnabled(false);
        DataDeNascTextBox.setEnabled(false);
        SexoTextBox.setEnabled(false);
    }//GEN-LAST:event_DeletarRadioBotaoActionPerformed

    private void ConfirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarButtonActionPerformed
        /*VERIFICA QUAL BOTAO FOI SELECIONADO E PROCEDE PARA A EXECUÇÃO DO CÓDIGO DEPENDENDO DE QUAL BOTAO FOI SELECIONADO*/
        if (CriarRadioButton.isSelected()){
            try {
            Pessoa c = new Pessoa();
            c.setNomePessoa(NomeTextBox.getText());
            c.setCpfPessoa(CpfTextBox.getText());
            c.setSexoPessoa(SexoTextBox.getText());
            c.setTelefonePessoa(TelefoneTextBox.getText());
            c.setEmailPessoa(EmailTextBox.getText());
            c.setEnderecoPessoa(EnderecoTextBox.getText());
            c.setDataDeNascPessoa(DataDeNascTextBox.getText());
            Conect_Pessoa cConect = new Conect_Pessoa();
            cConect.salvar(c);
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!", "Aviso",1);
            listarTabelaClientes();
    } catch(Exception e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(this, "Valores Incorretos foram inseridos!", "Aviso", 1);
    }
        } else if (AlterarRadioButton.isSelected()) {
            try {
                Pessoa c = new Pessoa();
            Connection conecta = new Conect().conect();
            String sql1 = "select * from tb_pessoa where idPessoa = ?";
            PreparedStatement stmt = conecta.prepareStatement(sql1);
            stmt.setInt(1, Integer.parseInt(IdTextBox.getText()));
            ResultSet rs = stmt.executeQuery();
            String tempNome = null;
            String tempCpf = null;
            String tempSexo = null;
            String tempTelefone = null;
            String tempEmail = null;
            String tempEndereco = null;
            String tempDataNasc = null;
            /*VERIFICA SE OS CAMPOS ESTÃO PREENCHIDOS OU NÃO, CASO NÃO ESTEJAM, SEU VALOR SERÁ ENVIADO COM O MESMO VALOR ANTERIORMENTE ESTABELECIDO NO BANCO DE DADOS*/
            while(rs.next()) {
                tempNome = rs.getString("nomePessoa");
                tempCpf = rs.getString("cpfPessoa");
                tempTelefone = rs.getString("telefonePessoa");
                tempEmail = rs.getString("emailPessoa");
                tempEndereco = rs.getString("enderecoPessoa");
                tempDataNasc = rs.getString("dataDeNascPessoa");
                tempSexo = rs.getString("sexoPessoa");
            }
            c.setIdPessoa(Integer.parseInt(IdTextBox.getText()));
            if (NomeTextBox.getText().equals(tempNome)) {c.setNomePessoa(tempNome); }
            else {c.setNomePessoa(NomeTextBox.getText()); }
            if (CpfTextBox.getText().equals(tempCpf)) { c.setCpfPessoa(tempCpf); }
            else { c.setCpfPessoa(CpfTextBox.getText()); }
            if (SexoTextBox.getText().equals(tempSexo)) { c.setSexoPessoa(tempSexo); }
            else { c.setSexoPessoa(SexoTextBox.getText()); }
            if (TelefoneTextBox.getText().equals(tempTelefone)) { c.setTelefonePessoa(tempTelefone); }
            else { c.setTelefonePessoa(TelefoneTextBox.getText()); }
            if (EmailTextBox.getText().equals(tempEmail)) { c.setEmailPessoa(tempEmail); }
            else { c.setEmailPessoa(EmailTextBox.getText()); }
            if (EnderecoTextBox.getText().equals(tempEndereco)) { c.setEnderecoPessoa(tempEndereco); }
            else { c.setEnderecoPessoa(EnderecoTextBox.getText()); }
            if (DataDeNascTextBox.getText().equals(tempDataNasc)) { c.setDataDeNascPessoa(tempDataNasc); }
            else { c.setDataDeNascPessoa(DataDeNascTextBox.getText()); }
            Conect_Pessoa cConect = new Conect_Pessoa();
            cConect.alterar(c);
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Aviso", 1);
            listarTabelaClientes();
        } catch(Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Valores Incorretos foram inseridos!", "Aviso", 1);
        }
        } else {
            /*VERIFICA A ID SELECIONADA E CASO A ID ESTEJA PRESENTE,OS DADOS EM TAL ID SÃO DELETADOS*/
            try {
            Pessoa c = new Pessoa();
            c.setIdPessoa(Integer.parseInt(IdTextBox.getText()));
            Conect_Pessoa cConect = new Conect_Pessoa();
            cConect.deletar(c);
            JOptionPane.showMessageDialog(this, "Deletado com sucesso!", "Aviso", 1);
            listarTabelaClientes();
        } catch(Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Valores Incorretos foram inseridos!", "Aviso", 1);
        }
        }
    }//GEN-LAST:event_ConfirmarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AlterarRadioButton;
    private javax.swing.JButton ConfirmarButton;
    private javax.swing.JTextField CpfTextBox;
    private javax.swing.JRadioButton CriarRadioButton;
    private javax.swing.JTextField DataDeNascTextBox;
    private javax.swing.JRadioButton DeletarRadioBotao;
    private javax.swing.JTextField EmailTextBox;
    private javax.swing.JTextField EnderecoTextBox;
    private javax.swing.JTextField IdTextBox;
    private javax.swing.JTextField NomeTextBox;
    private javax.swing.JTextField SexoTextBox;
    private javax.swing.JTable TabelaCliente;
    private javax.swing.JTextField TelefoneTextBox;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
