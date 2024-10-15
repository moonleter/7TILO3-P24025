import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort {
    private static int comparisons;

    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        comparisons = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                comparisons++;
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int getComparisons() {
        return comparisons;
    }

    public static void main(String[] args) {
        try {
            String[] names = FileReader.readStringsFromFile("src/data1.txt");
            BigDecimal[] values = FileReader.readBigDecimalsFromFile("src/data2.txt");
            Character[] characters = FileReader.readCharactersFromFile("src/data3.txt");

            System.out.println("=== Data from data1.txt ===");
            System.out.println("Before sorting names:");
            System.out.println(Arrays.toString(names));

            bubbleSort(names, Comparator.naturalOrder());
            System.out.println("After sorting names (BubbleSort):");
            System.out.println(Arrays.toString(names));
            System.out.println("String comparisons (BubbleSort): " + getComparisons());

            System.out.println("\n=== Data from data2.txt ===");
            System.out.println("Before sorting values:");
            System.out.println(Arrays.toString(values));

            bubbleSort(values, Comparator.naturalOrder());
            System.out.println("After sorting values (BubbleSort):");
            System.out.println(Arrays.toString(values));
            System.out.println("Comparisons (BubbleSort): " + getComparisons());

            System.out.println("\n=== Data from data3.txt ===");
            System.out.println("Before sorting characters:");
            System.out.println(Arrays.toString(characters));

            bubbleSort(characters, Comparator.naturalOrder());
            System.out.println("After sorting characters (BubbleSort):");
            System.out.println(Arrays.toString(characters));
            System.out.println("Comparisons (BubbleSort): " + getComparisons());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}