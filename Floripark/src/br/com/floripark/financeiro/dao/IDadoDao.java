package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.RetornoBancario;
import java.util.ArrayList;

public interface IDadoDao {

    public void inserirDado(Dado dado) throws Exception;

    public void excluirDado(Dado dado) throws Exception;

    public void alterarDado(Dado dado) throws Exception;

    public Dado pesquisarDado(Integer id) throws Exception;

    public ArrayList<Dado> pesquisarDado(RetornoBancario retorno) throws Exception;
}
