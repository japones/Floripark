package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Movimento;
import br.com.floripark.financeiro.model.TipoLancamento;
import java.math.BigDecimal;
import java.util.ArrayList;

public interface IMovimentoService {
    
    public void inserirMovimento(DataMovimento dataMovimento, TipoLancamento tipoLancamento, BigDecimal valor, Banco banco, Empresa empresa, GrupoCpa grupoCpa) throws Exception;

    public void excluirMovimento(Integer id) throws Exception;
    
    public void alterarMovimento(Integer id, DataMovimento dataMovimento, TipoLancamento tipoLancamento, BigDecimal valor, Banco banco, Empresa empresa, GrupoCpa grupoCpa) throws Exception;
    
    public Movimento pesquisarMovimento(Integer id) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento(DataMovimento dataMovimento) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento(TipoLancamento tipoLancamento) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento(BigDecimal valor) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento(Banco banco) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento(Empresa empresa) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento(GrupoCpa grupoCpa) throws Exception;
    
    public ArrayList<Movimento> pesquisarMovimento() throws Exception;
    
}
