package VISUALIZACAO;
import CONEXAO.Conect;
import ENTIDADES.Filme;
import CONEXAO.Conect_Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;

public class JframeEditarFilme extends javax.swing.JFrame {
    public String getUserLogado() { return userLogado; }

    public void setUserLogado(String userLogado) { this.userLogado = userLogado; }

    private String userLogado = null;

    public JframeEditarFilme(String usuario) {
        initComponents();
        this.userLogado = usuario;
        atualizarListaFilmes();
    }

public void atualizarListaFilmes() {
    DefaultTableModel valor = (DefaultTableModel) TabelaFilmes.getModel();
        valor.getDataVector().removeAllElements();
        Conect_Filme cFilme = new Conect_Filme();
        List<Filme> filme = cFilme.listarTodos();
        int i = 0;
        while (filme.size() > i) {
            valor.addRow(new Object[]{String.valueOf(
                filme.get(i).getId()),
                filme.get(i).getNome(),
                filme.get(i).getAnoLancamento(),
                filme.get(i).getFaixa(),
                filme.get(i).getDiretor(),
                filme.get(i).getGenero(),
                filme.get(i).getDisponiveis(),
                filme.get(i).getSinopse()});
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
        SinopseTextBox = new javax.swing.JLabel();
        GeneroTextBox = new javax.swing.JTextField();
        DiretorTextBox = new javax.swing.JTextField();
        FaixaEtariaTextBox = new javax.swing.JTextField();
        LancamentoTextBox = new javax.swing.JTextField();
        NomeTextBox = new javax.swing.JTextField();
        IdTextBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SinopseTextArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        DisponiveisTextBox = new javax.swing.JTextField();
        ConfirmarBotao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaFilmes = new javax.swing.JTable();
        CriarRadioButton = new javax.swing.JRadioButton();
        AlterarRadioButton = new javax.swing.JRadioButton();
        DeletarRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarBotao.setText("Voltar");
        IdTextBox.setEnabled(false);
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Lançamento:");

        jLabel4.setText("Faixa Etária:");

        jLabel5.setText("Diretor:");

        jLabel6.setText("Genero:");

        SinopseTextBox.setText("Sinopse:");

        SinopseTextArea.setColumns(20);
        SinopseTextArea.setRows(5);
        jScrollPane1.setViewportView(SinopseTextArea);

        jLabel7.setText("Disponíveis:");

        DisponiveisTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisponiveisTextBoxActionPerformed(evt);
            }
        });

        ConfirmarBotao.setText("Confirmar");
        ConfirmarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarBotaoActionPerformed(evt);
            }
        });

        TabelaFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Lançamento", "Faixa Etária", "Diretor", "Genero", "Disponiveis", "Sinopse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabelaFilmes);
        IdTextBox.setEnabled(false);
        TabelaFilmes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (TabelaFilmes.getSelectedRow() > -1){
                    try{ IdTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 0).toString());}
                    catch (Exception e) { IdTextBox.setText("0");}
                    try {NomeTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 1).toString());}
                    catch (Exception e) {NomeTextBox.setText("N/A");}
                    try{ FaixaEtariaTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 2).toString());}
                    catch (Exception e) {FaixaEtariaTextBox.setText("0");}
                    try { LancamentoTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 3).toString());}
                    catch (Exception e) {LancamentoTextBox.setText("0");}
                    try { DiretorTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 4).toString());}
                    catch (Exception e) {DiretorTextBox.setText("N/A");}
                    try { GeneroTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 5).toString());}
                    catch (Exception e) {GeneroTextBox.setText("N/A");}
                    try { DisponiveisTextBox.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 6).toString());}
                    catch (Exception e) {DisponiveisTextBox.setText("0");}
                    try { SinopseTextArea.setText(TabelaFilmes.getValueAt(TabelaFilmes.getSelectedRow(), 7).toString());}
                    catch (Exception e) {SinopseTextArea.setText("N/A");}
                }
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

        buttonGroup1.add(DeletarRadioButton);
        DeletarRadioButton.setText("Deletar");
        DeletarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IdTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NomeTextBox)
                                    .addComponent(LancamentoTextBox)
                                    .addComponent(FaixaEtariaTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addComponent(VoltarBotao))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DiretorTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(GeneroTextBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SinopseTextBox))
                                    .addComponent(DisponiveisTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AlterarRadioButton)
                                            .addComponent(DeletarRadioButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ConfirmarBotao))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(CriarRadioButton)
                                        .addGap(166, 166, 166)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(VoltarBotao)
                                    .addComponent(ConfirmarBotao)))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IdTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NomeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LancamentoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(DiretorTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SinopseTextBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(GeneroTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(DisponiveisTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FaixaEtariaTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(CriarRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AlterarRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeletarRadioButton))))
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

    private void DisponiveisTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisponiveisTextBoxActionPerformed

    }//GEN-LAST:event_DisponiveisTextBoxActionPerformed

    private void ConfirmarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarBotaoActionPerformed
        /*VERIFICA QUAL BOTAO FOI SELECIONADO E PROCEDE PARA A EXECUÇÃO DO CÓDIGO DEPENDENDO DE QUAL BOTAO FOI SELECIONADO*/
        if (CriarRadioButton.isSelected()){
            try {
            Filme f = new Filme();
            f.setNome(NomeTextBox.getText());
            f.setFaixa(FaixaEtariaTextBox.getText());
            try{ f.setAnoLancamento(Integer.parseInt(LancamentoTextBox.getText()));}
            catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Ano deve ser um número!", "Erro de tipo!", 1);;}
            f.setAnoLancamento(Integer.parseInt(LancamentoTextBox.getText()));
            f.setDiretor(DiretorTextBox.getText());
            f.setGenero(GeneroTextBox.getText());
            try{ f.setDisponiveis(Integer.parseInt(DisponiveisTextBox.getText()));}
            catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "Os disponíveis devem ser um número!", "Erro de tipo!", 1);;}
            f.setDisponiveis(Integer.parseInt(DisponiveisTextBox.getText()));
            f.setSinopse(SinopseTextArea.getText());
            Conect_Filme fConect = new Conect_Filme();
            fConect.salvar(f);
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!", "Aviso", 1);
            atualizarListaFilmes();
    } catch(Exception e) {
        System.out.println(e);
    }
        } else if (AlterarRadioButton.isSelected()) {
            try {
            Filme f = new Filme();
            Connection conecta = new Conect().conect();
            String sql1 = "select * from tb_filme where idFilme = ?";
            PreparedStatement stmt = conecta.prepareStatement(sql1);
            stmt.setInt(1, Integer.parseInt(IdTextBox.getText()));
            ResultSet rs = stmt.executeQuery();
            String tempNome = null;
            String tempFaixa = null;
            int tempAnoLancamento = 0;
            String tempDiretor = null;
            String tempGenero = null;
            int tempDisponiveis = 0;
            String tempSinopse = null;
            /*VERIFICA SE OS CAMPOS ESTÃO PREENCHIDOS OU NÃO, CASO NÃO ESTEJAM, SEU VALOR SERÁ ENVIADO COM O MESMO VALOR ANTERIORMENTE ESTABELECIDO NO BANCO DE DADOS*/
            while(rs.next()) {
                tempNome = rs.getString("nomeFilme");
                tempFaixa = rs.getString("faixaEtariaFilme");
                tempAnoLancamento = rs.getInt("lancamentoFilme");
                tempDiretor = rs.getString("diretorFilme");
                tempGenero = rs.getString("generoFilme");
                tempDisponiveis = rs.getInt("disponivelFilme");
                tempSinopse = rs.getString("sinopseFilme");
            }
                f.setId(Integer.parseInt(IdTextBox.getText()));
                if (NomeTextBox.getText().equals(tempNome)) { f.setNome(tempNome); }
                else { f.setNome(NomeTextBox.getText()); }
                if (FaixaEtariaTextBox.getText().equals(tempFaixa)) { f.setFaixa(tempFaixa); }
                else { f.setFaixa(FaixaEtariaTextBox.getText()); }
                if (Integer.parseInt(LancamentoTextBox.getText()) == tempAnoLancamento ) { f.setAnoLancamento(tempAnoLancamento); }
                else {try{ f.setAnoLancamento(Integer.parseInt(LancamentoTextBox.getText()));}
                catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Ano deve ser um número!", "Erro de tipo!", 1);;} }
                if (DiretorTextBox.getText().equals(tempDiretor)) { f.setDiretor(tempDiretor); }
                else{ f.setDiretor(DiretorTextBox.getText()); }
                if (GeneroTextBox.getText().equals(tempGenero)) { f.setGenero(tempGenero); }
                else { f.setGenero(GeneroTextBox.getText()); }
                if (Integer.parseInt(DisponiveisTextBox.getText()) == tempDisponiveis) { f.setDisponiveis(tempDisponiveis); }
                else { try{ f.setDisponiveis(Integer.parseInt(DisponiveisTextBox.getText()));}
                catch(NumberFormatException e) {JOptionPane.showMessageDialog(this, "O Ano deve ser um número!", "Erro de tipo!", 1);;} }
                if (SinopseTextArea.getText().equals(tempSinopse)) { f.setSinopse(tempSinopse); }
                else { f.setSinopse(SinopseTextArea.getText()); }
            Conect_Filme fConect = new Conect_Filme();
            fConect.alterar(f);
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!", "Aviso", 1);
            atualizarListaFilmes();
        } catch(Exception e) {
            System.out.println(e);
        }
        
        } else {
            try {
            /*VERIFICA A ID SELECIONADA E CASO A ID ESTEJA PRESENTE,OS DADOS EM TAL ID SÃO DELETADOS*/
            Filme f = new Filme();
            f.setId(parseInt(IdTextBox.getText()));
            Conect_Filme fConect = new Conect_Filme();
            fConect.deletar(f);
            JOptionPane.showMessageDialog(this, "Deletado com sucesso!", "Aviso", 1);
            atualizarListaFilmes();
        } catch(Exception e) {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_ConfirmarBotaoActionPerformed

    private void CriarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarRadioButtonActionPerformed
        IdTextBox.setText(null);
        NomeTextBox.setEnabled(true);
        NomeTextBox.setText(null);
        FaixaEtariaTextBox.setEnabled(true);
        FaixaEtariaTextBox.setText(null);
        LancamentoTextBox.setEnabled(true);
        LancamentoTextBox.setText(null);
        SinopseTextArea.setEnabled(true);
        SinopseTextArea.setText(null);
        GeneroTextBox.setEnabled(true);
        GeneroTextBox.setText(null);
        DiretorTextBox.setEnabled(true);
        DiretorTextBox.setText(null);
        DisponiveisTextBox.setEnabled(true);
        DisponiveisTextBox.setText(null);
    }//GEN-LAST:event_CriarRadioButtonActionPerformed

    private void AlterarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarRadioButtonActionPerformed
        NomeTextBox.setEnabled(true);
        FaixaEtariaTextBox.setEnabled(true);
        LancamentoTextBox.setEnabled(true);
        SinopseTextArea.setEnabled(true);
        GeneroTextBox.setEnabled(true);
        DiretorTextBox.setEnabled(true);
        DisponiveisTextBox.setEnabled(true);
    }//GEN-LAST:event_AlterarRadioButtonActionPerformed

    private void DeletarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarRadioButtonActionPerformed
        IdTextBox.setEnabled(false);
        NomeTextBox.setEnabled(false);
        FaixaEtariaTextBox.setEnabled(false);
        LancamentoTextBox.setEnabled(false);
        SinopseTextArea.setEnabled(false);
        GeneroTextBox.setEnabled(false);
        DiretorTextBox.setEnabled(false);
        DisponiveisTextBox.setEnabled(false);
    }//GEN-LAST:event_DeletarRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AlterarRadioButton;
    private javax.swing.JButton ConfirmarBotao;
    private javax.swing.JRadioButton CriarRadioButton;
    private javax.swing.JRadioButton DeletarRadioButton;
    private javax.swing.JTextField DiretorTextBox;
    private javax.swing.JTextField DisponiveisTextBox;
    private javax.swing.JTextField FaixaEtariaTextBox;
    private javax.swing.JTextField GeneroTextBox;
    private javax.swing.JTextField IdTextBox;
    private javax.swing.JTextField LancamentoTextBox;
    private javax.swing.JTextField NomeTextBox;
    private javax.swing.JTextArea SinopseTextArea;
    private javax.swing.JLabel SinopseTextBox;
    private javax.swing.JTable TabelaFilmes;
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
