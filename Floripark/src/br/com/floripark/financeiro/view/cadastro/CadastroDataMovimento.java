package br.com.floripark.financeiro.view.cadastro;

import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroDataMovimento extends javax.swing.JDialog {
    
    private DataMovimento dmSelecionado;
    private Usuario ul;
    private Date dd;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public CadastroDataMovimento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(btnSalvar);
        txtCodigo.setEditable(false);
    }
    
    public CadastroDataMovimento(Usuario usuarioLogado, java.awt.Frame parent, boolean modal){
        this(parent, modal);
        ul = usuarioLogado;
        btnExcluir.setVisible(false);
    }
    
    public CadastroDataMovimento(Usuario usuarioLogado){
        ul = usuarioLogado;
        btnExcluir.setVisible(false);
    }
    
    public CadastroDataMovimento(DataMovimento dataMovimento, java.awt.Frame parent, boolean modal){
        this(parent, modal);
        this.dmSelecionado = dataMovimento;
        if (dmSelecionado != null){
            txtCodigo.setText(dataMovimento.getId().toString());
            txtDataLancamento.setText(dataMovimento.getDataLancamento().toString());
            rbSituacao.setContentAreaFilled(dataMovimento.isSituacao());
            // Mostra o botão Excluir     
            btnExcluir.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataLancamento = new javax.swing.JTextField();
        rbSituacao = new javax.swing.JRadioButton();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Floripark");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro do Banco"));

        jLabel1.setText("Codigo:");

        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Data:");

        rbSituacao.setText("Fechado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(rbSituacao)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rbSituacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (dmSelecionado != null) {
            try {
                dd = sdf.parse(txtDataLancamento.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDataMovimento.class.getName()).log(Level.SEVERE, null, ex);
            }
            dmSelecionado.setDataLancamento(dd);
            int codigo = dmSelecionado.getId();
            Date dt = dmSelecionado.getDataLancamento();
            Boolean situacao = dmSelecionado.isSituacao();
            try {
                ServiceFactory.getDataMovimentoService().alterarDataMovimento(codigo, dt, situacao);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");

            } catch (Exception ex) {
                Logger.getLogger(CadastroDataMovimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dd = sdf.parse(txtDataLancamento.getText());
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDataMovimento.class.getName()).log(Level.SEVERE, null, ex);
            }
            Boolean situacao = rbSituacao.isEnabled();
            try {
                ServiceFactory.getDataMovimentoService().inserirDataMovimento(dd, situacao);
                JOptionPane.showMessageDialog(this, "Registro incluído com sucesso!");
            } catch (Exception ex) {
                Logger.getLogger(CadastroDataMovimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dmSelecionado = null;
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int codigo = dmSelecionado.getId();
        try {
            ServiceFactory.getDataMovimentoService().excluirDataMovimento(codigo);
        } catch (Exception ex) {
            Logger.getLogger(CadastroDataMovimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbSituacao;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataLancamento;
    // End of variables declaration//GEN-END:variables
}
