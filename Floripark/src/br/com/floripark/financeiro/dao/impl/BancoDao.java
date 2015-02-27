package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IBancoDao;
import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class BancoDao implements IBancoDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirBanco(Banco banco) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(banco);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirBanco(Banco banco) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(Banco.class, banco.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarBanco(Banco banco) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(banco);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public Banco pesquisarBanco(Integer id) throws Exception {
        Banco ret = null;
        try {
            ret = entityManager.find(Banco.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Sócios Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<Banco> pesquisarBanco(String nome) throws Exception {
        ArrayList<Banco> lista;
        Query query = entityManager.createQuery("select x from Banco x where x.nome like '%" + nome + "%'");
        lista = (ArrayList<Banco>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Banco> pesquisarBanco() throws Exception {
        ArrayList<Banco> lista;
        Query query = entityManager.createQuery("select x from Banco x ");
        lista = (ArrayList<Banco>) query.getResultList();
        return lista;
    }
}
