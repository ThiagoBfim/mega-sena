package jogo;

import properties.JogoProperties;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Jogo {

    private StringBuilder jogoHash = new StringBuilder();

    public Jogo() {
        generateJogo();
    }
    public Jogo(String jogo) {
        this.jogoHash.append(jogo);
    }

    private void generateJogo() {
        Set<Integer> jogo = new HashSet<>();
        while (jogo.size() < JogoProperties.getQuantidadeNumeroPorJogos()) {
            jogo.add(new Random().nextInt(60) + 1);
        }
        jogo
                .stream()
                .sorted()
                .forEach(numero -> jogoHash.append(numero).append(","));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogo)) return false;
        Jogo jogo = (Jogo) o;
        return jogoHash.toString().contentEquals(jogo.jogoHash);
    }

    @Override
    public int hashCode() {
        return jogoHash.hashCode();
    }

    @Override
    public String toString() {
        return jogoHash + "\n";
    }
}
