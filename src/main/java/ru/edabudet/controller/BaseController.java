package ru.edabudet.controller;


import javax.persistence.EntityManager;


public abstract class BaseController {
    public BaseController() {
        routes();
    }

    protected EntityManager em;

    abstract public void routes();

}
