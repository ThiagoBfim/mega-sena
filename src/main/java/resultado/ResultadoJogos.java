package resultado;

import com.google.common.collect.Sets;

import java.util.Set;

class ResultadoJogos {

    public static void main(String[] args) {
        calcularJogos(Sets.newHashSet("4", "21", "27", "29", "42", "47"));//2234
        calcularJogos(Sets.newHashSet("14", "18", "30", "35", "55", "57"));//2235
        calcularJogos(Sets.newHashSet("7", "20", "38", "43", "45", "53"));//2236
        calcularJogos(Sets.newHashSet("11", "20", "27", "28", "53", "60"));//2237
        calcularJogos(Sets.newHashSet("7", "9", "10", "19", "25", "58"));//2238
    }

    private static void calcularJogos(Set<String> numeros) {
        CalculadoraFileResultado calculadoraQuartoJogo = new CalculadoraFileResultado(numeros);
        System.out.println(calculadoraQuartoJogo.calcularResultado().calcularPontos());
    }

}
