package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ServicoTableModel extends AbstractTableModel {

    private List<Servico> servicos;
    private String[] cabecalhoColunas = {"Descrição", "Sigla"};
    
    public ServicoTableModel() {
        try {
            servicos = ServiceFactory.getServicoService().pesquisarServico();
        } catch (Exception ex) {
            Logger.getLogger(ServicoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServicoTableModel(String nome) {
        try {
            servicos = ServiceFactory.getServicoService().pesquisarServico();
        } catch (Exception ex) {
            Logger.getLogger(ServicoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return servicos.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        switch (numColuna) {
            case 0:
                return servicos.get(numLinha).getDescricao();
            case 1:
                return servicos.get(numLinha).getSigla();
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<Servico> getBanco() {
        return servicos;
    }
}
