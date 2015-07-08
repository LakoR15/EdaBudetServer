package ru.edabudet.controller;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class BaseController {
    public BaseController() {
        routes();
    }

    protected EntityManager em;

    abstract public void routes();

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("edabudet_db");

    public static EntityManager getEm() {
        if(factory == null) {
            throw new IllegalStateException("EntityManagerFactory not yet initialized");
        }
        return factory.createEntityManager();
    }
}
