package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.tablemodel.EmpresaTableModel;
import br.com.floripark.financeiro.util.tablemodel.TipoLancamentoTableModel;
import br.com.floripark.financeiro.view.cadastro.CadastroTipoLancamento;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaTipoLancamento extends javax.swing.JDialog {
    
    private Usuario ul;
    private int coluna0 = 60;
    private int coluna1 = 400;
    
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

    public ConsultaTipoLancamento(Usuario usuarioLogado, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ul = usuarioLogado;
        // Lógica para manipular uma linha do JTable quando esta é selecionada    
        ListSelectionModel linhaModeloSelecao = jtTipoLancamento.getSelectionModel();
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
                if (jtTipoLancamento.getSelectedRow() >= 0) {
                    Integer linhaSelecionada = jtTipoLancamento.getSelectedRow();
                    TipoLancamento tlSelecionado = ((TipoLancamentoTableModel) jtTipoLancamento.getModel()).getTipoLancamento().get(linhaSelecionada);
                    if (tlSelecionado != null) {
                        CadastroTipoLancamento cadastroTipoLancamento = new CadastroTipoLancamento(tlSelecionado, null, true);
                        cadastroTipoLancamento.setLocationRelativeTo(jScrollPane1.getParent());
                        cadastroTipoLancamento.setVisible(true);
                        jtTipoLancamento.setModel(new EmpresaTableModel());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTipoLancamento = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTipoLancamento = new javax.swing.JTable();
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

        jtTipoLancamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtTipoLancamento);

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
                        .addComponent(txtTipoLancamento)
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
                    .addComponent(txtTipoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        String nome = txtTipoLancamento.getText();
        jtTipoLancamento.setModel(new TipoLancamentoTableModel(nome));
        jtTipoLancamento.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtTipoLancamento.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtTipoLancamento.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtTipoLancamento.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroTipoLancamento ctl = new CadastroTipoLancamento(ul, null, true);
        ctl.setLocationRelativeTo(this);
        ctl.setVisible(true);        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        direita.setHorizontalAlignment(SwingConstants.RIGHT); 
        esquerda.setHorizontalAlignment(SwingConstants.LEFT); 
        jtTipoLancamento.updateUI();
        jtTipoLancamento.getRowHeight(0);
        jtTipoLancamento.setModel(new TipoLancamentoTableModel());
        jtTipoLancamento.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtTipoLancamento.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtTipoLancamento.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtTipoLancamento.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTipoLancamento;
    private javax.swing.JTextField txtTipoLancamento;
    // End of variables declaration//GEN-END:variables
}
