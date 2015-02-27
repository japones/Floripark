package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;

public interface IGrupoCpaService {
    
    public void inserirGrupoCpa(String nome, Usuario usuario) throws Exception;

    public void excluirGrupoCpa(Integer id) throws Exception;
    
    public void alterarGrupoCpa(Integer id, String nome, Usuario usuario) throws Exception;
    
    public GrupoCpa pesquisarGrupoCpa(Integer id) throws Exception;
    
    public ArrayList<GrupoCpa> pesquisarGrupoCpa(String nome) throws Exception;
    
    public ArrayList<GrupoCpa> pesquisarGrupoCpa() throws Exception;
    
}
