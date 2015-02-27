package br.com.floripark.financeiro.util.combobox;

import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.service.ServiceFactory;
import br.com.floripark.financeiro.util.tablemodel.EmpresaTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class EmpresaComboModel extends AbstractListModel implements ComboBoxModel {

    private List<Empresa> empresas;
    private Object selectedItem;

    public EmpresaComboModel() {
        try {
            empresas = ServiceFactory.getEmpresaService().pesquisarEmpresa();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EmpresaComboModel(List<Empresa> bancos) {
        this();
        this.empresas.addAll(bancos);
    }

    @Override
    public int getSize() {
        return empresas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return empresas.get(index);
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

    public void changeList(List<Empresa> newList) {
        this.empresas = newList;
        fireContentsChanged(this, 0, 0);
    }
}
