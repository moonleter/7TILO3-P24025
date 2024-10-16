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
            MixedData[] data1 = FileReader.readMixedDataFromFile("src/data1.txt");
            BigDecimal[] data2 = FileReader.readBigDecimalsFromFile("src/data2.txt");
            Character[] data3 = FileReader.readCharactersFromFile("src/data3.txt");

            System.out.println("=== Data from data1.txt ===");
            System.out.println("Before sorting:");
            System.out.println(Arrays.toString(data1));

            bubbleSort(data1, Comparator.naturalOrder());
            System.out.println("After sorting (BubbleSort):");
            System.out.println(Arrays.toString(data1));
            System.out.println("Comparisons (BubbleSort): " + getComparisons());

            System.out.println("\n=== Data from data2.txt ===");
            System.out.println("Before sorting");
            System.out.println(Arrays.toString(data2));

            bubbleSort(data2, Comparator.naturalOrder());
            System.out.println("After sorting (BubbleSort):");
            System.out.println(Arrays.toString(data2));
            System.out.println("Comparisons (BubbleSort): " + getComparisons());

            System.out.println("\n=== Data from data3.txt ===");
            System.out.println("Before sorting:");
            System.out.println(Arrays.toString(data3));

            bubbleSort(data3, Comparator.naturalOrder());
            System.out.println("After sorting (BubbleSort):");
            System.out.println(Arrays.toString(data3));
            System.out.println("Comparisons (BubbleSort): " + getComparisons());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}