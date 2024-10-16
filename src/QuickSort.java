import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * QuickSort implementation
 * Selects pivot as the last element
 */
public class QuickSort {
    private static int comparisons;

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        comparisons = 0;
        quickSortHelper(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHelper(T[] array, int first, int last) {
        if (first < last) {
            int pi = partition(array, first, last);
            quickSortHelper(array, first, pi - 1);
            quickSortHelper(array, pi + 1, last);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int first, int last) {
        T pivot = array[last]; // Pivot is selected as the last element
        int i = first - 1;
        for (int j = first; j < last; j++) {
            comparisons++;
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, last);
        return i + 1;
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

            quickSort(data1);
            System.out.println("After sorting (QuickSort):");
            System.out.println(Arrays.toString(data1));
            System.out.println("Comparisons (QuickSort): " + getComparisons());

            System.out.println("\n=== Data from data2.txt ===");
            System.out.println("Before sorting:");
            System.out.println(Arrays.toString(data2));

            quickSort(data2);
            System.out.println("After sorting (QuickSort):");
            System.out.println(Arrays.toString(data2));
            System.out.println("Comparisons (QuickSort): " + getComparisons());

            System.out.println("\n=== Data from data3.txt ===");
            System.out.println("Before sorting:");
            System.out.println(Arrays.toString(data3));

            quickSort(data3);
            System.out.println("After sorting (QuickSort):");
            System.out.println(Arrays.toString(data3));
            System.out.println("Comparisons (QuickSort): " + getComparisons());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}