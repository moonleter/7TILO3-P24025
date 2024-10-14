import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static String[] readStringsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("; ");
            for (String part : parts) {
                list.add(part);
            }
        }
        reader.close();
        return list.toArray(new String[0]);
    }

    public static BigDecimal[] readBigDecimalsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
        List<BigDecimal> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("; ");
            for (String part : parts) {
                list.add(new BigDecimal(part));
            }
        }
        reader.close();
        return list.toArray(new BigDecimal[0]);
    }

    public static Character[] readCharactersFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
        List<Character> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            for (char ch : line.toCharArray()) {
                list.add(ch);
            }
        }
        reader.close();
        return list.toArray(new Character[0]);
    }
}