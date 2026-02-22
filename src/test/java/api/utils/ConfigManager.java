package api.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try {
            String env = System.getProperty("env", "qa");
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config/" + env + ".properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
