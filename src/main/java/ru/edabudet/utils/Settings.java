package ru.edabudet.utils;

import java.io.IOException;
import java.util.Properties;

public class Settings {
    public Properties properties = new Properties();

    public Settings() {
        try {
            properties.load(getClass().getResourceAsStream("/application.properties"));
        } catch (IOException e) {
        }
    }

    public String getProperty(String property) {
        String result = properties.getProperty(property);
        System.out.println(result);
        return result;
    }

}
