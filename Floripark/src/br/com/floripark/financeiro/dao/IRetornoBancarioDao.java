package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;
import java.util.Date;

public interface IRetornoBancarioDao {

    public RetornoBancario inserirRetorno(RetornoBancario retorno) throws Exception;

    public void excluirRetorno(RetornoBancario retorno) throws Exception;

    public void alterarRetorno(RetornoBancario retorno) throws Exception;

    public RetornoBancario pesquisarRetorno(Integer id) throws Exception;
    
    public Boolean executarProcedure (RetornoBancario retorno, Usuario usuario, Date dataInclusao) throws Exception;

    public ArrayList<RetornoBancario> pesquisarRetorno() throws Exception;
}
