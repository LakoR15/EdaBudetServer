package ru.edabudet.controller.logic;

import ru.edabudet.model.ProductList;
import ru.edabudet.model.Room;
import ru.edabudet.utils.EMF;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ProductListLogic extends EMF {

    public void createProductList(String productName, String room){

        ProductList productList = new ProductList();
        productList.setProductName(productName);
        productList.setRoom(Long.valueOf(room));
        productList.setBought(false);

        em = EMF.getEm();
        em.getTransaction().begin();
        em.persist(productList);
        em.getTransaction().commit();
        em.close();

    }

    public List<ProductList> getProductList(String id_str){

        List<ProductList> productLists;
        Long id = Long.valueOf(id_str);

        em = EMF.getEm();
        em.getTransaction().begin();
        productLists = em.createQuery("SELECT pl FROM ru.edabudet.model.ProductList pl where pl.room=:idroom", ProductList.class)
                .setParameter("idroom",id)
                .getResultList();
        em.getTransaction().commit();
        em.close();

        return productLists;

    }

    public void removeProductList(String id_str){
        ProductList productList;
        Long id = Long.valueOf(id_str);

        em = EMF.getEm();
        em.getTransaction().begin();
        productList = em.find(ProductList.class, id);
        productList.setBought(true);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
