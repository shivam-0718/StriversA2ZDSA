package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.Arrays;

//Finding the second-largest and second-smallest element in an array
public class Arrays2 {
    //First-half
    //brute-force solution
    public static int secondLargestElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    //better solution
    public static int secondMaxElement(int[] arr) {
        //find largest element
        int largestElement = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }

        //find second-largest element
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > secondLargest && arr[i] != largestElement) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    //optimal solution
    public static int secondMaximumElement(int[] arr) {
        int max = arr[0];
        int secondMax = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }


    //Second-half
    //brute-force solution
    public static int secondSmallestElement(int[] arr) {
        Arrays.sort(arr);
        return arr[1];
    }

    //better solution
    public static int secondMinElement(int[] arr) {
        int smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        int secondSmallest = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    //optimal solution
    public static int secondMinimumElement(int[] arr) {
        int min = arr[0];
        int secondMin = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] > min && arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }
}

