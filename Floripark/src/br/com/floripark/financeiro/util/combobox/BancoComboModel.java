package br.com.floripark.financeiro.util.combobox;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.service.ServiceFactory;
import br.com.floripark.financeiro.util.tablemodel.BancoTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class BancoComboModel extends AbstractListModel implements ComboBoxModel {

    private List<Banco> bancos;
    private Object selectedItem;

    public BancoComboModel() {
        try {
            bancos = ServiceFactory.getBancoService().pesquisarBanco();
        } catch (Exception ex) {
            Logger.getLogger(BancoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BancoComboModel(List<Banco> bancos) {
        this();
        this.bancos.addAll(bancos);
    }

    @Override
    public int getSize() {
        return bancos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return bancos.get(index);
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

    public void changeList(List<Banco> newList) {
        this.bancos = newList;
        fireContentsChanged(this, 0, 0);
    }
}
