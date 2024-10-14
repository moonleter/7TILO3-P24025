public class BubbleSort {

    public static <T extends Comparable<T>> int bubbleSort(T[] array) {
        int comparisons = 0;
        while (true) {
            boolean sorted = moveRight(array);
            comparisons += sorted ? 0 : array.length - 1;
            sorted &= moveLeft(array);
            comparisons += sorted ? 0 : array.length - 1;

            if (sorted)
                break;
        }
        return comparisons;
    }

    private static <T extends Comparable<T>> boolean moveRight(T[] array) {
        boolean sorted = true;
        for (int i = 0, j = 1; j < array.length; i++, j++) {
            if (array[i].compareTo(array[j]) > 0) {
                sorted = false;
                swap(array, i, j);
            }
        }
        return sorted;
    }

    private static <T extends Comparable<T>> boolean moveLeft(T[] array) {
        boolean sorted = true;
        for (int j = array.length - 1, i = j - 1; i >= 0; i--, j--) {
            if (array[i].compareTo(array[j]) > 0) {
                sorted = false;
                swap(array, i, j);
            }
        }
        return sorted;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}