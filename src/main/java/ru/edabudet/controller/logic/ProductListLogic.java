package ru.edabudet.controller.logic;

import ru.edabudet.model.ProductList;
import ru.edabudet.utils.EMF;

import java.util.List;


public class ProductListLogic extends EMF {

    public void createProductList(String productName, Long room){

        ProductList productList = new ProductList();
        productList.setProductName(productName);
        productList.setRoom(room);
        productList.setBought(false);

        em = EMF.getEm();
        try {
            em.getTransaction().begin();
            em.persist(productList);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Не удалось добавить объект в БД: " + e.getMessage());
        }finally {
            em.close();
        }

    }

    public List<ProductList> getProductList(Long id){

        List<ProductList> productLists;

        em = EMF.getEm();
        try {
            em.getTransaction().begin();
            productLists = em.createQuery("SELECT pl FROM ru.edabudet.model.ProductList pl where pl.room=:idroom and pl.bought=false", ProductList.class)
                    .setParameter("idroom",id)
                    .getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return productLists;

    }

    public void removeProductList(Long id){
        ProductList productList;

        em = EMF.getEm();
        try{
            em.getTransaction().begin();
            productList = em.find(ProductList.class, id);
            productList.setBought(true);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Не удалось обновить объект: " + e.getMessage());
        }finally {
            em.close();
        }

    }
}
