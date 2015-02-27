package br.com.floripark.financeiro.view.cadastro;

import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroServico extends javax.swing.JDialog {

    private Servico servicoSelecionado;
    private Usuario ul;

    public CadastroServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(btnSalvar);
        tfCodigo.setEditable(false);
        tfUsuarioInclusao.setEditable(false);
        tfUsuarioAlteracao.setEditable(false);
        tfDataInclusao.setEditable(false);
        tfDataAlteracao.setEditable(false);
    }

    public CadastroServico(java.awt.Frame parent, boolean modal, Usuario usuarioLogado) {
        this(parent, modal);
        ul = usuarioLogado;
        btnExcluir.setVisible(false);
    }

    public CadastroServico(java.awt.Frame parent, boolean modal, Usuario usuarioLogado, Servico servico) {
        this(parent, modal);
        servicoSelecionado = servico;
        if (servicoSelecionado != null) {
            tfCodigo.setText(servicoSelecionado.getId().toString());
            tfNome.setText(servicoSelecionado.getDescricao());
            tfUsuarioInclusao.setText(servicoSelecionado.getUsuarioinclusao().getNome());
            tfDataInclusao.setText(servicoSelecionado.getDatainclusao().toString());
            // Mostra o botão Excluir     
            btnExcluir.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfSigla = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfUsuarioInclusao = new javax.swing.JTextField();
        tfDataInclusao = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfUsuarioAlteracao = new javax.swing.JTextField();
        tfDataAlteracao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Floripark");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro do Banco"));

        jLabel1.setText("Codigo:");

        tfCodigo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Nome:");

        jLabel7.setText("Sigla:");

        tfSigla=DefinirTiposCaracteresETamanho(1,  " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        tfSigla.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(85, Short.MAX_VALUE))
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Auditoria"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Inclusão"));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setText("Usuário:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setText("Data:");

        tfUsuarioInclusao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        tfDataInclusao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUsuarioInclusao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfDataInclusao, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUsuarioInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Alteração"));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel4.setText("Usuario:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setText("Data:");

        tfUsuarioAlteracao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        tfDataAlteracao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDataAlteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(tfUsuarioAlteracao))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfUsuarioAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (servicoSelecionado != null) {
            Integer id = servicoSelecionado.getId();
            String nome = tfNome.getText();
            Character sigla = tfSigla.getText().charAt(0);
            Date dataInclusao = servicoSelecionado.getDatainclusao();
            Usuario usuarioIncluUsuario = servicoSelecionado.getUsuarioinclusao();
            try {
                Boolean alterar = ServiceFactory.getServicoService().alterarServico(id, nome, sigla, ul, dataInclusao, usuarioIncluUsuario);
                if (alterar == true) {
                    servicoSelecionado = null;
                    dispose();
                }
            } catch (Exception ex) {
                Logger.getLogger(CadastroServico.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String nome = tfNome.getText();
            Character sigla = tfSigla.getText().charAt(0);
            
            try {
                Boolean incluir = ServiceFactory.getServicoService().inserirServico(nome, sigla, ul);
                if (incluir == true) {
                    dispose();
                }
            } catch (Exception ex) {
                Logger.getLogger(CadastroServico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            ServiceFactory.getServicoService().excluirServico(servicoSelecionado.getId());
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(CadastroServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public JTextField DefinirTiposCaracteresETamanho(int tamanho, String caracteres) {
        try {
            //defino a variável que vai guardar a quantidade de caracteres
            String quantidade = "";

            //defino um método de repetição para repetir o numero de
            //vezes  do tamanho
            for (int i = 0; i < tamanho; i++) {
                // defino asterisco para aceitar qualquer coisa e crio a máscara
                quantidade = quantidade + "*";
            }
            //  **********...   de acordo com o tamanho informado
            // defino que a mascara possui essa
            //quantidade de elementos que foi informado em tamanho e
            // foi colocada com * dentro de quantidade
            javax.swing.text.MaskFormatter nome = new javax.swing.text.MaskFormatter(quantidade);

            //defino que o parâmetro caracter recebido pelo
            //método contém os caracteres válidos 
            nome.setValidCharacters(caracteres);

            //retorno a mascara que foi criada  
            return new javax.swing.JFormattedTextField(nome);
        }   // fim do try
        catch (Exception e) {
            //mensagem se acontecer erro
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
            //retorno um campo de texto comum  
            return new JTextField();
        }//fim do catch
    }//fim do método


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDataAlteracao;
    private javax.swing.JTextField tfDataInclusao;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSigla;
    private javax.swing.JTextField tfUsuarioAlteracao;
    private javax.swing.JTextField tfUsuarioInclusao;
    // End of variables declaration//GEN-END:variables
}
