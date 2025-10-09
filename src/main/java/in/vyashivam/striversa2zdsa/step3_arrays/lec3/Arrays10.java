package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

/*
    Given an integer array nums. Return the number of inversions in the array.

    Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
    It indicates how close an array is to being sorted.
    A sorted array has an inversion count of 0.
    An array sorted in descending order has maximum inversion.
*/

import java.util.ArrayList;
import java.util.List;

public class Arrays10 {
    //brute-force solution
    public static long numberOfInversions(int[] nums) {
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(i < j && nums[i] > nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    //optimal solution

    // Function to be called externally — counts total inversions in array
    public static int numberOfInversionPairs(int []a, int n) {
        // Start the merge sort process and return total inversion count
        return mergeSort(a, 0, n-1);
    }

    //Recursive merge sort function that also counts inversions
    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0; // Local count for this subarray (instead of global)

        // Base condition — when subarray has 1 or 0 elements
        if(low >= high) {
            return count; //when subarray has one element, return 0 -> no inversions
        }

        int mid = (low + high) / 2;

        // Count inversions in the left half
        count += mergeSort(arr, low, mid);

        // Count inversions in the right half
        count += mergeSort(arr, mid + 1, high);

        // Count inversions while merging both halves
        count += merge(arr, low, mid, high);

        return count; // Returning total inversions from this part of recursion
    }

    // Merge function — merges two sorted halves and counts cross-inversions
    private static int merge(int[] arr, int low, int mid, int high) {
        int count = 0; // Local count for inversions found during merge
        List<Integer> temp = new ArrayList<>(); //Temporary list to store elements in the sorted order
        int left = low; // pointer for left half
        int right = mid + 1; // pointer for right half

        // Merge both halves while counting inversions
        while ((left <= mid) && (right <= high)) {

            // No inversion when left element <= right element
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            // Inversion found — element in right half smaller than left half
            else {
                //As left element is greater, remaining left elements are also greater than that specific right element
                // Number of inversions = all remaining elements in left half
                count += (mid - left + 1);
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements from right half (if any)
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements from right half (if any)
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy merged elements back into the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        // Return total inversions counted during this merge
        return count;
    }

    /*
        -> mergeSort() ->  divides and adds inversion counts from left, right, and merge parts.
        -> merge() ->  counts cross-inversions between left and right subarrays.
        -> Each call returns its own count, and recursion adds them all up, replacing the need for a global counter.
        -> Once recursion ends, the top-level call returns the final inversion count.
    */
}
//link: https://www.naukri.com/code360/problems/number-of-inversions_6840276
