package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TipoLancamentoTableModel extends AbstractTableModel {

    private List<TipoLancamento> listas;
    private String[] cabecalhoColunas = {"Código", "Nome"};
    
    public TipoLancamentoTableModel() {
        try {
            listas = ServiceFactory.getTipoLancemntoService().pesquisarTipoLancamento();
        } catch (Exception ex) {
            Logger.getLogger(TipoLancamentoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TipoLancamentoTableModel(String nome) {
        try {
            listas = ServiceFactory.getTipoLancemntoService().pesquisarTipoLancamento(nome);
        } catch (Exception ex) {
            Logger.getLogger(TipoLancamentoTableModel.class.getName()).log(Level.SEVERE, null, ex);
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
                return listas.get(numLinha).getId();
            case 1:
                return listas.get(numLinha).getNome();
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<TipoLancamento> getTipoLancamento() {
        return listas;
    }

}
