import java.util.Arrays;

public class SelectionSort {

    // Selection Sort finds the smallest element in the
    // unsorted part and places it at the current position.
    public static void main(String[] args) {

        int[] arr = {5, 32, 6, 1, 2, 8, 6};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println("After sorting:  " + Arrays.toString(arr));
    }
}
