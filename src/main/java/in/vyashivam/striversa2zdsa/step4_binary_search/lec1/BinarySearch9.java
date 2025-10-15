package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;
/*
    Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k.
    Now the array is rotated at some pivot point unknown to you.
    Return True if k is present and otherwise, return False.
*/
public class BinarySearch9 {
    public static boolean search(int[] nums, int target) {
        boolean ans = false;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // finding the

            // getting the element and exit the loop after getting the index
            if(nums[mid] == target) {
                ans = true;
                break;
            }

            // Handling the edge case: duplicates at both ends make it unclear which half is sorted.
            // Shrink the search space by moving both pointers inward.
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // checking the array for sorted portion
            if (nums[low] <= nums[mid]) { // if true, left portion is sorted
                if (nums[low] <= target && target <= nums[mid]) { // element is within left portion, then eliminate right half
                    high = mid - 1;
                } else { // if not in left portion, eliminate sorted portion (left)
                    low = mid + 1;
                }
            } else { // right portion is sorted
                if (nums[mid] <= target && target <= nums[high]) { // element is within right portion, then eliminate left half
                    low = mid + 1;
                } else { // if not in right portion, eliminate sorted portion (right)
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
}
//link: https://www.naukri.com/code360/problems/search-in-a-rotated-sorted-array-ii_7449547
//link2: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
