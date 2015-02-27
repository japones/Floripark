package br.com.floripark.financeiro.util.combobox;

import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.service.ServiceFactory;
import br.com.floripark.financeiro.util.tablemodel.ServicoTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ServicoComboModel extends AbstractListModel implements ComboBoxModel {

    private List<Servico> servicos;
    private Object selectedItem;

    public ServicoComboModel() {
        try {
            servicos = ServiceFactory.getServicoService().pesquisarServico();
        } catch (Exception ex) {
            Logger.getLogger(ServicoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServicoComboModel(List<Servico> bancos) {
        this();
        this.servicos.addAll(bancos);
    }

    @Override
    public int getSize() {
        return servicos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return servicos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public void changeList(List<Servico> newList) {
        this.servicos = newList;
        fireContentsChanged(this, 0, 0);
    }
}
