package ru.edabudet;

import ru.edabudet.controller.api.Users;

import static spark.SparkBase.setPort;


public class Application {

    public static void main(String[] args) {

        setPort(1122);
        new Users();
    }
}