package ru.edabudet;

import ru.edabudet.controller.api.ProductLists;
import ru.edabudet.controller.api.Rooms;
import ru.edabudet.controller.api.Users;

import static spark.SparkBase.setPort;


public class Application {

    public static void main(String[] args) {

        new Rooms();
        new ProductLists();
    }
}
