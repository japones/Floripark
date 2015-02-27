package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;
import java.util.Date;

public interface IServicoService {

    public Boolean inserirServico(String descricao, Character sigla, Usuario usuario) throws Exception;

    public void excluirServico(Integer id) throws Exception;

    public Boolean alterarServico(Integer id, String descricao, Character sigla, Usuario usuario, Date dataInclusao, Usuario usuarioInclusao) throws Exception;

    public Servico pesquisarServico(Integer id) throws Exception;

    public Servico pesquisaServico(Character sigla) throws Exception;
    
    public ArrayList<Servico> pesquisarServico() throws Exception;
}
