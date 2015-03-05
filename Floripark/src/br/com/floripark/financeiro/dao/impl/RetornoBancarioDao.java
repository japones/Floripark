package br.com.floripark.financeiro.dao.impl;

import br.com.floripark.financeiro.dao.IRetornoBancarioDao;
import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.Empresa;
import br.com.floripark.financeiro.model.RetornoBancario;
import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.util.EntityManagerUtil;
import static br.com.floripark.financeiro.util.EntityManagerUtil.getEntityManager;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;

public class RetornoBancarioDao implements IRetornoBancarioDao {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public RetornoBancario inserirRetorno(RetornoBancario retorno) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(retorno);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
        return retorno;
    }

    @Override
    public void excluirRetorno(RetornoBancario retorno) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(entityManager.getReference(RetornoBancario.class, retorno.getId()));
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void alterarRetorno(RetornoBancario retorno) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(retorno);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public RetornoBancario pesquisarRetorno(Integer id) throws Exception {
        RetornoBancario ret = null;
        try {
            ret = entityManager.find(RetornoBancario.class, id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao Retornar Retorno Bancario Pelo ID" + ex);
        } finally {
            getEntityManager().close();
        }
        return ret;
    }

    @Override
    public ArrayList<RetornoBancario> pesquisarRetorno() throws Exception {
        ArrayList<RetornoBancario> lista;
        Query query = entityManager.createQuery("select x from RetornoBancario x ");
        lista = (ArrayList<RetornoBancario>) query.getResultList();
        return lista;
    }

    @Override
    public Boolean executarProcedure(RetornoBancario retorno, Usuario usuario, Date dataInclusao) throws Exception {
        //prepara a procedure
        entityManager.getTransaction().begin();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("DISTRIBUIR");
        //registra os parametros da procedure
        query.registerStoredProcedureParameter("@ID_RETORNO", Integer.class, ParameterMode.IN); //entrada
        query.registerStoredProcedureParameter("@ID_USUARIOINCLUSAO", Integer.class, ParameterMode.IN); //entrada
        query.registerStoredProcedureParameter("@DATA_INCLUSAO", Date.class, ParameterMode.IN); //entrada
        query.setParameter("@ID_RETORNO", retorno.getId()); //seta o parametro
        query.setParameter("@ID_USUARIOINCLUSAO", usuario.getId()); //seta o parametro
        query.setParameter("@DATA_INCLUSAO", dataInclusao); //seta o parametro
        Boolean incluir = query.execute();
        entityManager.getTransaction().commit();
        
        return incluir;
    }

    @Override
    public ArrayList<RetornoBancario> pesquisarRetorno(Banco banco, Servico servico, Empresa empresa) throws Exception {
        Query query = entityManager.createQuery("SELECT x FROM RetornoBancario x WHERE x.banco = :b AND x.servico = :s AND x.empresa = :e");
        query.setParameter("b", banco);
        query.setParameter("s", servico);
        query.setParameter("e", empresa);
        return (ArrayList<RetornoBancario>) query.getResultList();
    }
}
