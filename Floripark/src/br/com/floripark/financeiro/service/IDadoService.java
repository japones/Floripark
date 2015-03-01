package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;
import java.util.Date;

public interface IDadoService {

    public void inserirDado(RetornoBancario retorno, String linha, Usuario usuario) throws Exception;

    public void excluirDado(Integer id) throws Exception;

    public void alterarDado(Integer id, RetornoBancario retorno, String linha, Usuario usuario, Date dataInclusao, Usuario usuarioInclusao) throws Exception;

    public Dado pesquisarDado(Integer id) throws Exception;

    public ArrayList<Dado> pesquisarDado(RetornoBancario retorno) throws Exception;

}
