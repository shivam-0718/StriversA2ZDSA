package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

/*
    You have been given a sorted array/list of integers 'arr' of size 'n' and an integer 'x'.
    Find the total number of occurrences of 'x' in the array/list.
*/
public class BinarySearch7 {
    public static int countOccurrences(int[] arr, int n, int x) {
        int first = firstPositionOfX(arr, n, x) ;
        if (first == -1 || arr[first] != x) { // if element not found
            return 0;
        } else {
            int last = lastPositionOfX(arr, n, x);
            return last - first + 1; // number of occurrences = (last - first + 1)
        }
    }

    // finding the first occurrence of x and returning its index using standard binary search
    public static int firstPositionOfX(int[] arr, int n, int x) {
        int first = -1, low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid; // possible first occurrence found
                high = mid - 1; // moving left to check for earlier occurrences
            } else if (arr[mid] < x) {
                low = mid + 1; // move right if mid-value is smaller
            } else {
                high = mid - 1; // move right if mid-value is larger
            }
        }

        return first;
    }

    // finding the last occurrence of x and returning its index using standard binary search
    public static int lastPositionOfX(int[] arr, int n, int x) {
        int last = -1, low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                last = mid; // possible last occurrence found
                low = mid + 1; // move right to check for earlier occurrences
            } else if (arr[mid] < x) {
                high = mid - 1; // move left if mid-value is smaller
            } else {
                low = mid + 1; // move right if mid-value is larger
            }
        }

        return last;
    }
}
