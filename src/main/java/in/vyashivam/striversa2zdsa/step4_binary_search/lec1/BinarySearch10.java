package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

import java.util.ArrayList;

/*
    Given an integer array nums of size N, sorted in ascending order with distinct values,
    and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.

    Follow up: Find the minimum element in the rotated sorted array that may contain duplicates.
*/
public class BinarySearch10 {
    //Part i
    //brute-force solution
    public static int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    //optimal solution
    public static int findMinimum(int []arr) {
        int ans = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // finding the mid-index

            if (arr[low] <= arr[high]) { // if whole array is sorted
                ans = Math.min(ans, arr[low]); // smallest element will be the first element i.e. arr[low]
                break;
            }

            //checking the sorted portion
            if (arr[low] <= arr[mid]) { // left portion is sorted
                ans = Math.min(ans, arr[low]); // smallest element is arr[low], and eliminate the left portion
                low = mid + 1;
            } else { // right portion is sorted
                ans = Math.min(ans, arr[mid]); // smallest element is arr[mid], and eliminate the right portion
                high = mid - 1;
            }
        }
        return ans;
    }

    //Part ii
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        // Binary search approach to find minimum in rotated sorted array (with duplicates)
        while (low < high) {
            int mid = (low + high) / 2;

            // CASE 1: Right half is unsorted (pivot/minimum lies on right)
            // Example: [4,5,6,1,2] → mid > high → go right
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }

            // CASE 2: Right half is sorted → pivot lies in left half (including mid)
            // Example: [3,4,5,1,2] → mid < high → go left
            else if (nums[mid] < nums[high]) {
                high = mid;
            }

            // CASE 3: nums[mid] == nums[high]
            // Duplicates make it unclear which side is unsorted.
            // Safely shrink the search space by reducing high.
            else {
                high--;
            }
        }

        // When low == high, we've found the minimum element
        return nums[low];
    }

}
//link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
//link2: https://www.naukri.com/code360/problems/rotated-array_1093219
//link3: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
