package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.ITipoLancamentoDao;
import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class TipoLancamentoDao implements ITipoLancamentoDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirTipoLancamento(TipoLancamento tipoLancamento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(tipoLancamento);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirTipoLancamento(TipoLancamento tipoLancamento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(TipoLancamento.class, tipoLancamento.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarTipoLancamento(TipoLancamento tipoLancamento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(tipoLancamento);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public TipoLancamento pesquisarTipoLancamento(Integer id) throws Exception {
        TipoLancamento ret = null;
        try {
            ret = entityManager.find(TipoLancamento.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Sócios Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<TipoLancamento> pesquisarTipoLancamento(String nome) throws Exception {
        ArrayList<TipoLancamento> lista;
        Query query = entityManager.createQuery("select x from TipoLancamento x where x.nome like '%" + nome + "%' ");
        lista = (ArrayList<TipoLancamento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<TipoLancamento> pesquisarTipoLancamento() throws Exception {
        ArrayList<TipoLancamento> lista;
        Query query = entityManager.createQuery("select x from TipoLancamento x ");
        lista = (ArrayList<TipoLancamento>) query.getResultList();
        return lista;
    }

}
