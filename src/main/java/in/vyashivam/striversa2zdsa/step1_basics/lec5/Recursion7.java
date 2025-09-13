package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Reverse an array.
public class Recursion7 {
    //brute-force approach
    public static void reverse(int[] arr, int n) {
        int[] revArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            revArray[arr.length - 1 - i] = arr[i];
        }

        printArray(arr, arr.length);
        System.out.println();
        printArray(revArray, arr.length);
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //optimized approach
    public static void reverseArray(int n, int[] arr) {
        n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        printArray(arr, n);
    }

    //recursion approach - Good
    public static void revArray(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            revArray(arr, start + 1, end-1);
        }
    }
}
