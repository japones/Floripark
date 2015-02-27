package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IDataMovimentoDao;
import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class DataMovimentoDao implements IDataMovimentoDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirDataMovimento(DataMovimento dataMovimento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(dataMovimento);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirDataMovimento(DataMovimento dataMovimento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(DataMovimento.class, dataMovimento.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarDataMovimento(DataMovimento dataMovimento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(dataMovimento);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public DataMovimento pesquisarDataMovimento(Integer id) throws Exception {
        DataMovimento ret = null;
        try {
            ret = entityManager.find(DataMovimento.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Sócios Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<DataMovimento> pesquisarDataMovimento(Date data) throws Exception {
        ArrayList<DataMovimento> lista;
        Query query = entityManager.createQuery("select x from DataMovimento x where x.datamovimento = " + data + " ");
        lista = (ArrayList<DataMovimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<DataMovimento> pesquisarDataMovimento(Boolean situacao) throws Exception {
        ArrayList<DataMovimento> lista;
        Query query = entityManager.createQuery("select x from DataMovimento x where x.situacao = " + situacao + " ");
        lista = (ArrayList<DataMovimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<DataMovimento> pesquisarDataMovimento() throws Exception {
        ArrayList<DataMovimento> lista;
        Query query = entityManager.createQuery("select x from DataMovimento x ");
        lista = (ArrayList<DataMovimento>) query.getResultList();
        return lista;
    }

}
