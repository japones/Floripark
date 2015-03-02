package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IDadoService;
import java.util.ArrayList;
import java.util.Date;

public class DadoService implements IDadoService{

    @Override
    public void inserirDado(RetornoBancario retorno, String linha, Usuario usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirDado(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarDado(Integer id, RetornoBancario retorno, String linha, Usuario usuario, Date dataInclusao, Usuario usuarioInclusao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dado pesquisarDado(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Dado> pesquisarDado(RetornoBancario retorno) throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Dado> pesquisarDado() throws Exception {
        return DaoFactory.getDadoDao().pesquisarDado();
    }
    
}
