import java.util.*;

class InvalidIndexException extends Exception{
    InvalidIndexException(String mssg){
        super(mssg);
    }
}

public class ExchangeElement {
    public static <T> void exchange(T[] arr, int idx1, int idx2) throws Exception {
        if (idx1 < 0 || idx1 >= arr.length || idx2 < 0 || idx2 >= arr.length) {
            throw new InvalidIndexException("Invalid indices");
        }

        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) throws Exception {
        Integer[] nums = {1, 2, 3, 4, 5};
        System.out.println("Before exchange: " + Arrays.toString(nums));
        exchange(nums, 1, 3);
        System.out.println("After exchange: " + Arrays.toString(nums));


        String[] words = {"apple", "banana", "cherry", "date"};
        System.out.println("Before exchange: " + Arrays.toString(words));
        exchange(words, 0, 2);
        System.out.println("After exchange: " + Arrays.toString(words));
    }
}
