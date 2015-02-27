package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.GrupoCpa;
import java.util.ArrayList;

public interface IGrupoCpaDao {

    public void inserirGrupoCpa(GrupoCpa grupoCpa) throws Exception;

    public void excluirGrupoCpa(GrupoCpa grupoCpa) throws Exception;

    public void alterarGrupoCpa(GrupoCpa grupoCpa) throws Exception;

    public GrupoCpa pesquisarGrupoCpa(Integer id) throws Exception;

    public ArrayList<GrupoCpa> pesquisarGrupoCpa(String nome) throws Exception;

    public ArrayList<GrupoCpa> pesquisarGrupoCpa() throws Exception;

}
