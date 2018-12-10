package forProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
    private static InputStream inputStream = null;
    private static String path;
    private static Properties property = new Properties();
    public static String getPropertyValue() throws IOException {
        try{
            inputStream = new FileInputStream("src\\main\\resources\\config.properties");
            property.load(inputStream);
            path = property.getProperty("relativePath");
        }catch(IOException ex){
            ex.printStackTrace();
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return path;
    }
}
