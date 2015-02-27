package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.Banco;
import java.util.ArrayList;

public interface IBancoDao {

    public void inserirBanco(Banco banco) throws Exception;

    public void excluirBanco(Banco banco) throws Exception;

    public void alterarBanco(Banco banco) throws Exception;

    public Banco pesquisarBanco(Integer id) throws Exception;

    public ArrayList<Banco> pesquisarBanco(String nome) throws Exception;

    public ArrayList<Banco> pesquisarBanco() throws Exception;

}
