package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IGrupoCpaService;
import java.util.ArrayList;
import java.util.Date;

public class GrupoCpaService implements IGrupoCpaService{
    private GrupoCpa grupoCpa;
    private Date dataInclusao;
    private Date dataAlteracao;
    
    @Override
    public void inserirGrupoCpa(String nome, Usuario usuario) throws Exception {
        dataInclusao = new Date();
        grupoCpa = new GrupoCpa();
        grupoCpa.setNome(nome);
        grupoCpa.setUsuarioinclusao(usuario);
        grupoCpa.setDatainclusao(dataInclusao);
        DaoFactory.getGrupoCpaDao().inserirGrupoCpa(grupoCpa);
    }

    @Override
    public void excluirGrupoCpa(Integer id) throws Exception {
        DaoFactory.getGrupoCpaDao().excluirGrupoCpa(pesquisarGrupoCpa(id));
    }

    @Override
    public void alterarGrupoCpa(Integer id, String nome, Usuario usuario) throws Exception {
        dataAlteracao = new Date();
        grupoCpa = new GrupoCpa();
        grupoCpa.setId(id);
        grupoCpa.setNome(nome);
        grupoCpa.setUsuarioalteracao(usuario);
        grupoCpa.setDataalteracao(dataAlteracao);
        DaoFactory.getGrupoCpaDao().alterarGrupoCpa(grupoCpa);
    }

    @Override
    public GrupoCpa pesquisarGrupoCpa(Integer id) throws Exception {
        return DaoFactory.getGrupoCpaDao().pesquisarGrupoCpa(id);
    }

    @Override
    public ArrayList<GrupoCpa> pesquisarGrupoCpa(String nome) throws Exception {
        return DaoFactory.getGrupoCpaDao().pesquisarGrupoCpa(nome);
    }

    @Override
    public ArrayList<GrupoCpa> pesquisarGrupoCpa() throws Exception {
        return DaoFactory.getGrupoCpaDao().pesquisarGrupoCpa();
    }
    
}
