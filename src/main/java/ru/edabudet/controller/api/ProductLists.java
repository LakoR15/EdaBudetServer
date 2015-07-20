package ru.edabudet.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import ru.edabudet.controller.BaseController;
import ru.edabudet.controller.logic.ProductListLogic;
import ru.edabudet.model.ProductList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;


import static spark.Spark.post;

public class ProductLists extends BaseController{

    @Override
    public void routes() {

        ProductListLogic productListLogic = new ProductListLogic();

        post("/productlists/add", (request, response) -> {

            Type arrayList = new TypeToken<ArrayList<ProductList>>(){}.getType();
            ArrayList<ProductList> productLists = new Gson().fromJson(request.body(), arrayList);

            for (ProductList product : productLists) {
                productListLogic.createProductList(product.getProductName(), product.getRoom());
            }
//            Iterator<ProductList> iterator = productLists.iterator();
//            while (iterator.hasNext()){
//                ProductList productList = iterator.next();
//                productListLogic.createProductList(productList.getProductName(), productList.getRoom());
//            }

            /*productListLogic.createProductList(productList.getProductName(), productList.getRoom());*/
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(productListLogic.getProductList(productLists.get(0).getRoom()));
            return json;
        });

        post("/productlists/remove", (request, response) -> {


            Type arrayList = new TypeToken<ArrayList<ProductList>>(){}.getType();
            ArrayList<ProductList> productLists = new Gson().fromJson(request.body(), arrayList);

            Iterator<ProductList> iterator = productLists.iterator();
            while (iterator.hasNext()){
                ProductList productList = iterator.next();
                productListLogic.removeProductList(productList.getId());
            }
            /*ProductList productList = new Gson().fromJson(request.body(), ProductList.class);

            productListLogic.removeProductList(productList.getId());*/

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(productListLogic.getProductList(productLists.get(0).getRoom()));

            return json;
        });
    }
}
