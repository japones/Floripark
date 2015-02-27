package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IUsuarioDao;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class UsuarioDao implements IUsuarioDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void inserirUsuario(Usuario usuario) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(usuario);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void excluirUsuario(Usuario usuario) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(Usuario.class, usuario.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarUsuario(Usuario usuario) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(usuario);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public Usuario pesquisarUsuario(Integer id) throws Exception {
        Usuario ret = null;
        try {
            ret = entityManager.find(Usuario.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Usuário Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<Usuario> pesquisarUsuario(String nome) throws Exception {
        ArrayList<Usuario> lista;
        Query query = entityManager.createQuery("select x from Usuario x where x.nome like '%" + nome + "%'");
        lista = (ArrayList<Usuario>) query.getResultList();
        return lista;
    }

    @Override
    public ArrayList<Usuario> pesquisarUsuario() throws Exception {
        ArrayList<Usuario> lista;
        Query query = entityManager.createQuery("select x from Usuario x ");
        lista = (ArrayList<Usuario>) query.getResultList();
        return lista;
    }

}
