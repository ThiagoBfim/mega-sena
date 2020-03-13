package resultado;

import jogo.JogoType;
import properties.JogoProperties;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;

public class Resultado {

    private Map<JogoType, Integer> resultadoJogos = new LinkedHashMap<>();

    public Resultado() {
        resultadoJogos.put(JogoType.ZERO, 0);
        resultadoJogos.put(JogoType.UM, 0);
        resultadoJogos.put(JogoType.DOIS, 0);
        resultadoJogos.put(JogoType.TRES, 0);
        resultadoJogos.put(JogoType.QUATRO, 0);
        resultadoJogos.put(JogoType.CINCO, 0);
        resultadoJogos.put(JogoType.SEIS, 0);
    }

    Map<JogoType, Integer> getResultadoJogos() {
        return resultadoJogos;
    }

    void addResult(long count) {
        JogoType jogo = JogoType.getByQuantidadeAcertos(count);
        getResultadoJogos().merge(jogo, 1, Integer::sum);
    }

    public double calcularPreco() {
        DoubleAdder somaPreco = new DoubleAdder();
        this.getResultadoJogos()
                .forEach((k, v) -> somaPreco.add(k.getPrize() * v));
        return somaPreco.doubleValue();
    }

    @Override
    public String toString() {
        StringBuilder resultadoFormatado = new StringBuilder("Resultado: ");
        resultadoJogos.forEach((k, v) -> {
            if (k.getQuantidadeAcertos() >= JogoProperties.getMinQtdAcertosAceito()) {
                resultadoFormatado.append(k).append(" = ").append(v).append(" | ");
            }
        });
        return resultadoFormatado.toString();
    }
}
