package VISUALIZACAO;
import CONEXAO.Conect;
import CONEXAO.Conect_Alugados;
import CONEXAO.Conect_Filme;
import ENTIDADES.Alugados;
import ENTIDADES.Filme;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class JframeAlugar extends javax.swing.JFrame {
    public String getUserLogado() { return userLogado; }

    public void setUserLogado(String userLogado) { this.userLogado = userLogado; }

    private String userLogado = null;

    public JframeAlugar(String usuario) {
        initComponents();
        this.userLogado = usuario;
        listarTabelaAlugados();
    }

    public void listarTabelaAlugados() {
        DefaultTableModel valor = (DefaultTableModel) AlugadosTable.getModel();
        valor.getDataVector().removeAllElements();
        Conect_Alugados aAlugados = new Conect_Alugados();
        List<Alugados> alugados = aAlugados.listarTodos();
        int i = 0;
        while (alugados.size() > i) {
            valor.addRow(new Object[]{String.valueOf(
                alugados.get(i).getId()),
                alugados.get(i).getCliente(),
                alugados.get(i).getFilme(),
                alugados.get(i).getRetirada(),
                alugados.get(i).getEntrega(),
                alugados.get(i).getPreco(),
                alugados.get(i).getVendedor()
            });
            i++;
        }
    }

    private Connection conect;

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
        VendedorText = new javax.swing.JTextField();
        ClienteText = new javax.swing.JTextField();
        DataRetiradaText = new javax.swing.JTextField();
        DataEntregaText = new javax.swing.JTextField();
        FilmeText = new javax.swing.JTextField();
        PrecoText = new javax.swing.JTextField();
        IdText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlugadosTable = new javax.swing.JTable();
        ConfirmarButton = new javax.swing.JButton();
        CriarRadioButton = new javax.swing.JRadioButton();
        AlterarRadioButton = new javax.swing.JRadioButton();
        DetelarRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarBotao.setText("Voltar");
        IdText.setEnabled(false);
        VendedorText.setEnabled(false);
        IdText.setEnabled(false);
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Vendedor:");

        jLabel2.setText("Nome do Cliente:");

        jLabel3.setText("Data de Retirada:");

        jLabel4.setText("Data de Entrega:");

        jLabel5.setText("ID do Filme:");

        jLabel6.setText("Preço(R$):");

        jLabel7.setText("ID da Locação:");

        AlugadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Filme", "Data de Retirada", "Data de Entrega", "Preço", "Vendedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AlugadosTable);
        jScrollPane1.setViewportView(AlugadosTable);
        AlugadosTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (AlugadosTable.getSelectedRow() > -1){
                    try{ IdText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 0).toString());}
                    catch (Exception e) { IdText.setText("0");}
                    try {ClienteText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 1).toString());}
                    catch (Exception e) {ClienteText.setText("N/A");}
                    try{ FilmeText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 2).toString());}
                    catch (Exception e) {FilmeText.setText("N/A");}
                    try { DataRetiradaText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 3).toString());}
                    catch (Exception e) {DataRetiradaText.setText("N/A");}
                    try { DataEntregaText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 4).toString());}
                    catch (Exception e) {DataRetiradaText.setText("N/A");}
                    try { PrecoText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 5).toString());}
                    catch (Exception e) {DataRetiradaText.setText("0");}
                    try { VendedorText.setText(AlugadosTable.getValueAt(AlugadosTable.getSelectedRow(), 6).toString());}
                    catch (Exception e) {DataRetiradaText.setText("N/A");}
                }
            }
        });
        ConfirmarButton.setText("Confirmar");
        ConfirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarButtonActionPerformed(evt);
            }
        });

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

        buttonGroup1.add(DetelarRadioButton);
        DetelarRadioButton.setText("Deletar");
        DetelarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetelarRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VendedorText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ClienteText, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DataRetiradaText, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DataEntregaText))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FilmeText, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PrecoText, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(VoltarBotao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IdText)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ConfirmarButton)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlterarRadioButton)
                            .addComponent(DetelarRadioButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CriarRadioButton)
                                .addGap(50, 50, 50)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(VendedorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ClienteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CriarRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DataRetiradaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(DataEntregaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlterarRadioButton))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FilmeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(PrecoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(IdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DetelarRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(ConfirmarButton))
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

    private void ConfirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarButtonActionPerformed
        /*VERIFICA QUAL BOTAO FOI SELECIONADO E PROCEDE PARA A EXECUÇÃO DO CÓDIGO DEPENDENDO DE QUAL BOTAO FOI SELECIONADO*/
        if (CriarRadioButton.isSelected()){
            try {
            Alugados a = new Alugados();
            a.setCliente(ClienteText.getText());
           try { a.setFilme(Integer.parseInt(FilmeText.getText())); }
           catch (NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Id do Filme deve ser um número!", "Erro de tipo!", 1);;}
             a.setFilme(Integer.parseInt(FilmeText.getText()));
             a.setRetirada(DataRetiradaText.getText());
             a.setEntrega(DataEntregaText.getText());
             try {a.setPreco(Float.parseFloat(PrecoText.getText())); }
             catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Preço deve ser um número!", "Erro de tipo!", 1);;}
             a.setPreco(Float.parseFloat(PrecoText.getText()));
             a.setVendedor(this.userLogado);
             Connection conecta = new Conect().conect();
             String sql2 = "SELECT disponivelFilme from tb_filme where idFilme = ?";
             PreparedStatement stmt = conecta.prepareStatement(sql2);
             stmt.setInt(1,Integer.parseInt(FilmeText.getText()));
             ResultSet rs = stmt.executeQuery();
             int Disponiveisfilmes = 0;
             while(rs.next()) {
                 Disponiveisfilmes = rs.getInt("disponivelFilme");
             }
                if(Disponiveisfilmes <= 0 ) {
                    JOptionPane.showMessageDialog(this, "Não há filmes para locação!", "Erro de quantia!", 1);;
                } else {
                    Disponiveisfilmes= Disponiveisfilmes -1;
                    String sql3 = "UPDATE tb_filme SET disponivelFilme = ? WHERE idFilme = ?";
                    PreparedStatement stmt1 = conecta.prepareStatement(sql3);
                    stmt1.setInt(1,(Disponiveisfilmes));
                    stmt1.setInt(2,(Integer.parseInt(FilmeText.getText())));
                    stmt1.execute();
                    Conect_Alugados aConect = new Conect_Alugados();
                    aConect.salvar(a);
                    listarTabelaAlugados();
                    JOptionPane.showMessageDialog(this, "O aluguel foi feito com sucesso!", "Aviso", 1);
                }

    } catch(Exception e) {
        System.out.println(e);
    }
        } else if (AlterarRadioButton.isSelected()) {
            try {
                Alugados a = new Alugados();
                Connection conecta = new Conect().conect();
                String sql1 = "select * from tb_alugados where idAlugados = ?";
                PreparedStatement stmt = conecta.prepareStatement(sql1);
                stmt.setInt(1, Integer.parseInt(IdText.getText()));
                ResultSet rs = stmt.executeQuery();
                String tempCliente = null;
                int tempFilme = 0;
                String tempRetirada = null;
                String tempEntrega = null;
                float tempPreco = 0.0f;
                String tempVendedor = null;
                /*VERIFICA SE OS CAMPOS ESTÃO PREENCHIDOS OU NÃO, CASO NÃO ESTEJAM, SEU VALOR SERÁ ENVIADO COM O MESMO VALOR ANTERIORMENTE ESTABELECIDO NO BANCO DE DADOS*/
                while (rs.next()) {
                    tempCliente = rs.getString("clienteAlugados");
                    tempFilme = rs.getInt("filmeAlugados");
                    tempRetirada = rs.getString("retiradaAlugados");
                    tempEntrega = rs.getString("entregaAlugados");
                    tempPreco = rs.getFloat("precoAlugados");
                    tempVendedor = rs.getString("usuarioAlugados");
                }
                a.setId(Integer.parseInt(IdText.getText()));
                if (ClienteText.getText().equals(tempCliente)) { a.setCliente(tempCliente); }
                else { a.setCliente(ClienteText.getText()); }
                if (Integer.parseInt(FilmeText.getText()) == tempFilme) { a.setFilme(tempFilme); }
                else {try { a.setFilme(Integer.parseInt(FilmeText.getText())); }
                catch (NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Id do Filme deve ser um número!", "Erro de tipo!", 1);;} }
                if (DataRetiradaText.getText().equals(tempRetirada)) { a.setRetirada(tempRetirada); }
                else { a.setRetirada(DataRetiradaText.getText()); }
                if (DataEntregaText.getText().equals(tempEntrega)) { a.setEntrega(tempEntrega); }
                else { a.setEntrega(DataEntregaText.getText()); }
                if (Float.parseFloat(PrecoText.getText()) == tempPreco) { a.setPreco(tempPreco); }
                else { try {a.setPreco(Float.parseFloat(PrecoText.getText())); }
                catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Preço deve ser um número!", "Erro de tipo!", 1);;} }
                if (VendedorText.getText().equals(tempVendedor)) { a.setVendedor(tempVendedor); }
                else { a.setVendedor(VendedorText.getText()); }
            Conect_Alugados aConect = new Conect_Alugados();
            aConect.alterar(a);
            listarTabelaAlugados();
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Aviso", 1);
        } catch(Exception e) {
            System.out.println(e);
        }
        } else {
            /*VERIFICA A ID SELECIONADA E CASO A ID ESTEJA PRESENTE,OS DADOS EM TAL ID SÃO DELETADOS*/
            try {
            Alugados a = new Alugados();
            a.setId(Integer.parseInt(IdText.getText()));
            Connection conecta = new Conect().conect();
            String sql4 = "SELECT disponivelFilme FROM tb_filme WHERE idFilme = ?";
            PreparedStatement stmt2 = conecta.prepareStatement(sql4);
            stmt2.setInt(1,Integer.parseInt(FilmeText.getText()));
            ResultSet rs2 = stmt2.executeQuery();
            int Disponiveisfilmes2 = 0;
            while(rs2.next()) {
                Disponiveisfilmes2 = rs2.getInt("disponivelFilme");
                Disponiveisfilmes2 = Disponiveisfilmes2 + 1;
                String sql7 = "UPDATE tb_filme SET disponivelFilme = ? WHERE idFilme = ?";
                PreparedStatement stmt3 = conecta.prepareStatement(sql7);
                stmt3.setInt(1,(Disponiveisfilmes2));
                stmt3.setInt(2,(Integer.parseInt(FilmeText.getText())));
                stmt3.execute();
            }
            Conect_Alugados aConect = new Conect_Alugados();
            aConect.deletar(a);
            listarTabelaAlugados();
            JOptionPane.showMessageDialog(this, "Deletado com sucesso!", "Aviso", 1);
        } catch(Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Valores Incorretos foram inseridos!", "Aviso", 1);
        }
        }
    }//GEN-LAST:event_ConfirmarButtonActionPerformed

    private void CriarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarRadioButtonActionPerformed
        ClienteText.setEnabled(true);
        ClienteText.setText(null);
        DataEntregaText.setEnabled(true);
        DataEntregaText.setText(null);
        DataRetiradaText.setEnabled(true);
        DataRetiradaText.setText(null);
        PrecoText.setEnabled(true);
        PrecoText.setText(null);
        FilmeText.setEnabled(true);
        FilmeText.setText(null);
        VendedorText.setEnabled(false);
        VendedorText.setText(null);
        IdText.setText(null);
    }//GEN-LAST:event_CriarRadioButtonActionPerformed

    private void AlterarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarRadioButtonActionPerformed
        ClienteText.setEnabled(true);
        DataEntregaText.setEnabled(true);
        DataRetiradaText.setEnabled(true);
        PrecoText.setEnabled(true);
        FilmeText.setEnabled(true);
        VendedorText.setEnabled(userLogado.equals("root"));
    }//GEN-LAST:event_AlterarRadioButtonActionPerformed

    private void DetelarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetelarRadioButtonActionPerformed
        ClienteText.setEnabled(false);
        DataEntregaText.setEnabled(false);
        DataRetiradaText.setEnabled(false);
        PrecoText.setEnabled(false);
        FilmeText.setEnabled(false);
        VendedorText.setEnabled(false);
    }//GEN-LAST:event_DetelarRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AlterarRadioButton;
    private javax.swing.JTable AlugadosTable;
    private javax.swing.JTextField ClienteText;
    private javax.swing.JButton ConfirmarButton;
    private javax.swing.JRadioButton CriarRadioButton;
    private javax.swing.JTextField DataEntregaText;
    private javax.swing.JTextField DataRetiradaText;
    private javax.swing.JRadioButton DetelarRadioButton;
    private javax.swing.JTextField FilmeText;
    private javax.swing.JTextField IdText;
    private javax.swing.JTextField PrecoText;
    private javax.swing.JTextField VendedorText;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
