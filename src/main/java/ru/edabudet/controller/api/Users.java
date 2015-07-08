package ru.edabudet.controller.api;


import ru.edabudet.controller.BaseController;
import ru.edabudet.model.User;

import static spark.Spark.get;
import static spark.Spark.post;

public class Users extends BaseController {

    @Override
    public void routes() {

        post("/users/:username", (request, response) -> {

            User user1 = new User();
            user1.setName(request.params("username"));

            em = getEm();
            em.getTransaction().begin();
            em.persist(user1);
            em.getTransaction().commit();
            em.close();

            return "Hello";
        });

        get("/users/:id", (request, response) -> {

            Long id = Long.valueOf(request.params("id"));

            em = getEm();
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            em.getTransaction().commit();
            em.close();

            return "Hello" + user.getName();
        });

    }
}
