package properties;

public class FileProperties {

    private static final String ROOT_PROPERTY = "file.";

    public static String getSeparadorNumeros(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "separador_numeros");
    }

    public static String getCaminhoSalvarArquivo(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "caminho_salvar_arquivo");
    }

    public static String getCaminhoCarregarArquivo(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "caminho_carregar_arquivo");
    }

}
