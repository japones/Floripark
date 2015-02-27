package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IEmpresaDao;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class EmpresaDao implements IEmpresaDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirEmpresa(Empresa empresa) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(empresa);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirEmpresa(Empresa empresa) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(Empresa.class, empresa.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarEmpresa(Empresa empresa) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(empresa);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public Empresa pesquisarEmpresa(Integer id) throws Exception {
        Empresa ret = null;
        try {
            ret = entityManager.find(Empresa.class, id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Sócios Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<Empresa> pesquisarEmpresas(String nome) throws Exception {
        ArrayList<Empresa> empresas;
        Query query = entityManager.createQuery("SELECT x FROM Empresa x WHERE x.nome LIKE :n ");
        query.setParameter("n", nome);
        empresas = (ArrayList<Empresa>) query.getResultList();
        return empresas;
    }

    @Override
    public ArrayList<Empresa> pesquisarEmpresa() throws Exception {
        ArrayList<Empresa> lista;
        Query query = entityManager.createQuery("select x from Empresa x ");
        lista = (ArrayList<Empresa>) query.getResultList();
        return lista;
    }
}
