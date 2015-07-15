package ru.edabudet.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.edabudet.controller.BaseController;
import ru.edabudet.controller.logic.ProductListLogic;
import ru.edabudet.controller.logic.RoomLogic;

import static spark.Spark.post;
import static spark.Spark.get;

public class Rooms extends BaseController {


    @Override
    public void routes() {

        RoomLogic roomLogic = new RoomLogic();
        ProductListLogic productListLogic = new ProductListLogic();

        post("/rooms/:password", (request, response) -> {

            return roomLogic.createRoom(request.params("password"));

        });

        get("/rooms/*/*", (request, response) -> {

            if (roomLogic.connectRoom(request.splat()[0], request.splat()[1])){
                //productListLogic.getProductList(request.splat()[0]);
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                String json = gson.toJson(productListLogic.getProductList(request.splat()[0]));
                //Здесь должна быть сериализация:)
                return json;

            }else return "Not logged in";

        });
    }
}
