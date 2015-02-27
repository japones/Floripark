package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.tablemodel.EmpresaTableModel;
import br.com.floripark.financeiro.util.tablemodel.GrupoCpaTableModel;
import br.com.floripark.financeiro.util.tablemodel.TipoLancamentoTableModel;
import br.com.floripark.financeiro.view.cadastro.CadastroGrupoCpa;
import br.com.floripark.financeiro.view.cadastro.CadastroTipoLancamento;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaGrupoCpa extends javax.swing.JDialog {
    
    private Usuario ul;
    private int coluna0 = 60;
    private int coluna1 = 400;
    
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

    public ConsultaGrupoCpa(Usuario usuarioLogado, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ul = usuarioLogado;
        // Lógica para manipular uma linha do JTable quando esta é selecionada    
        ListSelectionModel linhaModeloSelecao = jtGrupoCpa.getSelectionModel();
        linhaModeloSelecao.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Ignora o evento enquanto os valores da linha selecionada
                // estão sendo atualizados
                if (e.getValueIsAdjusting()) {
                    return;
                }
                // Verifica se existe uma linha selecionada. O
                // valor deve ser maior ou igual a 0, que é o número da linha
                if (jtGrupoCpa.getSelectedRow() >= 0) {
                    Integer linhaSelecionada = jtGrupoCpa.getSelectedRow();
                    GrupoCpa gcSelecionado = ((GrupoCpaTableModel) jtGrupoCpa.getModel()).getGrupoCpa().get(linhaSelecionada);
                    if (gcSelecionado != null) {
                        CadastroGrupoCpa cadastroGrupoCpa = new CadastroGrupoCpa(gcSelecionado, null, true);
                        cadastroGrupoCpa.setLocationRelativeTo(jScrollPane1.getParent());
                        cadastroGrupoCpa.setVisible(true);
                        jtGrupoCpa.setModel(new EmpresaTableModel());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtGrupoCpa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtGrupoCpa = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Floripark");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Nome:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtGrupoCpa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtGrupoCpa);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrupoCpa)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGrupoCpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnNovo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        direita.setHorizontalAlignment(SwingConstants.RIGHT); 
        esquerda.setHorizontalAlignment(SwingConstants.LEFT); 
        String nome = txtGrupoCpa.getText();
        jtGrupoCpa.setModel(new GrupoCpaTableModel(nome));
        jtGrupoCpa.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtGrupoCpa.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtGrupoCpa.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtGrupoCpa.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroGrupoCpa ccp = new CadastroGrupoCpa(ul, null, true);
        ccp.setLocationRelativeTo(this);
        ccp.setVisible(true);        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        direita.setHorizontalAlignment(SwingConstants.RIGHT); 
        esquerda.setHorizontalAlignment(SwingConstants.LEFT); 
        jtGrupoCpa.updateUI();
        jtGrupoCpa.getRowHeight(0);
        jtGrupoCpa.setModel(new GrupoCpaTableModel());
        jtGrupoCpa.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtGrupoCpa.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtGrupoCpa.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtGrupoCpa.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtGrupoCpa;
    private javax.swing.JTextField txtGrupoCpa;
    // End of variables declaration//GEN-END:variables
}
