package properties;

public class JogoProperties {

    private static final String ROOT_PROPERTY = "jogo.";

    public static Integer getQuantidadeNumeroPorJogos() {
        return PropertiesHelper.getIntegerProperty(ROOT_PROPERTY + "quantidade_numero_por_jogo");
    }

    public static Integer getQuantidadeJogosGerado() {
        return PropertiesHelper.getIntegerProperty(ROOT_PROPERTY + "quantidade_jogos_gerado");
    }

    public static Double getPremioQuadra() {
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "premio_quadra");
    }

    public static Double getPremioQuina() {
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "premio_quina");
    }

    public static Double getPremioSena() {
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "premio_sena");
    }

    public static Integer getMinQtdAcertosAceito() {
        return PropertiesHelper.getIntegerProperty(ROOT_PROPERTY + "min_qtd_acertos");
    }

    public static String getResultadoJogo() {
        return PropertiesHelper.getStringProperty(ROOT_PROPERTY + "resultado");
    }

    public static Double getPrecoJogo() {
        return PropertiesHelper.getDoubleProperty(ROOT_PROPERTY + "preco");
    }

}
