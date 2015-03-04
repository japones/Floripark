package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.combobox.BancoComboModel;
import br.com.floripark.financeiro.util.combobox.EmpresaComboModel;
import br.com.floripark.financeiro.util.combobox.ServicoComboModel;
import br.com.floripark.financeiro.util.tablemodel.RetornoTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class ConsultaRetorno extends javax.swing.JDialog {
    
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    private int coluna0 = 60;
    private int coluna1 = 40;
    private int coluna2 = 40;
    private int coluna3 = 40;
    private Usuario usuarioLogado;

    public ConsultaRetorno(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        usuarioLogado = usuario;
        // Lógica para manipular uma linha do JTable quando esta é selecionada    
        ListSelectionModel linhaModeloSelecao = jtRetorno.getSelectionModel();
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
                if (jtRetorno.getSelectedRow() >= 0) {
                    Integer linhaSelecionada = jtRetorno.getSelectedRow();
                    RetornoBancario retornoBancario = ((RetornoTableModel) jtRetorno.getModel()).getRetornoBancario().get(linhaSelecionada);
                    Empresa empresa = ((RetornoTableModel) jtRetorno.getModel()).getRetornoBancario().get(linhaSelecionada).getEmpresa();
                    if (retornoBancario != null) {
                        ConsultaDado consultaDado = new ConsultaDado(null, true, usuarioLogado, retornoBancario, empresa);
                        consultaDado.setLocationRelativeTo(cbBanco);
                        consultaDado.setVisible(true);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbEmpresa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbBanco = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRetorno = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        cbServico = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ftfDataInicio = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        ftfDataFim = new javax.swing.JFormattedTextField();
        btPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        cbEmpresa.setModel(new EmpresaComboModel());

        jLabel1.setText("Empresa:");

        jLabel2.setText("Banco:");

        cbBanco.setModel(new BancoComboModel());

        jtRetorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtRetorno);

        btnNovo.setText("Novo");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        cbServico.setModel(new ServicoComboModel());

        jLabel4.setText("Serviço:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Pagamento"));

        jLabel3.setText("Início:");

        ftfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftfDataInicio.setToolTipText("");

        jLabel5.setText("Fim:");

        ftfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ftfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbServico, 0, 300, Short.MAX_VALUE)
                                    .addComponent(cbEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbBanco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(btPesquisar)
                        .addGap(66, 66, 66))
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
                    .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnNovo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        Banco banco = (Banco) cbBanco.getSelectedItem();
        Servico servico = (Servico) cbServico.getSelectedItem();
        Empresa empresa = (Empresa) cbEmpresa.getSelectedItem();

        String dataInicial = "";
        String dataFim = "";
        
        dataInicial = ftfDataInicio.getText();
        dataFim = ftfDataFim.getText();
        
        jtRetorno.setModel(new RetornoTableModel());
        jtRetorno.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtRetorno.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtRetorno.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtRetorno.getColumnModel().getColumn(1).setCellRenderer(esquerda);
        jtRetorno.getColumnModel().getColumn(2).setPreferredWidth(coluna2);
        jtRetorno.getColumnModel().getColumn(2).setCellRenderer(esquerda);
        jtRetorno.getColumnModel().getColumn(3).setPreferredWidth(coluna3);
        jtRetorno.getColumnModel().getColumn(3).setCellRenderer(esquerda);
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        jtRetorno.updateUI();
        jtRetorno.setModel(new RetornoTableModel());
        jtRetorno.getColumnModel().getColumn(0).setPreferredWidth(coluna0);
        jtRetorno.getColumnModel().getColumn(0).setCellRenderer(direita);
        jtRetorno.getColumnModel().getColumn(1).setPreferredWidth(coluna1);
        jtRetorno.getColumnModel().getColumn(1).setCellRenderer(esquerda);
        jtRetorno.getColumnModel().getColumn(2).setPreferredWidth(coluna2);
        jtRetorno.getColumnModel().getColumn(2).setCellRenderer(esquerda);
        jtRetorno.getColumnModel().getColumn(3).setPreferredWidth(coluna3);
        jtRetorno.getColumnModel().getColumn(3).setCellRenderer(esquerda);
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbBanco;
    private javax.swing.JComboBox cbEmpresa;
    private javax.swing.JComboBox cbServico;
    private javax.swing.JFormattedTextField ftfDataFim;
    private javax.swing.JFormattedTextField ftfDataInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtRetorno;
    // End of variables declaration//GEN-END:variables
}