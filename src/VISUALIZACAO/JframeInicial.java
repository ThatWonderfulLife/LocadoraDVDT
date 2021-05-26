package VISUALIZACAO;
import CONEXAO.Conect_Pessoa;
import CONEXAO.Conect_Filme;
import ENTIDADES.Pessoa;
import ENTIDADES.Filme;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JframeInicial extends javax.swing.JFrame {
    public String getUserLogado() { return userLogado; }

    public void setUserLogado(String userLogado) { this.userLogado = userLogado; }

    private String userLogado = null;

    public JframeInicial(String usuario) {
        initComponents();
        this.userLogado = usuario;
        listarTabelaClientes();
        listarTabelaFilmes();
        if (!"root".equals(this.userLogado)) {
            UsuarioBotao.setEnabled(false);
        }
    }
  
    public final void listarTabelaClientes() {
        DefaultTableModel valor = (DefaultTableModel) ClienteTabela.getModel();
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
                cliente.get(i).getCpfPessoa()});  i++; } }
    public final void listarTabelaFilmes() {
        DefaultTableModel valor = (DefaultTableModel) FilmeTabela.getModel();
        valor.getDataVector().removeAllElements();
        Conect_Filme cFilme = new Conect_Filme();
        List<Filme> filme = cFilme.listarTodos();
        int i = 0;
        while (filme.size() > i) {
        valor.addRow(new Object[]{String.valueOf(
            filme.get(i).getId()),
            filme.get(i).getNome(),
            filme.get(i).getFaixa(),
            filme.get(i).getAnoLancamento(),
            filme.get(i).getDiretor(),
            filme.get(i).getGenero(),
            filme.get(i).getDisponiveis(),
            filme.get(i).getSinopse()});  i++; } }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClienteBotao = new javax.swing.JButton();
        FilmeBotao = new javax.swing.JButton();
        UsuarioBotao = new javax.swing.JButton();
        AlugarBotao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FilmeTabela = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClienteTabela = new javax.swing.JTable();
        SairBotao = new javax.swing.JButton();
        HistoricoBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ClienteBotao.setText("Cliente");
        ClienteBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteBotaoActionPerformed(evt);
            }
        });

        FilmeBotao.setText("Filme");
        FilmeBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilmeBotaoActionPerformed(evt);
            }
        });

        UsuarioBotao.setText("Usuario");
        UsuarioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioBotaoActionPerformed(evt);
            }
        });

        AlugarBotao.setText("Alugar");
        AlugarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlugarBotaoActionPerformed(evt);
            }
        });

        FilmeTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Faixa", "Lançamento", "Diretor", "Genero", "Disponíveis", "Sinopse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FilmeTabela);

        ClienteTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "E-mail", "Endereço", "Nascimento", "Sexo", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ClienteTabela);

        SairBotao.setText("Sair");
        SairBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairBotaoActionPerformed(evt);
            }
        });

        HistoricoBotao.setText("Ver Histórico");
        HistoricoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoricoBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ClienteBotao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilmeBotao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioBotao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AlugarBotao))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(SairBotao)
                            .addGap(216, 216, 216)
                            .addComponent(HistoricoBotao)
                            .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClienteBotao)
                    .addComponent(FilmeBotao)
                    .addComponent(AlugarBotao)
                    .addComponent(UsuarioBotao))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(SairBotao)
                .addComponent(HistoricoBotao))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClienteBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteBotaoActionPerformed
        this.dispose();
        JframeEditarCliente telaCliente = new JframeEditarCliente(this.getUserLogado());
        telaCliente.setVisible(true);
        telaCliente.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaCliente.setLocationRelativeTo(null);    
    }//GEN-LAST:event_ClienteBotaoActionPerformed
    private void HistoricoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteBotaoActionPerformed
        this.dispose();
        JframeHistorico telaHistorico = new JframeHistorico(this.getUserLogado());
        telaHistorico.setVisible(true);
        telaHistorico.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaHistorico.setLocationRelativeTo(null);}

    private void FilmeBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilmeBotaoActionPerformed
        this.dispose();
        JframeEditarFilme telaFilme = new JframeEditarFilme(this.getUserLogado());
        telaFilme.setVisible(true);
        telaFilme.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaFilme.setLocationRelativeTo(null);
    }//GEN-LAST:event_FilmeBotaoActionPerformed

    private void UsuarioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioBotaoActionPerformed
        this.dispose();
        JframeEditarUsuario telaUsuario = new JframeEditarUsuario(this.getUserLogado());
        telaUsuario.setVisible(true);
        telaUsuario.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaUsuario.setLocationRelativeTo(null);
    }//GEN-LAST:event_UsuarioBotaoActionPerformed

    private void AlugarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlugarBotaoActionPerformed
        this.dispose();
        JframeAlugar telaAlugar = new JframeAlugar(this.getUserLogado());
        telaAlugar.setVisible(true);
        telaAlugar.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
        telaAlugar.setLocationRelativeTo(null);
    }//GEN-LAST:event_AlugarBotaoActionPerformed

    private void SairBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairBotaoActionPerformed
        int retornar = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?","Confirme se deseja sair:",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (retornar == JOptionPane.YES_OPTION) {
            this.dispose();
            JframeLogin telaLogin = new JframeLogin();
            telaLogin.setVisible(true);
            telaLogin.setDefaultCloseOperation(JframeEditarCliente.EXIT_ON_CLOSE);
            telaLogin.setLocationRelativeTo(null);
        } else if (retornar ==JOptionPane.NO_OPTION) {
            //vai fazer nda 
        }
    }//GEN-LAST:event_SairBotaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlugarBotao;
    private javax.swing.JButton ClienteBotao;
    private javax.swing.JTable ClienteTabela;
    private javax.swing.JButton FilmeBotao;
    private javax.swing.JTable FilmeTabela;
    private javax.swing.JButton SairBotao;
    private javax.swing.JButton UsuarioBotao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton HistoricoBotao;
    // End of variables declaration//GEN-END:variables
}
