package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.ITemporarioDao;
import br.com.floripark.financeiro.model.Temporario;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TemporarioDao implements ITemporarioDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirTemporario(Temporario temporario) throws Exception {

        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(temporario);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

}
