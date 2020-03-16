package resultado;

import jogo.Jogo;
import org.apache.commons.lang3.StringUtils;
import properties.FileProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CalculadoraFileResultado extends AbstractCalculadoraResultado {

    private Set<String> resultJogo;
    private String fileName;
    private String delimitador;

    public CalculadoraFileResultado(String delimitador) {
        this.delimitador = delimitador;
        this.fileName = FileProperties.getCaminhoCarregarArquivo();
    }

    public CalculadoraFileResultado(Set<String> resultJogo, String fileName) {
        this.resultJogo = resultJogo;
        this.fileName = fileName;
    }

    @Override
    public Set<String> getResultadoJogo() {
        if(resultJogo != null) {
            return resultJogo;
        }
        return super.getResultadoJogo();
    }

    @Override
    protected String getDelimitadorNumerosSorteio() {
        if(StringUtils.isNotEmpty(delimitador)) {
         return delimitador;
        }
        return super.getDelimitadorNumerosSorteio();
    }

    @Override
    protected Collection<Jogo> getData() {
        return retriveData();
    }

    public Collection<Jogo> retriveData() {
        try {
            Scanner myReader = loadFile();
            Set<Jogo> jogos = new HashSet<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                jogos.add(new Jogo(data));
            }
            myReader.close();
            return jogos;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return Collections.emptyList();

    }

    private Scanner loadFile() throws FileNotFoundException {
        File myObj = new File(fileName);
        return new Scanner(myObj);
    }

}
