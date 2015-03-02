package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class DadoBoletoTableModel extends AbstractTableModel {

    private List<Dado> dados;
    private String[] cabecalhoColunas = {"Cedente", "Data", "Valor"};

    public DadoBoletoTableModel(RetornoBancario retorno) {
        try {
            dados = ServiceFactory.getDadoService().pesquisarDado(retorno);
        } catch (Exception ex) {
            Logger.getLogger(DadoBoletoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        if ("J".equals(dados.get(numLinha).getLinha().substring(13, 14))) {
            switch (numColuna) {
                case 0:
                    return dados.get(numLinha).getLinha().substring(61, 91);
                case 1:
                    return dados.get(numLinha).getLinha().substring(144, 152);
                case 2:
                    return dados.get(numLinha).getLinha().substring(152, 167);
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<Dado> getRetornoBancario() {
        return dados;
    }
}
