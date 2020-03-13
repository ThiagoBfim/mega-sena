import jogo.Jogo;
import org.apache.commons.lang3.StringUtils;
import properties.FileProperties;
import properties.JogoProperties;
import resultado.CalculadoraJogoResultado;
import resultado.Resultado;
import util.GlobalUtil;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

class GeradorJogo {

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        Set<Jogo> jogos = generateJogos();
        GlobalUtil.calculateElapsedTime(start);

        Resultado resultado = new CalculadoraJogoResultado(jogos)
                .calcularResultado();
        double valorGasto = JogoProperties.getPriceJogo() * jogos.size();
        System.out.println("Ganho: R$: " + NumberFormat.getCurrencyInstance().format(resultado.calcularPontos()));
        System.out.println("Gasto: R$: " + NumberFormat.getCurrencyInstance().format(valorGasto));
        System.out.println("Lucro: R$: " + NumberFormat.getCurrencyInstance().format(resultado.calcularPontos() - valorGasto));
        if (StringUtils.isNoneBlank(FileProperties.getLocationSave())) {
            GlobalUtil.saveJogoInFile(jogos);
        }
    }

    private static Set<Jogo> generateJogos() {
        Set<Jogo> jogos = new HashSet<>();
        while (jogos.size() < JogoProperties.getQuantidadeJogosGerado()) {
            jogos.add(new Jogo());
        }
        return jogos;
    }


}
