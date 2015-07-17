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
        em.getTransaction().begin();
        em.persist(productList);
        em.getTransaction().commit();
        em.close();

    }

    public List<ProductList> getProductList(Long id){

        List<ProductList> productLists;

        em = EMF.getEm();
        em.getTransaction().begin();
        productLists = em.createQuery("SELECT pl FROM ru.edabudet.model.ProductList pl where pl.room=:idroom and pl.bought=false", ProductList.class)
                .setParameter("idroom",id)
                .getResultList();
        em.getTransaction().commit();
        em.close();

        return productLists;

    }

    public void removeProductList(Long id){
        ProductList productList;

        em = EMF.getEm();
        em.getTransaction().begin();
        productList = em.find(ProductList.class, id);
        productList.setBought(true);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
