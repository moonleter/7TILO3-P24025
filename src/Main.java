import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // TODO: fix složiitosti
        try {
            String[] names = FileReader.readStringsFromFile("src/data1.txt");
            BigDecimal[] values = FileReader.readBigDecimalsFromFile("src/data2.txt");
            Character[] characters = FileReader.readCharactersFromFile("src/data3.txt");

            System.out.println("=== Data from data1.txt ===");
            System.out.println("Before sorting names:");
            for (String name : names) {
                System.out.print(name + " ");
            }
            System.out.println();

            int comparisons = BubbleSort.bubbleSort(names);
            System.out.println("After sorting names (BubbleSort):");
            for (String name : names) {
                System.out.print(name + " ");
            }
            System.out.println();
            System.out.println("String comparisons (BubbleSort): " + comparisons);

            QuickSort.quickSort(names, 0, names.length - 1);
            System.out.println("After sorting names (QuickSort):");
            for (String name : names) {
                System.out.print(name + " ");
            }
            System.out.println();
            System.out.println("String comparisons (QuickSort): " + QuickSort.getComparisons());

            MergeSort.mergeSort(names, 0, names.length - 1);
            System.out.println("After sorting names (MergeSort):");
            for (String name : names) {
                System.out.print(name + " ");
            }
            System.out.println();
            System.out.println("String comparisons (MergeSort): " + MergeSort.getComparisons());

            System.out.println("\n=== Data from data2.txt ===");
            System.out.println("Before sorting values:");
            for (BigDecimal value : values) {
                System.out.print(value + " ");
            }
            System.out.println();

            comparisons = BubbleSort.bubbleSort(values);
            System.out.println("After sorting values (BubbleSort):");
            for (BigDecimal value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.println("Comparisons (BubbleSort): " + comparisons);

            QuickSort.quickSort(values, 0, values.length - 1);
            System.out.println("After sorting values (QuickSort):");
            for (BigDecimal value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.println("Comparisons (QuickSort): " + QuickSort.getComparisons());

            MergeSort.mergeSort(values, 0, values.length - 1);
            System.out.println("After sorting values (MergeSort):");
            for (BigDecimal value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.println("Comparisons (MergeSort): " + MergeSort.getComparisons());

            System.out.println("\n=== Data from data3.txt ===");
            System.out.println("Before sorting characters:");
            for (Character ch : characters) {
                System.out.print(ch + " ");
            }
            System.out.println();

            comparisons = BubbleSort.bubbleSort(characters);
            System.out.println("After sorting characters (BubbleSort):");
            for (Character ch : characters) {
                System.out.print(ch + " ");
            }
            System.out.println();
            System.out.println("Comparisons (BubbleSort): " + comparisons);

            QuickSort.quickSort(characters, 0, characters.length - 1);
            System.out.println("After sorting characters (QuickSort):");
            for (Character ch : characters) {
                System.out.print(ch + " ");
            }
            System.out.println();
            System.out.println("Comparisons (QuickSort): " + QuickSort.getComparisons());

            MergeSort.mergeSort(characters, 0, characters.length - 1);
            System.out.println("After sorting characters (MergeSort):");
            for (Character ch : characters) {
                System.out.print(ch + " ");
            }
            System.out.println();
            System.out.println("Comparisons (MergeSort): " + MergeSort.getComparisons());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}