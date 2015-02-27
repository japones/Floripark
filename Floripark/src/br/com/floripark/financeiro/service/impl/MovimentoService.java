package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Movimento;
import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.service.IMovimentoService;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MovimentoService implements IMovimentoService {

    Movimento movimento;

    @Override
    public void inserirMovimento(DataMovimento dataMovimento, TipoLancamento tipoLancamento, BigDecimal valor, Banco banco, Empresa empresa, GrupoCpa grupoCpa) throws Exception {
        movimento = new Movimento();
        movimento.setBanco(banco);
        movimento.setDatamovimento(dataMovimento);
        movimento.setEmpresa(empresa);
        movimento.setGrupocpa(grupoCpa);
        movimento.setTipolancamento(tipoLancamento);
        movimento.setValor(valor);
        DaoFactory.getMovimentoDao().inserirMovimento(movimento);
    }

    @Override
    public void excluirMovimento(Integer id) throws Exception {
        DaoFactory.getMovimentoDao().excluirMovimento(pesquisarMovimento(id));
    }

    @Override
    public void alterarMovimento(Integer id, DataMovimento dataMovimento, TipoLancamento tipoLancamento, BigDecimal valor, Banco banco, Empresa empresa, GrupoCpa grupoCpa) throws Exception {
        movimento = new Movimento();
        movimento.setBanco(banco);
        movimento.setDatamovimento(dataMovimento);
        movimento.setEmpresa(empresa);
        movimento.setGrupocpa(grupoCpa);
        movimento.setId(id);
        movimento.setTipolancamento(tipoLancamento);
        movimento.setValor(valor);
        DaoFactory.getMovimentoDao().alterarMovimento(movimento);
    }

    @Override
    public Movimento pesquisarMovimento(Integer id) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(id);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(DataMovimento dataMovimento) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(dataMovimento);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(TipoLancamento tipoLancamento) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(tipoLancamento);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(BigDecimal valor) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(valor);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(Banco banco) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(banco);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(Empresa empresa) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(empresa);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(GrupoCpa grupoCpa) throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento(grupoCpa);
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento() throws Exception {
        return DaoFactory.getMovimentoDao().pesquisarMovimento();
    }
}
