package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.tablemodel.DadoBoletoTableModel;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaDado extends javax.swing.JDialog {
    
    private Usuario ul;
    private RetornoBancario retornoSelecionado;
    private Empresa empresaSelecionada;
    
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

    public ConsultaDado(java.awt.Frame parent, boolean modal, Usuario usuarioLogado, RetornoBancario retorno, Empresa empresa) {
        super(parent, modal);
        initComponents();
        ul = usuarioLogado;
        retornoSelecionado = retorno;
        empresaSelecionada = empresa;
        // Lógica para manipular uma linha do JTable quando esta é selecionada    
        ListSelectionModel linhaModeloSelecao = jtDado.getSelectionModel();
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
                if (jtDado.getSelectedRow() >= 0) {
                    Integer linhaSelecionada = jtDado.getSelectedRow();
                    Dado dadoSelecionado = ((DadoBoletoTableModel) jtDado.getModel()).getRetornoBancario().get(linhaSelecionada);
                    if (dadoSelecionado != null) {
                        ArrayList<Dado> dados = new ArrayList<>();
                        dados.add(dadoSelecionado);
                        dados.add(((DadoBoletoTableModel) jtDado.getModel()).getRetornoBancario().get(linhaSelecionada + 1));
                        DemonstrativoComprovante demonstrativo = new DemonstrativoComprovante(null, true, ul, dados, empresa, retornoSelecionado.getLinha());
                        demonstrativo.setLocationRelativeTo(btSair);
                        demonstrativo.setVisible(true);
                        jtDado.setModel(new DadoBoletoTableModel(retornoSelecionado));
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDado = new javax.swing.JTable();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Floripark");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jtDado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtDado);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        jtDado.updateUI();
        jtDado.getRowHeight(0);
        jtDado.setModel(new DadoBoletoTableModel(retornoSelecionado));
        jtDado.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtDado.getColumnModel().getColumn(1).setCellRenderer(esquerda);
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDado;
    // End of variables declaration//GEN-END:variables
}
