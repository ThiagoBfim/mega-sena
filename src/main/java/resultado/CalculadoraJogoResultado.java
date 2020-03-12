package resultado;

import jogo.Jogo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CalculadoraJogoResultado extends AbstractCalculadoraResultado {

    private Set<Jogo> jogos;

    public CalculadoraJogoResultado(List<String> numeros, Set<Jogo> jogos) {
        super(numeros);
        this.jogos = jogos;
    }

    @Override
    protected Collection<Jogo> getData() {
        return jogos;
    }


}
