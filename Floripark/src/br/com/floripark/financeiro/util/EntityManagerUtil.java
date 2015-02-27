package br.com.floripark.financeiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("DEFAULT_PU");
        }
        return emf.createEntityManager();
    }
}
