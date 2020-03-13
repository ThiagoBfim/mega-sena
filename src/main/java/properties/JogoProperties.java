package properties;

public class JogoProperties {

    private static final String ROOT_PROPERTY = "jogo.";

    public static Integer getQuantidadeNumeroPorJogos(){
        return PropertiesHelper.getIntegerProperty(ROOT_PROPERTY + "quantidade_numero_por_jogo");
    }

    public static Integer getQuantidadeJogosGerado(){
        return PropertiesHelper.getIntegerProperty(ROOT_PROPERTY + "quantidade_jogos_gerado");
    }

    public static Double getPrizeFour(){
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "prize_four");
    }

    public static Double getPrizeFive(){
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "prize_five");
    }

    public static Double getPrizeSix(){
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "prize_six");
    }

    public static Integer getMinQtdAcertosAceito(){
        return PropertiesHelper.getIntegerProperty(ROOT_PROPERTY + "min_qtd_acertos");
    }

    public static String getResultJogo(){
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "result");
    }

    public static Double getPriceJogo(){
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "price");
    }

}
