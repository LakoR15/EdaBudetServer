package ru.edabudet.controller.logic;

import ru.edabudet.model.Product;
import ru.edabudet.utils.EMF;

import java.util.List;


public class ProductListLogic extends EMF {

    public void createProductList(String productName, Long room){

        Product product = new Product();
        product.setProductName(productName);
        product.setRoom(room);
        product.setBought(false);

        em = EMF.getEm();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Не удалось добавить объект в БД: " + e.getMessage());
        }finally {
            em.close();
        }

    }

    public List<Product> getProductList(Long id){

        List<Product> products;

        em = EMF.getEm();
        try {
            em.getTransaction().begin();
            products = em.createQuery("SELECT pl FROM ru.edabudet.model.Product pl where pl.room=:idroom and pl.bought=false", Product.class)
                    .setParameter("idroom",id)
                    .getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return products;

    }

    public void removeProductList(Long id){
        Product product;

        em = EMF.getEm();
        try{
            em.getTransaction().begin();
            product = em.find(Product.class, id);
            product.setBought(true);
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
