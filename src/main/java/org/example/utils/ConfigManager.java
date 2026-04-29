package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/Config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Config load failed" + e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
