package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Movimento;
import br.com.floripark.financeiro.model.TipoLancamento;
import java.math.BigDecimal;
import java.util.ArrayList;

public interface IMovimentoDao {

    public void inserirMovimento(Movimento movimento) throws Exception;

    public void excluirMovimento(Movimento movimento) throws Exception;

    public void alterarMovimento(Movimento movimento) throws Exception;

    public Movimento pesquisarMovimento(Integer id) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento(DataMovimento dataMovimento) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento(TipoLancamento tipoLancamento) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento(BigDecimal valor) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento(Banco banco) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento(Empresa empresa) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento(GrupoCpa grupoCpa) throws Exception;

    public ArrayList<Movimento> pesquisarMovimento() throws Exception;

}
