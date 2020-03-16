import com.google.common.collect.Sets;
import resultado.CalculadoraFileResultado;

class CalcularResultadoJogo {

    public static void main(String[] args) {
        System.out.println(new CalculadoraFileResultado(",")
                .calcularResultado()
                .calcularPreco());

        System.out.println(new CalculadoraFileResultado(Sets.newHashSet("1","2","3","4","5","6"),
                "./jogo1.txt")
                .calcularResultado()
                .calcularPreco());
    }

}
