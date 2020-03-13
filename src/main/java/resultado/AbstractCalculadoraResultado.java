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

    public final Resultado calcularResultado() {
        final String delimitador = FileProperties.getDelimiterSeparator();
        calculateResult(getData(), delimitador);
        System.out.println(resultado);
        return resultado;
    }

    protected abstract Collection<Jogo> getData();

    private void calculateResult(Collection<Jogo> jogos, String delimitador) {
        Set<String> resultJogo = getResultJogo();
        jogos.forEach(jogo -> {
            long count = Stream.of(splitJogoToNumbers(delimitador, jogo))
                    .filter(d -> resultJogo.contains(d.trim()))
                    .count();
            if (count >= JogoProperties.getMinQtdAcertosAceito()) {
                resultado.addResult(count);
            }
        });
    }

    public Set<String> getResultJogo() {
        return Stream.of(JogoProperties.getResultJogo().split(","))
                .collect(Collectors.toSet());
    }

    private String[] splitJogoToNumbers(String delimitador, Jogo jogo) {
        return jogo.toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "").split(delimitador);
    }

}
