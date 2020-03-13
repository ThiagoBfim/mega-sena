package jogo;

import properties.JogoProperties;

import java.util.stream.Stream;

public enum JogoType {
    ZERO(0),
    UM(1),
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5),
    SEIS(6);

    long quantidadeAcertos;

    JogoType(long quantidadeAcertos) {
        this.quantidadeAcertos = quantidadeAcertos;
    }

    public static JogoType getByQuantidadeAcertos(final long quantidadeAcertos) {
        return Stream.of(values())
                .filter(j -> j.getQuantidadeAcertos() == quantidadeAcertos)
                .findFirst()
                .orElse(null);
    }

    public long getQuantidadeAcertos() {
        return quantidadeAcertos;
    }

    public double getPrize() {
        switch (this) {
            case UM:
                return 4;
            case DOIS:
                return 8;
            case TRES:
                return 16;
            case QUATRO:
                return JogoProperties.getPremioQuadra();
            case CINCO:
                return JogoProperties.getPremioQuina();
            case SEIS:
                return JogoProperties.getPremioSena();
            default:
                return 0;
        }
    }
}
