package ru.edabudet.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import ru.edabudet.controller.BaseController;
import ru.edabudet.controller.logic.ProductListLogic;
import ru.edabudet.model.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;


import static spark.Spark.post;

public class ProductLists extends BaseController{

    @Override
    public void routes() {

        ProductListLogic productListLogic = new ProductListLogic();

        post("/productlists/add", (request, response) -> {

            Type arrayList = new TypeToken<ArrayList<Product>>(){}.getType();
            ArrayList<Product> products = new Gson().fromJson(request.body(), arrayList);

            for (Product product : products) {
                productListLogic.createProductList(product.getProductName(), product.getRoom());
            }

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            return gson.toJson(productListLogic.getProductList(products.get(0).getRoom()));
        });

        post("/productlists/remove", (request, response) -> {


            Type arrayList = new TypeToken<ArrayList<Product>>(){}.getType();
            ArrayList<Product> products = new Gson().fromJson(request.body(), arrayList);

            for(Product product : products){
                productListLogic.removeProductList(product.getId());
            }

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            return gson.toJson(productListLogic.getProductList(products.get(0).getRoom()));
        });
    }
}
