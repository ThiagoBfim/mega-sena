package resultado;

import jogo.Jogo;
import properties.FileProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CalculadoraFileResultado extends AbstractCalculadoraResultado {

    private Set<String> resultJogo;
    private String fileName;

    public CalculadoraFileResultado(Set<String> resultJogo) {
        this(resultJogo, FileProperties.getLocationLoad());
    }

    public CalculadoraFileResultado(Set<String> resultJogo, String fileName) {
        this.resultJogo = resultJogo;
        this.fileName = fileName;
    }

    @Override
    public Set<String> getResultJogo() {
        return resultJogo;
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

    @Override
    protected Collection<Jogo> getData() {
        return retriveData();
    }

}
