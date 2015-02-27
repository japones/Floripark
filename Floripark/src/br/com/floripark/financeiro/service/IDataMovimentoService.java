package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.DataMovimento;
import java.util.ArrayList;
import java.util.Date;

public interface IDataMovimentoService {

    public void inserirDataMovimento(Date dataLancamento, Boolean situacao) throws Exception;

    public void excluirDataMovimento(Integer id) throws Exception;

    public void alterarDataMovimento(Integer id, Date dataLancamento, Boolean situacao) throws Exception;

    public DataMovimento pesquisarDataMovimento(Integer id) throws Exception;

    public ArrayList<DataMovimento> pesquisarDataMovimento(Date dataLancamento) throws Exception;
    
    public ArrayList<DataMovimento> pesquisarDataMovimento() throws Exception;

}
