package com.milosbognar.buylist.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static String getProjectProperty(String property) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return (String) prop.get(property);
    }

    public static String getSystemProperty(String property) {
        return System.getProperty(property);
    }
}
