package resultado;

import java.util.Arrays;
import java.util.List;

class ResultadoJogos {

    public static void main(String[] args) {
        calcularJogos(Arrays.asList("4", "21", "27", "29", "42", "47"));//2234
        calcularJogos(Arrays.asList("14", "18", "30", "35", "55", "57"));//2235
        calcularJogos(Arrays.asList("7", "20", "38", "43", "45", "53"));//2236
        calcularJogos(Arrays.asList("11", "20", "27", "28", "53", "60"));//2237
        calcularJogos(Arrays.asList("7", "9", "10", "19", "25", "58"));//2238
    }

    private static void calcularJogos(List<String> numeros) {
        CalculadoraFileResultado calculadoraQuartoJogo = new CalculadoraFileResultado(
                numeros);
        System.out.println(calculadoraQuartoJogo.calcularResultado().calcularPontos());
    }

}
