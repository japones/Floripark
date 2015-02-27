package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;

public interface ITipoLancamentoService {
    
    public void inserirTipoLancamento(String nome, Usuario usuario) throws Exception;

    public void excluirTipoLancamento(Integer id) throws Exception;
    
    public void alterarTipoLancamento(Integer id, String nome, Usuario usuario) throws Exception;
    
    public TipoLancamento pesquisarTipoLancamento(Integer id) throws Exception;
    
    public ArrayList<TipoLancamento> pesquisarTipoLancamento(String nome) throws Exception;
    
    public ArrayList<TipoLancamento> pesquisarTipoLancamento() throws Exception;
    
}
