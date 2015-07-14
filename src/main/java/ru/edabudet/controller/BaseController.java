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

}
