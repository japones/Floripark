package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;
import java.util.Date;

public interface IBancoService {

    public Boolean inserirBanco(Integer id, String nome, Usuario usuarioLogado) throws Exception;

    public void excluirBanco(Integer id) throws Exception;

    public Boolean alterarBanco(Integer id, String nome, Usuario usuarioLogado, Date dataInclusao, Usuario usuarioInclusao) throws Exception;

    public Banco pesquisarBanco(Integer id) throws Exception;

    public ArrayList<Banco> pesquisarBanco() throws Exception;

    public ArrayList<Banco> pesquisarBanco(String nome) throws Exception;
}
