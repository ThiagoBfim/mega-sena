import com.google.common.collect.Sets;
import resultado.CalculadoraFileResultado;

import java.util.Set;

class CalcularResultadoJogo {

    public static void main(String[] args) {
        calcularJogos(Sets.newHashSet("4", "21", "27", "29", "42", "47"), "jogo1.txt");//2234
        calcularJogos(Sets.newHashSet("14", "18", "30", "35", "55", "57"), "jogo2.txt");//2235
        calcularJogos(Sets.newHashSet("7", "20", "38", "43", "45", "53"), "jogo3.txt");//2236
        calcularJogos(Sets.newHashSet("11", "20", "27", "28", "53", "60"), "jogo4.txt");//2237
        calcularJogos(Sets.newHashSet("7", "9", "10", "19", "25", "58"), "jogo5.txt");//2238
    }

    private static void calcularJogos(Set<String> numeros, String filePath) {
        CalculadoraFileResultado calculadoraQuartoJogo = new CalculadoraFileResultado(numeros, filePath);
        System.out.println(calculadoraQuartoJogo.calcularResultado().calcularPontos());
    }

}
