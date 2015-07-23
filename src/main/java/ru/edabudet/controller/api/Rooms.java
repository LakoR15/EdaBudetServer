package ru.edabudet.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.edabudet.controller.BaseController;
import ru.edabudet.controller.logic.ProductListLogic;
import ru.edabudet.controller.logic.RoomLogic;
import ru.edabudet.model.Room;

import static spark.Spark.post;

public class Rooms extends BaseController {


    @Override
    public void routes() {

        RoomLogic roomLogic = new RoomLogic();
        ProductListLogic productListLogic = new ProductListLogic();

        post("/rooms/create/:password", (request, response) -> roomLogic.createRoom(request.params("password")));

        post("/rooms/connect", (request, response) -> {

            try{
                Room room = new Gson().fromJson(request.body(), Room.class);
                if (roomLogic.connectRoom(room.getId(), room.getPassword())){
                    Gson gson = new GsonBuilder()
                            .setPrettyPrinting()
                            .create();
                    return gson.toJson(productListLogic.getProductList(room.getId()));

                }else return "Not logged in";

            }catch (Exception e){
                throw new RuntimeException("Ошибка в JSON " + e.getMessage());
            }
        });
    }
}
