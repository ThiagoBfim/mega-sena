package properties;

public class FileProperties {

    private static final String ROOT_PROPERTY = "file.";

    public static String getDelimiterSeparator(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "delimiter_separator");
    }

    public static String getLocationSave(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "location_save");
    }

    public static String getLocationLoad(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "location_load");
    }

}
