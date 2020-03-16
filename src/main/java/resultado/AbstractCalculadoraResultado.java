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
        calculateResult(getData());
        System.out.println(resultado);
        return resultado;
    }

    protected String getDelimitadorNumerosSorteio() {
        return FileProperties.getSeparadorNumeros();
    }
    protected Set<String> getResultadoJogo() {
        return Stream.of(JogoProperties.getResultadoJogo().split(","))
                .map(String::trim)
                .map(this::removeZeroIfsFirst)
                .collect(Collectors.toSet());
    }

    private String removeZeroIfsFirst(String s) {
        if('0' == s.charAt(0)){
            return s.replaceFirst("0", "");
        }
        return s;
    }

    private void calculateResult(Collection<Jogo> jogos) {
        final String delimitador = getDelimitadorNumerosSorteio();
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
