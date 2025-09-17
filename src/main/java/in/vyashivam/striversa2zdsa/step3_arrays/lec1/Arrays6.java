package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.Arrays;

//Left-rotating an array and right-rotating an array by k places
public class Arrays6 {
    //Left-rotation
    //brute-force solution
    public static void rotateArrayLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n; //getting number of rotations

        //getting the number of variables upto k and storing in separate array
        int[] tempArray = new int[k];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = nums[i];
        }

        //shifting remaining elements to left by k places
        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        //put temp elements at the last of the same array
        for (int i = n - k; i < n; i++) {
             nums[i] = tempArray[i - (n - k)];
        }
    }

    //optimal solution
    public static void rotateArraysL(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //Right-rotation
    //brute-force solution
    public static void rotateArrayRight(int[] nums, int k) {
        int n = nums.length;
        k = k % n; //getting number of rotations

        //getting the number of variables upto k and storing in separate array
        int[] tempArray = new int[k];
        for(int i = 0; i < tempArray.length; i++) {
            tempArray[i] = nums[n - k + i];
        }

        //shifting remaining elements to left by k places
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        //put temp elements at the start elements of the same array
        for (int i = 0; i < k; i++) {
            nums[i] = tempArray[i];
        }
    }

    //optimal solution
    public static void rotateArraysR(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length - 1);
    }
}
