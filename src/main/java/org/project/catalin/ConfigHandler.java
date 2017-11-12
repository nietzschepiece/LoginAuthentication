package org.project.catalin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cci on 26.09.2017.
 */
public class ConfigHandler {

    public String getDatabaseName() throws IOException {
        InputStream inputStream = null;
        String database = "";
        try {
            Properties prop = new Properties();
            String configFile = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(configFile);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + configFile + "' not found in the classpath");
            }
            database = prop.getProperty("database");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return database;
    }


}
