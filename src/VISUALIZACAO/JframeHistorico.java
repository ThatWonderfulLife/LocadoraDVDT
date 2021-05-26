package VISUALIZACAO;
import CONEXAO.Conect_Alugados;
import ENTIDADES.Alugados;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JframeHistorico extends javax.swing.JFrame {

    private String userLogado = null;
    public JframeHistorico(String usuario) {
        initComponents();
        this.userLogado = usuario;
        listarTabelaHistorico();
    }
    public void listarTabelaHistorico() {
        DefaultTableModel valor = (DefaultTableModel) TabelaHistorico.getModel();
        valor.getDataVector().removeAllElements();
        Conect_Alugados aAlugados = new Conect_Alugados();
        List<Alugados> alugados = aAlugados.listarInativos();
        int i = 0;
        while (alugados.size() > i) {
            valor.addRow(new Object[]{String.valueOf(
                    alugados.get(i).getId()),
                    alugados.get(i).getCliente(),
                    alugados.get(i).getFilme(),
                    alugados.get(i).getRetirada(),
                    alugados.get(i).getEntrega(),
                    alugados.get(i).getVendedor()
            });
            i++;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaHistorico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        PesquisaText = new javax.swing.JTextField();
        VoltarButton = new javax.swing.JButton();
        IdLocacaoRadioButton = new javax.swing.JRadioButton();
        FuncionarioRadioButton = new javax.swing.JRadioButton();
        FilmeRadioButton = new javax.swing.JRadioButton();
        ClienteRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        PesquisarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID Locação", "Cliente", "Filme", "Data de Retirada", "Data de Devolução", "Funcionário"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaHistorico);

        jLabel1.setText("Pesquisar Por:");

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(IdLocacaoRadioButton);
        IdLocacaoRadioButton.setText("ID Locação");
        IdLocacaoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdLocacaoRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(FuncionarioRadioButton);
        FuncionarioRadioButton.setText("Funcionário");
        FuncionarioRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionarioRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(FilmeRadioButton);
        FilmeRadioButton.setText("Filme");
        FilmeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilmeRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(ClienteRadioButton);
        ClienteRadioButton.setText("Cliente");
        ClienteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteRadioButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Termo de Pesquisa:");

        PesquisarButton.setText("Pesquisar");
        PesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(VoltarButton)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(IdLocacaoRadioButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ClienteRadioButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(FilmeRadioButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(FuncionarioRadioButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(PesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PesquisarButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(IdLocacaoRadioButton)
                                                        .addComponent(FuncionarioRadioButton)
                                                        .addComponent(FilmeRadioButton)
                                                        .addComponent(ClienteRadioButton))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(PesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(10, 10, 10))
                                        .addComponent(PesquisarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VoltarButton)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void IdLocacaoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdLocacaoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdLocacaoRadioButtonActionPerformed

    private void PesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarButtonActionPerformed
        /*VERIFICA QUAL BOTAO FOI SELECIONADO E SEGUE PARA A EXECUÇÃO DO CÓDIGO DEPENDENDO DE QUAL BOTAO FOI SELECIONADO*/
        if(IdLocacaoRadioButton.isSelected()){
            /*VAI LISTAR TODOS AS LOCAÇÕES DESATIVADAS QUE POSSUEM O ID IGUAL AO VALOR INFORMADO*/
            DefaultTableModel valor = (DefaultTableModel) TabelaHistorico.getModel();
            valor.getDataVector().removeAllElements();
            Conect_Alugados aAlugados = new Conect_Alugados();
            List<Alugados> alugados = aAlugados.listarInativosID(Integer.parseInt(PesquisaText.getText()));
            int i = 0;
            while (alugados.size() > i) {
                valor.addRow(new Object[]{String.valueOf(
                        alugados.get(i).getId()),
                        alugados.get(i).getCliente(),
                        alugados.get(i).getFilme(),
                        alugados.get(i).getRetirada(),
                        alugados.get(i).getEntrega(),
                        alugados.get(i).getVendedor()
                });
                i++;
            }
            /*VAI LISTAR TODOS AS LOCAÇÕES DESATIVADAS QUE POSSUEM O NOME DE CLIENTE IGUAL AO VALOR INFORMADO*/
        }else if (ClienteRadioButton.isSelected()){
            DefaultTableModel valor = (DefaultTableModel) TabelaHistorico.getModel();
            valor.getDataVector().removeAllElements();
            Conect_Alugados aAlugados = new Conect_Alugados();
            List<Alugados> alugados = aAlugados.listarInativosCliente(PesquisaText.getText());
            int i = 0;
            while (alugados.size() > i) {
                valor.addRow(new Object[]{String.valueOf(
                    alugados.get(i).getId()),
                    alugados.get(i).getCliente(),
                    alugados.get(i).getFilme(),
                    alugados.get(i).getRetirada(),
                    alugados.get(i).getEntrega(),
                    alugados.get(i).getVendedor()
                });
                i++;
            }
            /*VAI LISTAR TODOS AS LOCAÇÕES DESATIVADAS QUE POSSUEM O ID DO FILME IGUAL AO VALOR INFORMADO*/
        }else if(FilmeRadioButton.isSelected()){
            DefaultTableModel valor = (DefaultTableModel) TabelaHistorico.getModel();
            valor.getDataVector().removeAllElements();
            Conect_Alugados aAlugados = new Conect_Alugados();
            List<Alugados> alugados = aAlugados.listarInativosFilme(Integer.parseInt(PesquisaText.getText()));
            int i = 0;
            while (alugados.size() > i) {
                valor.addRow(new Object[]{String.valueOf(
                    alugados.get(i).getId()),
                    alugados.get(i).getCliente(),
                    alugados.get(i).getFilme(),
                    alugados.get(i).getRetirada(),
                    alugados.get(i).getEntrega(),
                    alugados.get(i).getVendedor()
                });
                i++;
            }
            /*VAI LISTAR TODOS AS LOCAÇÕES DESATIVADAS QUE POSSUEM O NOME DO VENDEDOR IGUAL AO VALOR INFORMADO*/
        }else if(FuncionarioRadioButton.isSelected()){
            DefaultTableModel valor = (DefaultTableModel) TabelaHistorico.getModel();
            valor.getDataVector().removeAllElements();
            Conect_Alugados aAlugados = new Conect_Alugados();
            List<Alugados> alugados = aAlugados.listarInativosFuncionario(PesquisaText.getText());
            int i = 0;
            while (alugados.size() > i) {
                valor.addRow(new Object[]{String.valueOf(
                    alugados.get(i).getId()),
                    alugados.get(i).getCliente(),
                    alugados.get(i).getFilme(),
                    alugados.get(i).getRetirada(),
                    alugados.get(i).getEntrega(),
                    alugados.get(i).getVendedor()
                });
                i++;
            }
        }
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        this.dispose();
        JframeInicial telaInicial = new JframeInicial(userLogado);
        telaInicial.setVisible(true);
        telaInicial.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaInicial.setLocationRelativeTo(null);
    }//GEN-LAST:event_VoltarButtonActionPerformed

    private void ClienteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteRadioButtonActionPerformed

    private void FilmeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilmeRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilmeRadioButtonActionPerformed

    private void FuncionarioRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncionarioRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FuncionarioRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ClienteRadioButton;
    private javax.swing.JRadioButton FilmeRadioButton;
    private javax.swing.JRadioButton FuncionarioRadioButton;
    private javax.swing.JRadioButton IdLocacaoRadioButton;
    private javax.swing.JTextField PesquisaText;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JTable TabelaHistorico;
    private javax.swing.JButton VoltarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
