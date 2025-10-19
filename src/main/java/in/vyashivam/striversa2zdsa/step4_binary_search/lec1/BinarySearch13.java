package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;
/*
    Given an array arr of integers. A peak element is defined as an element greater than both of its neighbors.
    Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i] => arr[i - 1] < arr[i] > arr[i + 1].
    Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
*/
public class BinarySearch13 {
    // brute-force solution
    public static int findAPeakElement(int[] arr) {
        int ans = -1, n = arr.length;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i-1] < arr[i]) && (i == n - 1 || arr[i] > arr[i + 1])) { // found the peak element
                ans = i;
                break;
            }
        }
        return ans;
    }

    // optimal solution
    public static int findPeakElement(int[] nums) {
        int ans = -1;
        int n = nums.length;

        //edge cases
        if (n == 1) {
            return 0; // edge case: one element in array
        } else if (nums[0] > nums[1]) {
            return 0; // edge case: first element is peak element
        } else if (nums[n - 1] > nums[n - 2]) {
            return n - 1; // edge case: last element is peak element
        }

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid - 1] < nums[mid]) { // found a peak element
                ans = mid;
                break;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1; // peak element is on the left -> moving to the left
            } else if (nums[mid - 1] < nums[mid]) {
                low = mid - 1; // peak element is on the right -> moving to the right
            } else {
                high = mid - 1; // for multiple peak element -> moving left / right is fine -> for this, moving to left
            }
        }

        return ans;
    }
}
//link: https://leetcode.com/problems/find-peak-element/description/
// link2: https://www.naukri.com/code360/problems/find-peak-element_1081482
