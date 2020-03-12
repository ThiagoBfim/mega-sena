package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesSearch {

    private static final Properties prop = new Properties();

    private static PropertiesSearch properties;

    private PropertiesSearch() {
        readyPropertiesFile();
    }

    static PropertiesSearch getInstance() {
        if (properties == null) {
            properties = new PropertiesSearch();
        }
        return properties;
    }

    private static void readyPropertiesFile() {
        try (InputStream input = PropertiesSearch.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String getProperty(String key){
        return prop.getProperty(key);
    }
}
