import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

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

    public static MixedData[] readMixedDataFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
        List<MixedData> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("; ");
            for (String part : parts) {
                if (part.matches("\\d+")) {
                    list.add(new MixedData(Integer.parseInt(part)));
                } else {
                    list.add(new MixedData(part));
                }
            }
        }
        reader.close();
        return list.toArray(new MixedData[0]);
    }
}