package br.com.floripark.financeiro.view;

import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.view.cadastro.CadastroBanco;
import br.com.floripark.financeiro.view.cadastro.CadastroDataMovimento;
import br.com.floripark.financeiro.view.cadastro.CadastroEmpresa;
import br.com.floripark.financeiro.view.cadastro.CadastroGrupoCpa;
import br.com.floripark.financeiro.view.cadastro.CadastroServico;
import br.com.floripark.financeiro.view.cadastro.CadastroTipoLancamento;
import br.com.floripark.financeiro.view.cadastro.CadastroUsuario;
import br.com.floripark.financeiro.view.retorno.IncluirRetornoBancario;
import br.com.floripark.financeiro.view.consulta.ConsultaBanco;
import br.com.floripark.financeiro.view.retorno.ConsultaRetorno;
import br.com.floripark.financeiro.view.consulta.ConsultaEmpresa;
import br.com.floripark.financeiro.view.consulta.ConsultaGrupoCpa;
import br.com.floripark.financeiro.view.consulta.ConsultaServico;
import br.com.floripark.financeiro.view.consulta.ConsultaTipoLancamento;
import br.com.floripark.financeiro.view.consulta.ConsultaUsuario;

public class Principal extends javax.swing.JFrame {

    private Usuario ul;

    public Principal() {
        initComponents();
    }

    public Principal(Usuario usuarioLogado) {
        initComponents();
        ul = usuarioLogado;
        lblUsuario.setText(ul.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnCadastro = new javax.swing.JMenu();
        mnCadBanco = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnCadEMpresa = new javax.swing.JMenuItem();
        mnCadGrupoCpa = new javax.swing.JMenuItem();
        mnCadServico = new javax.swing.JMenuItem();
        mnCadTipoLancamento = new javax.swing.JMenuItem();
        mnCadUsuario = new javax.swing.JMenuItem();
        mnConsulta = new javax.swing.JMenu();
        mnConBanco = new javax.swing.JMenuItem();
        mnDataMovimento = new javax.swing.JMenuItem();
        mnConEmpresa = new javax.swing.JMenuItem();
        mnConGrupoCpa = new javax.swing.JMenuItem();
        mnConServico = new javax.swing.JMenuItem();
        mnConTipoLancamento = new javax.swing.JMenuItem();
        mnConUsuario = new javax.swing.JMenuItem();
        mnRetorno = new javax.swing.JMenu();
        mnImportar = new javax.swing.JMenuItem();
        mnComprovante = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grupo Floripark");

        lblUsuario.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblUsuario.setText("sa");

        jMenuBar2.setName(""); // NOI18N

        mnCadastro.setText("Cadastro");

        mnCadBanco.setText("Banco");
        mnCadBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadBancoActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadBanco);

        jMenuItem3.setText("Data Movimento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnCadastro.add(jMenuItem3);

        mnCadEMpresa.setText("Empresa");
        mnCadEMpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadEMpresaActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadEMpresa);

        mnCadGrupoCpa.setText("Grupo Contas a Pagar");
        mnCadGrupoCpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadGrupoCpaActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadGrupoCpa);

        mnCadServico.setText("Serviço");
        mnCadServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadServicoActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadServico);

        mnCadTipoLancamento.setText("Tipo de Lançamento");
        mnCadTipoLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadTipoLancamentoActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadTipoLancamento);

        mnCadUsuario.setText("Usuário");
        mnCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadUsuarioActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadUsuario);

        jMenuBar2.add(mnCadastro);

        mnConsulta.setText("Consulta");

        mnConBanco.setText("Banco");
        mnConBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConBancoActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConBanco);

        mnDataMovimento.setText("Data Movimento");
        mnConsulta.add(mnDataMovimento);

        mnConEmpresa.setText("Empresa");
        mnConEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConEmpresaActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConEmpresa);

        mnConGrupoCpa.setText("Grupo Contas a Pagar");
        mnConGrupoCpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConGrupoCpaActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConGrupoCpa);

        mnConServico.setText("Servico");
        mnConServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConServicoActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConServico);

        mnConTipoLancamento.setText("Tipo de Lançamento");
        mnConTipoLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConTipoLancamentoActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConTipoLancamento);

        mnConUsuario.setText("Usuario");
        mnConUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConUsuarioActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConUsuario);

        jMenuBar2.add(mnConsulta);

        mnRetorno.setText("Retorno");

        mnImportar.setText("Importar");
        mnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnImportarActionPerformed(evt);
            }
        });
        mnRetorno.add(mnImportar);

        mnComprovante.setText("Comprovante");
        mnComprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnComprovanteActionPerformed(evt);
            }
        });
        mnRetorno.add(mnComprovante);

        jMenuBar2.add(mnRetorno);

        mnSair.setText("Sair");
        mnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSairMouseClicked(evt);
            }
        });
        jMenuBar2.add(mnSair);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(lblUsuario)
                .addContainerGap(649, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(lblUsuario)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnCadBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadBancoActionPerformed
        CadastroBanco cb = new CadastroBanco(this, true, ul);
        cb.setLocationRelativeTo(this);
        cb.setVisible(true);
    }//GEN-LAST:event_mnCadBancoActionPerformed

    private void mnConBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConBancoActionPerformed
        ConsultaBanco cob = new ConsultaBanco(ul, this, true);
        cob.setLocationRelativeTo(this);
        cob.setVisible(true);
    }//GEN-LAST:event_mnConBancoActionPerformed

    private void mnConEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConEmpresaActionPerformed
        ConsultaEmpresa ce = new ConsultaEmpresa(ul, this, true);
        ce.setLocationRelativeTo(this);
        ce.setVisible(true);
    }//GEN-LAST:event_mnConEmpresaActionPerformed

    private void mnCadEMpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadEMpresaActionPerformed
        CadastroEmpresa cadEmpresa = new CadastroEmpresa(this, true, ul);
        cadEmpresa.setLocationRelativeTo(this);
        cadEmpresa.setVisible(true);
    }//GEN-LAST:event_mnCadEMpresaActionPerformed

    private void mnCadTipoLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadTipoLancamentoActionPerformed
        CadastroTipoLancamento cadTipoLancamento = new CadastroTipoLancamento(ul, this, true);
        cadTipoLancamento.setLocationRelativeTo(this);
        cadTipoLancamento.setVisible(true);
    }//GEN-LAST:event_mnCadTipoLancamentoActionPerformed

    private void mnConTipoLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConTipoLancamentoActionPerformed
        ConsultaTipoLancamento ctl = new ConsultaTipoLancamento(ul, this, true);
        ctl.setLocationRelativeTo(this);
        ctl.setVisible(true);
    }//GEN-LAST:event_mnConTipoLancamentoActionPerformed

    private void mnConGrupoCpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConGrupoCpaActionPerformed
        ConsultaGrupoCpa cgc = new ConsultaGrupoCpa(ul, this, true);
        cgc.setLocationRelativeTo(this);
        cgc.setVisible(true);
    }//GEN-LAST:event_mnConGrupoCpaActionPerformed

    private void mnCadGrupoCpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadGrupoCpaActionPerformed
        CadastroGrupoCpa cadastroGrupoCpa = new CadastroGrupoCpa(ul, this, true);
        cadastroGrupoCpa.setLocationRelativeTo(this);
        cadastroGrupoCpa.setVisible(true);
    }//GEN-LAST:event_mnCadGrupoCpaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CadastroDataMovimento cdm = new CadastroDataMovimento(ul, this, true);
        cdm.setLocationRelativeTo(this);
        cdm.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mnComprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnComprovanteActionPerformed
        ConsultaRetorno consultaComprovante = new ConsultaRetorno(this, true, ul);
        consultaComprovante.setLocationRelativeTo(this);
        consultaComprovante.setVisible(true);
    }//GEN-LAST:event_mnComprovanteActionPerformed

    private void mnCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadUsuarioActionPerformed
        CadastroUsuario cadastroUsuario = new CadastroUsuario(this, true, ul);
        cadastroUsuario.setLocationRelativeTo(this);
        cadastroUsuario.setVisible(true);
    }//GEN-LAST:event_mnCadUsuarioActionPerformed

    private void mnCadServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadServicoActionPerformed
        CadastroServico cadastroServico = new CadastroServico(this, true, ul);
        cadastroServico.setLocationRelativeTo(this);
        cadastroServico.setVisible(true);
    }//GEN-LAST:event_mnCadServicoActionPerformed

    private void mnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnImportarActionPerformed
        IncluirRetornoBancario retorno = new IncluirRetornoBancario(this, true, ul);
        retorno.setLocationRelativeTo(this);
        retorno.setVisible(true);
    }//GEN-LAST:event_mnImportarActionPerformed

    private void mnConUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConUsuarioActionPerformed
        ConsultaUsuario consultaUsuario = new ConsultaUsuario(ul, this, true);
        consultaUsuario.setLocationRelativeTo(this);
        consultaUsuario.setVisible(true);
    }//GEN-LAST:event_mnConUsuarioActionPerformed

    private void mnConServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConServicoActionPerformed
        ConsultaServico consultaServico = new ConsultaServico(ul, this, true);
        consultaServico.setLocationRelativeTo(this);
        consultaServico.setVisible(true);
    }//GEN-LAST:event_mnConServicoActionPerformed

    private void mnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnSairMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnCadBanco;
    private javax.swing.JMenuItem mnCadEMpresa;
    private javax.swing.JMenuItem mnCadGrupoCpa;
    private javax.swing.JMenuItem mnCadServico;
    private javax.swing.JMenuItem mnCadTipoLancamento;
    private javax.swing.JMenuItem mnCadUsuario;
    private javax.swing.JMenu mnCadastro;
    private javax.swing.JMenuItem mnComprovante;
    private javax.swing.JMenuItem mnConBanco;
    private javax.swing.JMenuItem mnConEmpresa;
    private javax.swing.JMenuItem mnConGrupoCpa;
    private javax.swing.JMenuItem mnConServico;
    private javax.swing.JMenuItem mnConTipoLancamento;
    private javax.swing.JMenuItem mnConUsuario;
    private javax.swing.JMenu mnConsulta;
    private javax.swing.JMenuItem mnDataMovimento;
    private javax.swing.JMenuItem mnImportar;
    private javax.swing.JMenu mnRetorno;
    private javax.swing.JMenu mnSair;
    // End of variables declaration//GEN-END:variables
}
