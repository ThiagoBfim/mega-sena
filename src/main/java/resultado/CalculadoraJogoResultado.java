package resultado;

import jogo.Jogo;

import java.util.Collection;
import java.util.Set;

public class CalculadoraJogoResultado extends AbstractCalculadoraResultado {

    private Set<Jogo> jogos;

    public CalculadoraJogoResultado(Set<Jogo> jogos) {
        this.jogos = jogos;
    }

    @Override
    protected Collection<Jogo> getData() {
        return jogos;
    }

}
