package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IServicoDao;
import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class ServicoDao implements IServicoDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirServico(Servico servico) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(servico);
            tx.commit();
        } catch (Throwable t) {
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirServico(Servico servico) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(Servico.class, servico.getId()));
            tx.commit();
        } catch (Throwable t) {
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarServico(Servico servico) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(servico);
            tx.commit();
        } catch (Throwable t) {
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public Servico pesquisarServico(Integer id) throws Exception {
        Servico ret = null;
        try {
            ret = entityManager.find(Servico.class, id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Servico Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<Servico> pesquisarServico() throws Exception {
        ArrayList<Servico> lista;
        Query query = entityManager.createQuery("select x from Servico x ");
        lista = (ArrayList<Servico>) query.getResultList();
        return lista;
    }

}
