import org.junit.Test;
import ru.edabudet.model.Product;
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
        Product product = new Product();
        product.setProductName("apple");
        product.setRoom((long) 1);
        product.setBought(false);

        EntityManager em = EMF.getEm();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();

        Product product1;

        EntityManager em1 = EMF.getEm();
        em1.getTransaction().begin();
        product1 = em1.find(Product.class,(long) 1);
        em1.getTransaction().commit();
        em1.close();

        Assert.assertEquals(product.getId(), product1.getId());
        Assert.assertEquals(product.getProductName(), product1.getProductName());
        Assert.assertEquals(product.getRoom(), product1.getRoom());
        Assert.assertEquals(product.isBought(), product1.isBought());
    }



}
