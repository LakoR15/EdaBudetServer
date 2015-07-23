import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.edabudet.controller.logic.ProductListLogic;
import ru.edabudet.model.Product;
import ru.edabudet.utils.EMF;

public class TestProductListLogic extends EMF{

    @Before
    public void dropBD(){
        
    }

    @Test
    public void TestRemoveProductLists(){
        Product product;
        ProductListLogic productListLogic = new  ProductListLogic();

        productListLogic.createProductList("apple", (long) 1);
        productListLogic.removeProductList((long) 1);

        em = EMF.getEm();
        em.getTransaction().begin();
        product = em.find(Product.class, (long) 1);
        em.getTransaction().commit();
        em.close();

        assertEquals(product.isBought(), true);
    }

   @Test
    public void TestCreateProductLists(){
        ProductListLogic productListLogic = new ProductListLogic();
        productListLogic.createProductList("apple", (long) 1);

        Product product;

        em = EMF.getEm();
        em.getTransaction().begin();
        product = em.find(Product.class, (long) 1);
        em.getTransaction().commit();
        em.close();

        assertEquals(product.getProductName(), "apple");
    }


}
