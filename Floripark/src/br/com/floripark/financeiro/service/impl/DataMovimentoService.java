package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.service.IDataMovimentoService;
import java.util.ArrayList;
import java.util.Date;

public class DataMovimentoService implements IDataMovimentoService{
    private DataMovimento dataMovimento;

    @Override
    public void inserirDataMovimento(Date dataLancamento, Boolean situacao) throws Exception {
        dataMovimento = new DataMovimento();
        dataMovimento.setDataLancamento(dataLancamento);
        dataMovimento.setSituacao(situacao);
        DaoFactory.getDataMovimentoDao().inserirDataMovimento(dataMovimento);
    }

    @Override
    public void excluirDataMovimento(Integer id) throws Exception {
        DaoFactory.getDataMovimentoDao().excluirDataMovimento(pesquisarDataMovimento(id));
    }

    @Override
    public void alterarDataMovimento(Integer id, Date dataLancamento, Boolean situacao) throws Exception {
        dataMovimento = new DataMovimento();
        dataMovimento.setId(id);
        dataMovimento.setDataLancamento(dataLancamento);
        dataMovimento.setSituacao(situacao);
        DaoFactory.getDataMovimentoDao().alterarDataMovimento(dataMovimento);
    }

    @Override
    public br.com.floripark.financeiro.model.DataMovimento pesquisarDataMovimento(Integer id) throws Exception {
        return DaoFactory.getDataMovimentoDao().pesquisarDataMovimento(id);
    }

    @Override
    public ArrayList<DataMovimento> pesquisarDataMovimento(Date dataLancamento) throws Exception {
        return DaoFactory.getDataMovimentoDao().pesquisarDataMovimento(dataLancamento);
    }

    @Override
    public ArrayList<DataMovimento> pesquisarDataMovimento() throws Exception {
        return DaoFactory.getDataMovimentoDao().pesquisarDataMovimento();
    }
    
}
