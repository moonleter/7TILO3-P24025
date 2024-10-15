import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

public class MergeSort {
    private static int comparisons;

    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        comparisons = 0;
        T[] aux = array.clone();
        mergeSortHelper(array, aux, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSortHelper(T[] array, T[] aux, int left, int right) {
        if (left >= right) return;
        int middleIndex = (left + right) / 2;
        mergeSortHelper(array, aux, left, middleIndex);
        mergeSortHelper(array, aux, middleIndex + 1, right);
        merge(array, aux, left, right);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] aux, int left, int right) {
        int middleIndex = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = middleIndex + 1;
        int auxIndex = left;

        for (int i = left; i <= right; i++) {
            aux[i] = array[i];
        }

        while (leftIndex <= middleIndex && rightIndex <= right) {
            comparisons++;
            if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                array[auxIndex++] = aux[leftIndex++];
            } else {
                array[auxIndex++] = aux[rightIndex++];
            }
        }

        while (leftIndex <= middleIndex) {
            array[auxIndex++] = aux[leftIndex++];
        }

        while (rightIndex <= right) {
            array[auxIndex++] = aux[rightIndex++];
        }
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

            mergeSort(names);
            System.out.println("After sorting names (MergeSort):");
            System.out.println(Arrays.toString(names));
            System.out.println("String comparisons (MergeSort): " + getComparisons());

            System.out.println("\n=== Data from data2.txt ===");
            System.out.println("Before sorting values:");
            System.out.println(Arrays.toString(values));

            mergeSort(values);
            System.out.println("After sorting values (MergeSort):");
            System.out.println(Arrays.toString(values));
            System.out.println("Comparisons (MergeSort): " + getComparisons());

            System.out.println("\n=== Data from data3.txt ===");
            System.out.println("Before sorting characters:");
            System.out.println(Arrays.toString(characters));

            mergeSort(characters);
            System.out.println("After sorting characters (MergeSort):");
            System.out.println(Arrays.toString(characters));
            System.out.println("Comparisons (MergeSort): " + getComparisons());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}