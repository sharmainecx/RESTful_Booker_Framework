package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

   private static final String Config_File = "config.properties";
   private static final Properties prop = new Properties();

   static{
       try(InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream(Config_File)){
            if(in == null){
                throw new RuntimeException(Config_File + " not found on the classpath. " + "Put it in src/test/resources");}
            prop.load(in);
       } catch (Exception e) {
           throw new RuntimeException("Failed to Load " +Config_File, e);
       }
   }

   private ConfigReader(){

   }

    public static String get(String key) {
        String value = System.getProperty(key);                       // -Dbase.url=...
        if (value == null) {
            value = System.getenv(key.toUpperCase().replace('.', '_')); // BASE_URL
        }
        if (value == null) {
            value = prop.getProperty(key);
        }
        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Missing config key: " + key);
        }
        return value.trim();
    }

    public static String getBaseUrl() {
        return get("BASE_URI");
    }

    public static String getUsername(){
       return get("api_username");
    }

    public static String getPassword(){
       return get("api_password");
    }
}
