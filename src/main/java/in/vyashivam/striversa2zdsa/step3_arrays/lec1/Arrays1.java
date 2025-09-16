package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.Arrays;

//Finding the largest element in an array
public class Arrays1 {
    //brute-force solution
    public static int largestElement(int[] arr) {
        Arrays.sort(arr); //any sort technique can be used.
        return arr[arr.length - 1];
    }

    //optimal solution
    public static void maximumElement(int[] arr) {
        int largestElement = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }
    }
}
//link: https://www.naukri.com/code360/problems/largest-element-in-the-array-largest-element-in-the-array_5026279
