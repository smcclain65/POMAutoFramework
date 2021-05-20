package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Data {

    public static Properties getProperties(String file) {
        Properties prop = new Properties();

        switch (file) {
            case "config":
                InputStream config = Properties.class.getResourceAsStream("/config/config");
                try {
                    prop.load(config);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        case "objectlocations":
                InputStream objectlocations = Properties.class.getResourceAsStream("/objectRepository.properties");
                try {
                    prop.load(objectlocations);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return prop;
    }
}