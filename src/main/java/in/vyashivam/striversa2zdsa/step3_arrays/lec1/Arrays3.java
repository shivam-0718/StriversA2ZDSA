package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.List;

//Check whether a given array is sorted or not
public class Arrays3 {
    //brute-force solution
    public static boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] <= arr[i+1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isArraySorted(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i) <= arr.get(i+1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
//link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
//This will be solved separately.
