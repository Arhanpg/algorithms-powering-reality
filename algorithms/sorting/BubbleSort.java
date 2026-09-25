import java.util.Arrays;

public class BubbleSort {

    // Bubble Sort moves the largest unsorted element
    // to the end during every pass.
    public static void main(String[] args) {

        int[] arr = {2, 5, 12, 5, 7, 8, 54};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {

            boolean swapped = false;

            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swap happened, the remaining array is already sorted.
            if (!swapped) {
                break;
            }
        }

        System.out.println("After sorting:  " + Arrays.toString(arr));
    }
}
