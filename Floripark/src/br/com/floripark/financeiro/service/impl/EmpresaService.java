package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IEmpresaService;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class EmpresaService implements IEmpresaService {

    private Empresa empresa;
    private Date dataInclusao;
    private Date dataalteracao;

    @Override
    public Boolean inserirEmpresa(String nome, Usuario usuarioLogado) throws Exception {
        dataInclusao = new Date();
        empresa = new Empresa();
        
        empresa.setNome(nome);
        empresa.setUsuarioinclusao(usuarioLogado);
        empresa.setDatainclusao(dataInclusao);
        
        DaoFactory.getEmpresaDao().inserirEmpresa(empresa);
        JOptionPane.showMessageDialog(null, "Empresa incluído com sucesso!");
        return true;
    }

    @Override
    public void excluirEmpresa(Integer id) throws Exception {
        DaoFactory.getEmpresaDao().excluirEmpresa(pesquisarEmpresa(id));
    }

    @Override
    public Boolean alterarEmpresa(Integer id, String nome, Usuario usuarioLogado, Date dataInclusao, Usuario usuarioInclusao) throws Exception {
        dataalteracao = new Date();
        empresa = new Empresa();
        
        empresa.setId(id);
        empresa.setNome(nome);
        empresa.setUsuarioalteracao(usuarioLogado);
        empresa.setDataalteracao(dataalteracao);
        empresa.setUsuarioinclusao(usuarioInclusao);
        empresa.setDatainclusao(dataInclusao);
        
        DaoFactory.getEmpresaDao().alterarEmpresa(empresa);
        JOptionPane.showMessageDialog(null, "Empresa alterado com sucesso!");
        return true;
    }

    @Override
    public Empresa pesquisarEmpresa(Integer id) throws Exception {
        return DaoFactory.getEmpresaDao().pesquisarEmpresa(id);
    }

    @Override
    public Empresa pesquisarEmpresa(String nome) throws Exception {
        ArrayList<Empresa> empresas = pesquisarEmpresa();
        Empresa ret = null;
        for (Empresa empresa1 : empresas) {
            if (empresa1.getNome().toUpperCase().equals(nome.toUpperCase())) {
                ret = empresa1;
            }
        }
        return ret;
    }

    @Override
    public ArrayList<Empresa> pesquisarEmpresa() throws Exception {
        return DaoFactory.getEmpresaDao().pesquisarEmpresa();
    }

    @Override
    public ArrayList<Empresa> pesquisarEmpresas(String nome) throws Exception {
        return DaoFactory.getEmpresaDao().pesquisarEmpresas(nome);
    }
}
