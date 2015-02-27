package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IGrupoCpaDao;
import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class GrupoCpaDao implements IGrupoCpaDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirGrupoCpa(GrupoCpa grupoCpa) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(grupoCpa);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirGrupoCpa(GrupoCpa grupoCpa) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(GrupoCpa.class, grupoCpa.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarGrupoCpa(GrupoCpa grupoCpa) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(grupoCpa);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public GrupoCpa pesquisarGrupoCpa(Integer id) throws Exception {
        GrupoCpa ret = null;
        try {
            ret = entityManager.find(GrupoCpa.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Sócios Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<GrupoCpa> pesquisarGrupoCpa(String nome) throws Exception {
        ArrayList<GrupoCpa> lista;
        Query query = entityManager.createQuery("select x from GrupoCpa x where x.nome like '%" + nome + "%'");
        lista = (ArrayList<GrupoCpa>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<GrupoCpa> pesquisarGrupoCpa() throws Exception {
        ArrayList<GrupoCpa> lista;
        Query query = entityManager.createQuery("select x from GrupoCpa x ");
        lista = (ArrayList<GrupoCpa>) query.getResultList();
        return lista;
    }

}
