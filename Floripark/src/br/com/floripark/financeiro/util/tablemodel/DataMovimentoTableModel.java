package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class DataMovimentoTableModel extends AbstractTableModel {

    private List<DataMovimento> listas;
    private String[] cabecalhoColunas = {"Data Lançamento", "Situação"};
    
    public DataMovimentoTableModel() {
        try {
            listas = ServiceFactory.getDataMovimentoService().pesquisarDataMovimento();
        } catch (Exception ex) {
            Logger.getLogger(DataMovimentoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DataMovimentoTableModel(Date dataLancamento) {
        try {
            listas = ServiceFactory.getDataMovimentoService().pesquisarDataMovimento(dataLancamento);
        } catch (Exception ex) {
            Logger.getLogger(DataMovimentoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return listas.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        switch (numColuna) {
            case 0:
                return listas.get(numLinha).getDataLancamento();
            case 1:
                return listas.get(numLinha).isSituacao();
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<DataMovimento> getDataMovimento() {
        return listas;
    }

}
