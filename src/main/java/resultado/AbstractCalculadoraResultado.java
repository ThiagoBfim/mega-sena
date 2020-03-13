package resultado;

import jogo.Jogo;
import properties.FileProperties;
import properties.JogoProperties;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractCalculadoraResultado {
    private final Resultado resultado = new Resultado();

    protected abstract Collection<Jogo> getData();

    public final Resultado calcularResultado() {
        final String delimitador = FileProperties.getSeparadorNumeros();
        calculateResult(getData(), delimitador);
        System.out.println(resultado);
        return resultado;
    }

    protected Set<String> getResultadoJogo() {
        return Stream.of(JogoProperties.getResultadoJogo().split(","))
                .collect(Collectors.toSet());
    }

    private void calculateResult(Collection<Jogo> jogos, String delimitador) {
        Set<String> resultJogo = getResultadoJogo();
        jogos.forEach(jogo -> {
            long count = Stream.of(splitJogoToNumbers(delimitador, jogo))
                    .filter(d -> resultJogo.contains(d.trim()))
                    .count();
            if (count >= JogoProperties.getMinQtdAcertosAceito()) {
                resultado.addResult(count);
            }
        });
    }

    private String[] splitJogoToNumbers(String delimitador, Jogo jogo) {
        return jogo.toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "").split(delimitador);
    }

}
