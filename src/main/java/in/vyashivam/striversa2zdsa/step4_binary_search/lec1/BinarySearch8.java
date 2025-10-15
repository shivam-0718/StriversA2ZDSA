package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;
/*
    Given an integer array nums, sorted in ascending order (with distinct values) and a target value k.
    The array is rotated at some pivot point that is unknown.
    Find the index at which k is present and if k is not present return -1.
*/
public class BinarySearch8 {
    //brute-force solution
    public int search(int[] nums, int k) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    //optimal solution
    public static int search(int[] arr, int n, int k) {
        int ans = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // finding middle index

            // getting the element and exit the loop after getting the index
            if(arr[mid] == k) {
                ans = mid;
                break;
            }

            //checking for sorted array portion
            if (arr[low] <= arr[mid]) { //left portion is sorted
                if (arr[low] <= k && k <= arr[mid]) { // element is within left portion, then eliminate right half
                    high = mid - 1;
                } else { // if not in left portion, eliminate sorted portion (left)
                    low = mid + 1;
                }
            } else { // right portion is sorted
                if (arr[low] <= k && k <= arr[mid]) { // element is within right portion, then eliminate left half
                    low = mid + 1;
                } else { // if not in right portion, eliminate sorted portion (right)
                    high = mid - 1;
                }
            }
        }

        return ans;
    }
}
// link: https://www.naukri.com/code360/problems/search-in-rotated-sorted-array_1082554
// link2: https://leetcode.com/problems/search-in-rotated-sorted-array/
