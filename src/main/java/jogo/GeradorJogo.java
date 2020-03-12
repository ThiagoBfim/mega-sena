package jogo;

import resultado.CalculadoraJogoResultado;
import resultado.Resultado;
import util.GlobalUtil;
import properties.JogoProperties;
import jogo.Jogo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class GeradorJogo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<Jogo> jogos = new HashSet<>();
        while (jogos.size() < JogoProperties.getQuantidadeJogosGerado()) {
            jogos.add(new Jogo());
        }
        GlobalUtil.calculateElapsedTime(start);

        CalculadoraJogoResultado calculadoraJogoResultado = new CalculadoraJogoResultado(Arrays.asList("01", "13", "18", "26", "40", "56"), jogos);
        Resultado resultado = calculadoraJogoResultado.calcularResultado();
        System.out.println(resultado.calcularPontos());
//        saveJogoInFile(jogos);
    }


}
