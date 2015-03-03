package br.com.floripark.financeiro.view.consulta;

import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;

public class DemonstrativoComprovante extends javax.swing.JDialog {
    
    private Usuario ul;
    private String comprovante;
    private String texto;

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
                dado1 = dado11.getLinha().substring(182, 203) + "\n";
                dado2 = dado11.getLinha().substring(91, 93) + "/" + dado11.getLinha().substring(93, 95) + "/" + dado11.getLinha().substring(95, 99) + "\n";
                dado3 = dado11.getLinha().substring(144, 146) + "/" + dado11.getLinha().substring(146, 148) + "/" + dado11.getLinha().substring(148, 152) + "\n";
                dado4 = " " + "\n";
                dado5 = "0,00" + "\n";
                dado6 = dado11.getLinha().substring(17, 61) + "\n";
                dado7 = dado11.getLinha().substring(152, 167) + "\n";
                dado8 = "0,00" + "\n";
                dado9 = dado11.getLinha().substring(61, 91) + "\n";
            }
            if ("Z".equals(dado11.getLinha().substring(13, 14))) {
                dado10 = dado11.getLinha().substring(78,103) + "\n";
            }
        }
        
        String linha1 = "Documento empresa:\n";
        String linha2 = "Data vencimento:\n";
        String linha3 = "Data pagamento:\n";
        String linha4 = "Documento banco:\n";
        String linha5 = "Desconto:\n";
        String linha6 = "Linha digitável:\n";
        String linha7 = "Valor título:\n";
        String linha8 = "Acréscimo:\n";
        String linha9 = "Nome do cedente:\n";
        String linha10 = "Autenticação:\n";
        
        comprovante = linha1;
        comprovante = comprovante + linha2;
        comprovante = comprovante + linha3;
        comprovante = comprovante + linha4;
        comprovante = comprovante + linha5;
        comprovante = comprovante + linha6;
        comprovante = comprovante + linha7;
        comprovante = comprovante + linha8;
        comprovante = comprovante + linha9;
        comprovante = comprovante + linha10;

        texto = dado1;
        texto = texto + dado2;
        texto = texto + dado3;
        texto = texto + dado4;
        texto = texto + dado5;
        texto = texto + dado6;
        texto = texto + dado7;
        texto = texto + dado8;
        texto = texto + dado9;
        texto = texto + dado10;
        
        
        
        
        taFixo.setColumns(2);
        taFixo.setText(comprovante);
        taFixo.insert(texto,50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taFixo = new javax.swing.JTextArea();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        taFixo.setEditable(false);
        taFixo.setColumns(2);
        taFixo.setRows(5);
        jScrollPane1.setViewportView(taFixo);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(647, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taFixo;
    // End of variables declaration//GEN-END:variables
}
