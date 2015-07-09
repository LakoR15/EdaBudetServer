package ru.edabudet.controller.api;

import ru.edabudet.controller.BaseController;
import ru.edabudet.model.Room;

import static spark.Spark.post;
import static spark.Spark.get;

public class Rooms extends BaseController {


    @Override
    public void routes() {

        post("/rooms/:password", (request, response) -> {

            Room room = new Room();
            room.setPassword(request.params("password"));

            em = getEm();
            em.getTransaction().begin();
            em.persist(room);
            em.getTransaction().commit();
            em.close();

            return "Room created success!";

        });

        get("/rooms/*/*", (request, response) -> {

            Long id = Long.valueOf(request.splat()[0]);
            String password = String.valueOf(request.splat()[1]);

            em = getEm();
            em.getTransaction().begin();
            Room room = em.find(Room.class, id);
            em.getTransaction().commit();
            em.close();

            if(password.equals(room.getPassword())){
                return "Login is succesful";
            }else {
                return "Not logged in";
            }

        });
    }
}
