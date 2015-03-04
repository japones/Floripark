package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.tablemodel.ComprovanteBoletoTableModel;
import java.util.ArrayList;

public class DemonstrativoComprovante extends javax.swing.JDialog {
    
    private Usuario ul;

    public DemonstrativoComprovante(java.awt.Frame parent, boolean modal, Usuario usuario, ArrayList<Dado> dados) {
        super(parent, modal);
        initComponents();
        ul = usuario;
        
        String dado1 = null;
        String dado2 = null;
        String dado3 = null;
        String dado4 = null;
        String dado5 = null;
        String dado6 = null;
        String dado7 = null;
        String dado8 = null;
        String dado9 = null;
        String dado10 = null;
        
        for (Dado dado11 : dados) {
            if ("J".equals(dado11.getLinha().subSequence(13, 14))) {
                dado1 = dado11.getLinha().substring(182, 203);
                dado2 = dado11.getLinha().substring(91, 93) + "/" + dado11.getLinha().substring(93, 95) + "/" + dado11.getLinha().substring(95, 99);
                dado3 = dado11.getLinha().substring(144, 146) + "/" + dado11.getLinha().substring(146, 148) + "/" + dado11.getLinha().substring(148, 152);
                dado4 = " ";
                dado5 = "0,00";
                dado6 = dado11.getLinha().substring(17, 61);
                dado7 = dado11.getLinha().substring(152, 167);
                dado8 = "0,00";
                dado9 = dado11.getLinha().substring(61, 91);
            }
            if ("Z".equals(dado11.getLinha().substring(13, 14))) {
                dado10 = dado11.getLinha().substring(78,103);
            }
        }
        
        String linha1 = "Documento empresa:";
        String linha2 = "Data vencimento:";
        String linha3 = "Data pagamento:";
        String linha4 = "Documento banco:";
        String linha5 = "Desconto:";
        String linha6 = "Linha digitável:";
        String linha7 = "Valor título:";
        String linha8 = "Acréscimo:";
        String linha9 = "Nome do cedente:";
        String linha10 = "Autenticação:";
        
        String [][] comp = new String[2][10];
        comp[0][0] = linha1;
        comp[0][1] = linha2;
        comp[0][2] = linha3;
        comp[0][3] = linha4;
        comp[0][4] = linha5;
        comp[0][5] = linha6;
        comp[0][6] = linha7;
        comp[0][7] = linha8;
        comp[0][8] = linha9;
        comp[0][9] = linha10;
        
        comp[1][0] = dado1;
        comp[1][1] = dado2;
        comp[1][2] = dado3;
        comp[1][3] = dado4;
        comp[1][4] = dado5;
        comp[1][5] = dado6;
        comp[1][6] = dado7;
        comp[1][7] = dado8;
        comp[1][8] = dado9;
        comp[1][9] = dado10;
        
        jtDemonstrativo.updateUI();
        jtDemonstrativo.getRowHeight(0);
        jtDemonstrativo.setModel(new ComprovanteBoletoTableModel(comp));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDemonstrativo = new javax.swing.JTable();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jtDemonstrativo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtDemonstrativo);

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logoemp.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbLogo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtDemonstrativo;
    private javax.swing.JLabel lbLogo;
    // End of variables declaration//GEN-END:variables
}
