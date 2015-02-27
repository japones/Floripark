package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class BancoTableModel extends AbstractTableModel {

    private List<Banco> bancos;
    private String[] cabecalhoColunas = {"Código", "Nome"};
    
    public BancoTableModel() {
        try {
            bancos = ServiceFactory.getBancoService().pesquisarBanco();
        } catch (Exception ex) {
            Logger.getLogger(BancoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BancoTableModel(String nome) {
        try {
            bancos = ServiceFactory.getBancoService().pesquisarBanco(nome);
        } catch (Exception ex) {
            Logger.getLogger(BancoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return bancos.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        switch (numColuna) {
            case 0:
                return bancos.get(numLinha).getId();
            case 1:
                return bancos.get(numLinha).getNome();
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<Banco> getBanco() {
        return bancos;
    }

}
