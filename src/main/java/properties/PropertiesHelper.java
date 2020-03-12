package properties;

public class PropertiesHelper {


    public static Integer getIntegerProperty(String property){
        return Integer.valueOf(PropertiesSearch.getInstance().getProperty(property));
    }

    public static Double getDoubleProperty(String property){
        return Double.valueOf(PropertiesSearch.getInstance().getProperty(property));
    }

    public static String getStringProperty(String property){
        return PropertiesSearch.getInstance().getProperty(property);
    }

}
