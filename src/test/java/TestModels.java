import org.junit.Test;
import ru.edabudet.model.ProductList;
import ru.edabudet.model.Room;
import ru.edabudet.utils.EMF;
import org.junit.Assert;

import javax.persistence.EntityManager;


public class TestModels {



    @Test
    public void testModelsRoom() {
        Room room = new Room();
        room.setPassword("qwerty");

        EntityManager em = EMF.getEm();
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
        em.close();


        Room room1;
        EntityManager em1 = EMF.getEm();
        em1.getTransaction().begin();
        room1 = em1.find(Room.class, (long) 1);
        em1.getTransaction().commit();
        em1.close();

        Assert.assertEquals(room.getId(), room1.getId());
        Assert.assertEquals(room.getPassword(),room1.getPassword());


    }

    @Test
    public void testModelsProductList(){
        ProductList productList = new ProductList();
        productList.setProductName("apple");
        productList.setRoom((long) 1);
        productList.setBought(false);

        EntityManager em = EMF.getEm();
        em.getTransaction().begin();
        em.persist(productList);
        em.getTransaction().commit();
        em.close();

        ProductList productList1;

        EntityManager em1 = EMF.getEm();
        em1.getTransaction().begin();
        productList1 = em1.find(ProductList.class,(long) 1);
        em1.getTransaction().commit();
        em1.close();

        Assert.assertEquals(productList.getId(), productList1.getId());
        Assert.assertEquals(productList.getProductName(), productList1.getProductName());
        Assert.assertEquals(productList.getRoom(), productList1.getRoom());
        Assert.assertEquals(productList.isBought(), productList1.isBought());
    }



}
