package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.Empresa;
import java.util.ArrayList;

public interface IEmpresaDao {

    public void inserirEmpresa(Empresa empresa) throws Exception;

    public void excluirEmpresa(Empresa empresa) throws Exception;

    public void alterarEmpresa(Empresa empresa) throws Exception;

    public Empresa pesquisarEmpresa(Integer id) throws Exception;

    public ArrayList<Empresa> pesquisarEmpresas(String nome) throws Exception;
    
    public ArrayList<Empresa> pesquisarEmpresa() throws Exception;

}
