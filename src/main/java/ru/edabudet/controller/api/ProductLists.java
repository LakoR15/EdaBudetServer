package ru.edabudet.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.edabudet.controller.BaseController;
import ru.edabudet.controller.logic.ProductListLogic;

import static spark.Spark.post;

public class ProductLists extends BaseController{

    @Override
    public void routes() {

        ProductListLogic productListLogic = new ProductListLogic();

        post("/productlists/add/*/*", (request, response) -> {

            productListLogic.createProductList(request.splat()[0], request.splat()[1]);
            //productListLogic.getProductList(request.splat()[1]);
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(productListLogic.getProductList(request.splat()[1]));
            //Здесь должна быть сериализация:)
            return json;
        });

        post("/productlists/remove/*/*", (request, response) -> {

            productListLogic.removeProductList(request.splat()[0]);
            //productListLogic.getProductList(request.splat()[1]);
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(productListLogic.getProductList(request.splat()[1]));

            return json;
        });
    }
}
