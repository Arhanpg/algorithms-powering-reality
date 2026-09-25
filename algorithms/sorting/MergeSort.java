import java.util.Arrays;

public class MergeSort {

    // Divide the array until every part contains one element.
    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        // Merge the two sorted halves.
        conquer(arr, start, mid, end);
    }

    private static void conquer(int[] arr, int start, int mid, int end) {

        int[] merged = new int[end - start + 1];

        int left = start;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= end) {

            if (arr[left] <= arr[right]) {
                merged[index++] = arr[left++];
            } else {
                merged[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            merged[index++] = arr[left++];
        }

        while (right <= end) {
            merged[index++] = arr[right++];
        }

        for (int i = 0; i < merged.length; i++) {
            arr[start + i] = merged[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 6, 2, 6, 7, 1, 90, 4, 12, 9};

        divide(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
