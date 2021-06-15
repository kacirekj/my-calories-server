package kacirekj.calories.util;

import java.io.InputStream;

public class FileUtil {
    public static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    public static String getPropertyFileAsString(String profile) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application-" + profile + ".yaml");
        return convertStreamToString(inputStream);
    }
    
    public static String resource(String resourceName) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
        return convertStreamToString(inputStream);
    }
}
