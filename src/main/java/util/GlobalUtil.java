package util;

import properties.FileProperties;
import jogo.Jogo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

public class GlobalUtil {

    public static void calculateElapsedTime(long start) {
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        float elapsedTimeSec = elapsedTimeMillis / 1000F;
        System.out.println(String.format("Levou %s segundos", elapsedTimeSec));
        System.out.println(String.format("Levou %.2f minutos", elapsedTimeSec / 60));
    }

    public static void saveJogoInFile(Set<Jogo> jogos) throws FileNotFoundException {
        String fileName =  FileProperties.getLocationSave();
        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(jogos.toString());
        }
    }
}
