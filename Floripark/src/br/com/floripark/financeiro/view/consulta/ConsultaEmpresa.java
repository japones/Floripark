package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.tablemodel.EmpresaTableModel;
import br.com.floripark.financeiro.view.cadastro.CadastroEmpresa;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaEmpresa extends javax.swing.JDialog {

    private Usuario ul;
    private int coluna0 = 60;
    private int coluna1 = 400;

    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

    public ConsultaEmpresa(Usuario usuarioLogado, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ul = usuarioLogado;
        // Lógica para manipular uma linha do JTable quando esta é selecionada    
        ListSelectionModel linhaModeloSelecao = jtEmpresa.getSelectionModel();
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
                if (jtEmpresa.getSelectedRow() >= 0) {
                    Integer linhaSelecionada = jtEmpresa.getSelectedRow();
                    Empresa empresaSelecionada = ((EmpresaTableModel) jtEmpresa.getModel()).getBanco().get(linhaSelecionada);
                    if (empresaSelecionada != null) {
                        CadastroEmpresa cadastroEmpresa = new CadastroEmpresa(null, true, ul, empresaSelecionada);
                        cadastroEmpresa.setLocationRelativeTo(jScrollPane1.getParent());
                        cadastroEmpresa.setVisible(true);
                        jtEmpresa.setModel(new EmpresaTableModel());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpresa = new javax.swing.JTable();
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

        jtEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtEmpresa);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpresa)
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
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
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
        String nome = txtEmpresa.getText();
        jtEmpresa.setModel(new EmpresaTableModel(nome));
        jtEmpresa.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtEmpresa.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtEmpresa.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtEmpresa.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroEmpresa ce = new CadastroEmpresa(null, true, ul);
        ce.setLocationRelativeTo(this);
        ce.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        jtEmpresa.updateUI();
        jtEmpresa.getRowHeight(0);
        jtEmpresa.setModel(new EmpresaTableModel());
        jtEmpresa.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtEmpresa.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtEmpresa.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtEmpresa.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtEmpresa;
    private javax.swing.JTextField txtEmpresa;
    // End of variables declaration//GEN-END:variables
}
