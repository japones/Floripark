package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;
import java.util.Date;

public interface IEmpresaService {

    public Boolean inserirEmpresa(String nome, Usuario usuarioLogado) throws Exception;

    public void excluirEmpresa(Integer id) throws Exception;

    public Boolean alterarEmpresa(Integer id, String nome, Usuario usuarioLogado, Date dataInclusao, Usuario usuarioInclusao) throws Exception;

    public Empresa pesquisarEmpresa(Integer id) throws Exception;
    
    public Empresa pesquisarEmpresa(String nome) throws Exception;
    
    public ArrayList<Empresa> pesquisarEmpresas(String nome) throws Exception;

    public ArrayList<Empresa> pesquisarEmpresa() throws Exception;
}
