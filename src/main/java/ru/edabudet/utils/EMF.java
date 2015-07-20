package ru.edabudet.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class EMF {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(new Settings().getProperty("db"));

    protected EntityManager em;

    public static EntityManager getEm() {
        if(factory == null) {
            throw new IllegalStateException("EntityManagerFactory not yet initialized");
        }
        return factory.createEntityManager();
    }
}
