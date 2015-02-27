package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.ITipoLancamentoService;
import java.util.ArrayList;
import java.util.Date;

public class TipoLancamentoService implements ITipoLancamentoService{
    private TipoLancamento tipoLancamento;
    private Date dataInclusao;
    private Date dataAlteracao;

    @Override
    public void inserirTipoLancamento(String nome, Usuario usuario) throws Exception {
        dataInclusao = new Date();
        tipoLancamento = new TipoLancamento();
        tipoLancamento.setNome(nome);
        tipoLancamento.setDatainclusao(dataInclusao);
        tipoLancamento.setUsuarioinclusao(usuario);
        DaoFactory.getTipoLancamentoDao().inserirTipoLancamento(tipoLancamento);
    }

    @Override
    public void excluirTipoLancamento(Integer id) throws Exception {
        DaoFactory.getTipoLancamentoDao().excluirTipoLancamento(pesquisarTipoLancamento(id));
    }

    @Override
    public void alterarTipoLancamento(Integer id, String nome, Usuario usuario) throws Exception {
        dataAlteracao = new Date();
        tipoLancamento = new TipoLancamento();
        tipoLancamento.setId(id);
        tipoLancamento.setNome(nome);
        tipoLancamento.setDataalteracao(dataAlteracao);
        tipoLancamento.setUsuarioalteracao(usuario);
        DaoFactory.getTipoLancamentoDao().alterarTipoLancamento(tipoLancamento);
    }

    @Override
    public TipoLancamento pesquisarTipoLancamento(Integer id) throws Exception {
        return DaoFactory.getTipoLancamentoDao().pesquisarTipoLancamento(id);
    }

    @Override
    public ArrayList<TipoLancamento> pesquisarTipoLancamento(String nome) throws Exception {
        return DaoFactory.getTipoLancamentoDao().pesquisarTipoLancamento(nome);
    }

    @Override
    public ArrayList<TipoLancamento> pesquisarTipoLancamento() throws Exception {
        return DaoFactory.getTipoLancamentoDao().pesquisarTipoLancamento();
    }
    
}
