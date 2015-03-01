package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IDadoDao;
import br.com.floripark.financeiro.model.Dado;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class DadoDao implements IDadoDao {
    
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirDado(Dado dado) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(dado);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirDado(Dado dado) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(Dado.class, dado.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarDado(Dado dado) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(dado);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public Dado pesquisarDado(Integer id) throws Exception {
        Dado ret = null;
        try {
            ret = entityManager.find(Dado.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Dado Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<Dado> pesquisarDado(RetornoBancario retorno) throws Exception {
        ArrayList<Dado> lista;
        Query query = entityManager.createQuery("SELECT x FROM Dado x WHERE x.retorno = :x ");
        query.setParameter("x", retorno);
        lista = (ArrayList<Dado>) query.getResultList();
        return lista;
    }

}
