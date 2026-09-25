import java.util.Arrays;

public class InsertionSort {

    // Insertion Sort keeps the left side sorted and inserts
    // the current element into its correct position.
    public static void main(String[] args) {

        int[] arr = {4, 63, 7, 2, 7, 9, 1, 65, 8};

        for (int i = 1; i < arr.length; i++) {

            int j = i;

            // Move the current element left while it is
            // smaller than the element before it.
            while (j > 0 && arr[j - 1] > arr[j]) {

                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
