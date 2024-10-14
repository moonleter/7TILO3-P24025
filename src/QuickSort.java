public class QuickSort {
    private static int comparisons;

    public static <T extends Comparable<T>> void quickSort(T[] array, int begin, int end) {
        comparisons = 0;
        quickSortHelper(array, begin, end);
    }

    private static <T extends Comparable<T>> void quickSortHelper(T[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSortHelper(array, begin, partitionIndex - 1);
            quickSortHelper(array, partitionIndex + 1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int begin, int end) {
        T pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            comparisons++;
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        T swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }

    public static int getComparisons() {
        return comparisons;
    }
}