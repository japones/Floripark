package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public interface IRetornoBancarioService {
    
    public RetornoBancario inserirRetorno(Servico servico, Empresa empresa, Banco banco, Date dataPagamento, File arquivo, Usuario usuario) throws Exception;
    
    public void excluirRetorno(Integer id) throws Exception;
    
    public void alterarRetorno(Integer id, Servico servico, Empresa empresa, Banco banco, Date dataPagamento, File arquivo, Usuario usuario, Date dataInclusao, Usuario usuarioInclusao) throws Exception;
    
    public RetornoBancario pesquisarRetorno(Integer id) throws Exception;
    
    public ArrayList<RetornoBancario> pesquisarRetorno() throws Exception;
    
    public Boolean importarRetorno (File arquivo, Usuario usuario) throws Exception;
}
