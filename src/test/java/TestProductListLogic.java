import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.edabudet.controller.logic.ProductListLogic;
import ru.edabudet.model.ProductList;
import ru.edabudet.utils.EMF;

public class TestProductListLogic extends EMF{

    @Before
    public void dropBD(){
        
    }

    @Test
    public void TestRemoveProductLists(){
        ProductList productList;
        ProductListLogic productListLogic = new  ProductListLogic();

        productListLogic.createProductList("potato", (long) 1);
        productListLogic.removeProductList((long) 1);

        em = EMF.getEm();
        em.getTransaction().begin();
        productList = em.find(ProductList.class, (long) 1);
        em.getTransaction().commit();
        em.close();

        assertEquals(productList.isBought(), true);
    }

   @Test
    public void TestCreateProductLists(){
        ProductListLogic productListLogic = new ProductListLogic();
        productListLogic.createProductList("apple", (long) 1);

        ProductList productList;

        em = EMF.getEm();
        em.getTransaction().begin();
        productList = em.find(ProductList.class, (long) 1);
        em.getTransaction().commit();
        em.close();

        assertEquals(productList.getProductName(), "apple");
    }


}
