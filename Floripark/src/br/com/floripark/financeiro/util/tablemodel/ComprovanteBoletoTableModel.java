package br.com.floripark.financeiro.util.tablemodel;

import javax.swing.table.AbstractTableModel;

public class ComprovanteBoletoTableModel extends AbstractTableModel {

    private String[][] comp;

    public ComprovanteBoletoTableModel(String[][] comprovante) {
        comp = comprovante;
    }

    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return comp.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
            switch (numColuna) {
                case 0:
                    return comp[numColuna][numLinha];
                case 1:
                    return comp[numColuna][numLinha];
            }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return null;
    }
}
