package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class GrupoCpaTableModel extends AbstractTableModel {

    private List<GrupoCpa> listas;
    private String[] cabecalhoColunas = {"Código", "Nome"};
    
    public GrupoCpaTableModel() {
        try {
            listas = ServiceFactory.getGrupoCpaService().pesquisarGrupoCpa();
        } catch (Exception ex) {
            Logger.getLogger(GrupoCpaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GrupoCpaTableModel(String nome) {
        try {
            listas = ServiceFactory.getGrupoCpaService().pesquisarGrupoCpa(nome);
        } catch (Exception ex) {
            Logger.getLogger(GrupoCpaTableModel.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<GrupoCpa> getGrupoCpa() {
        return listas;
    }

}
