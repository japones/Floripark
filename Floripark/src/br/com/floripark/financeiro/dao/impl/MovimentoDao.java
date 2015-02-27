package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IMovimentoDao;
import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.DataMovimento;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.GrupoCpa;
import br.com.floripark.financeiro.model.Movimento;
import br.com.floripark.financeiro.model.TipoLancamento;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class MovimentoDao implements IMovimentoDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirMovimento(Movimento movimento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(movimento);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirMovimento(Movimento movimento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(Movimento.class, movimento.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarMovimento(Movimento movimento) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(movimento);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public Movimento pesquisarMovimento(Integer id) throws Exception {
        Movimento ret = null;
        try {
            ret = entityManager.find(Movimento.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Sócios Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(DataMovimento dataMovimento) throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x where x.datamovimento = '" + dataMovimento + "' ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(TipoLancamento tipoLancamento) throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x where x.tipolancamento = '" + tipoLancamento + "' ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;

    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(BigDecimal valor) throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x where x.valor = '" + valor + "' ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(Banco banco) throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x where x.banco = '" + banco + "' ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(Empresa empresa) throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x where x.empresa = '" + empresa + "' ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento(GrupoCpa grupoCpa) throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x where x.grupocpa = '" + grupoCpa + "' ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Movimento> pesquisarMovimento() throws Exception {
        ArrayList<Movimento> lista;
        Query query = entityManager.createQuery("select x from Movimento x ");
        lista = (ArrayList<Movimento>) query.getResultList();
        return lista;
    }
}
