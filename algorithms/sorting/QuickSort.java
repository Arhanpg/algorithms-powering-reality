import java.util.Arrays;

public class QuickSort {

    // Recursively sorts the sub-arrays created by partitioning.
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIndex = partition(arr, start, end);

        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    // Places the pivot in its final sorted position.
    // This implementation uses the first element as the pivot.
    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i <= j) {

            while (i <= end && arr[i] <= pivot) {
                i++;
            }

            while (j >= start && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // Put the pivot between the two partitions.
        arr[start] = arr[j];
        arr[j] = pivot;

        return j;
    }

    public static void main(String[] args) {

        int[] arr = {7, 43, 2, 7, 8, 32, 2, 2, 7, 9, 6, 1, 0};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
