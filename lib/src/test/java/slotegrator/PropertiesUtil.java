package slotegrator;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

     public static  Properties loadProperties(Class clazz, String path) {
         Properties prop = new Properties();
 
         try(InputStream input = clazz.getResourceAsStream(path)){
             prop.load(input);
          }catch (IOException e){
             e.printStackTrace();
             System.exit(1);
          }
             return prop;
 
     }

}
