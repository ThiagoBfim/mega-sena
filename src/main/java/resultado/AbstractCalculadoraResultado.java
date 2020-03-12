package resultado;

import jogo.Jogo;
import properties.FileProperties;
import properties.JogoProperties;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractCalculadoraResultado {
    private final Resultado resultado = new Resultado();
    private final List<String> numeros;

    public AbstractCalculadoraResultado(List<String> numeros) {
        this.numeros = numeros;
    }

    public final Resultado calcularResultado() {
        final String delimitador = FileProperties.getDelimiterSeparator();
        calculateResult(getData(), delimitador);
        System.out.println(resultado);
        return resultado;
    }

    protected abstract Collection<Jogo> getData();

    private void calculateResult(Collection<Jogo> jogos, String delimitador) {
        jogos.forEach(jogo -> {
            long count = Stream.of(splitJogoToNumbers(delimitador, jogo))
                    .filter(d -> numeros.contains(d.trim()))
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
