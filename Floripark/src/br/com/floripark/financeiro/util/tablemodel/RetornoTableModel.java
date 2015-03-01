package br.com.floripark.financeiro.util.tablemodel;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.service.ServiceFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class RetornoTableModel extends AbstractTableModel {

    private List<RetornoBancario> retornos;
    private String[] cabecalhoColunas = {"Empresa", "Banco", "Servico", "Data Pagamento"};

    public RetornoTableModel() {
        try {
            retornos = ServiceFactory.getRetornoBancarioService().pesquisarRetorno();
        } catch (Exception ex) {
            Logger.getLogger(RetornoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return retornos.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalhoColunas.length;
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        switch (numColuna) {
            case 0:
                return retornos.get(numLinha).getEmpresa().getNome();
            case 1:
                return retornos.get(numLinha).getBanco().getNome();
            case 2:
                return retornos.get(numLinha).getServico().getDescricao();
            case 3:
                return retornos.get(numLinha).getDatapagamento().toString();
        }
        return null;
    }

    @Override
    public String getColumnName(int numColuna) {
        return cabecalhoColunas[numColuna];
    }

    public List<RetornoBancario> getRetornoBancario() {
        return retornos;
    }
}
