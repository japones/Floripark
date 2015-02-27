package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.Servico;
import java.util.ArrayList;

public interface IServicoDao {

    public void inserirServico(Servico servico) throws Exception;

    public void excluirServico(Servico servico) throws Exception;

    public void alterarServico(Servico servico) throws Exception;

    public Servico pesquisarServico(Integer id) throws Exception;
    
    public ArrayList<Servico> pesquisarServico() throws Exception;
}
