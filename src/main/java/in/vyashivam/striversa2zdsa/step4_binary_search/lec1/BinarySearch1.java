package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

/*
    Given an array of integers nums which is sorted in ascending order, and an integer target,
    write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    Use Binary Search algorithm which uses the time complexity of O(log n)
*/
public class BinarySearch1 {
    //Iterative approach
    public static int searchANumber(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // find middle index

            if(nums[mid] == target) {
                return mid; // return mid-index if element found
            } else if (nums[mid] > target) { // target on left side
                high = mid - 1;
            } else {
                low = mid - 1; // target on right side
            }
        }

        return -1; //if element is not there in the array
    }

    //recursive approach
    public static int searchNumber(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; //base case -> There is no search space -> there is no element in the array
        }
        int mid = (low + high) / 2; // find middle index
        if (arr[mid] == target) {
            return mid;  // return mid-index if element found
        } else if (arr[mid] > target) {
            return binarySearch(arr, low, mid - 1, target); // search left half
        } else {
            return binarySearch(arr, mid + 1, high, target); // search right half
        }
    }
}
//link: https://leetcode.com/problems/binary-search/description/
//link2: https://www.naukri.com/code360/problems/binary-search_972
