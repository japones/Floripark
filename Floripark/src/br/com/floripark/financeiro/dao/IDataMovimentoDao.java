package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.DataMovimento;
import java.util.ArrayList;
import java.util.Date;

public interface IDataMovimentoDao {

    public void inserirDataMovimento(DataMovimento dataMovimento) throws Exception;

    public void excluirDataMovimento(DataMovimento dataMovimento) throws Exception;

    public void alterarDataMovimento(DataMovimento dataMovimento) throws Exception;

    public DataMovimento pesquisarDataMovimento(Integer id) throws Exception;

    public ArrayList<DataMovimento> pesquisarDataMovimento(Date data) throws Exception;

    public ArrayList<DataMovimento> pesquisarDataMovimento(Boolean situacao) throws Exception;

    public ArrayList<DataMovimento> pesquisarDataMovimento() throws Exception;
}
