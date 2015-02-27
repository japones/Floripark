package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.TipoLancamento;
import java.util.ArrayList;

public interface ITipoLancamentoDao {

    public void inserirTipoLancamento(TipoLancamento tipoLancamento) throws Exception;

    public void excluirTipoLancamento(TipoLancamento tipoLancamento) throws Exception;

    public void alterarTipoLancamento(TipoLancamento tipoLancamento) throws Exception;

    public TipoLancamento pesquisarTipoLancamento(Integer id) throws Exception;

    public ArrayList<TipoLancamento> pesquisarTipoLancamento(String nome) throws Exception;

    public ArrayList<TipoLancamento> pesquisarTipoLancamento() throws Exception;

}
