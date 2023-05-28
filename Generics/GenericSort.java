import java.util.*;

public class GenericSort<T extends Comparable<T>> {

    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArr = { 5, 2, 8, 1, 3 };
        GenericSort<Integer> intSorter = new GenericSort<>();
        intSorter.sort(intArr);
        System.out.println("Sorted Integer array: " + Arrays.toString(intArr));

        // Test with Float array
        Float[] floatArr = { 3.5f, 1.2f, 6.7f, 2.8f, 4.9f };
        GenericSort<Float> floatSorter = new GenericSort<>();
        floatSorter.sort(floatArr);
        System.out.println("Sorted Float array: " + Arrays.toString(floatArr));
    }
}

