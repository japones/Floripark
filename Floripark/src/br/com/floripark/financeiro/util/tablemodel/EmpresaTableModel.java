package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class EmpresaTableModel extends AbstractTableModel {

    private List<Empresa> lista;
    private String[] cabecalhoColunas = {"Código", "Nome"};

    public EmpresaTableModel() {
        try {
            lista = ServiceFactory.getEmpresaService().pesquisarEmpresa();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EmpresaTableModel(String nome){
        try {
            lista = ServiceFactory.getEmpresaService().pesquisarEmpresas(nome);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        switch (numColuna) {
            case 0:
                return lista.get(numLinha).getId();
            case 1:
                return lista.get(numLinha).getNome();
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<Empresa> getBanco() {
        return lista;
    }

}
