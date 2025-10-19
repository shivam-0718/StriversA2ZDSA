package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

import java.util.ArrayList;

/*
    Given an array nums sorted in non-decreasing order.
    Every number in the array except one appears twice. Find the single number in the array.
*/
public class BinarySearch12 {
    // brute-force solution
    public static int singleNonDuplicateElement(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if (n == 1) {
            return nums[0]; // edge case: single element array
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) { // checking for first element
                if (nums[i] != nums[i+1]) {
                    ans = nums[0];
                    break;
                }
            } else if (i == n - 1) { // checking for last element
                if (nums[i] != nums[i - 1]) {
                    ans = nums[i];
                    break;
                }
            } else { // checking for other elements in the array
                if (nums[i] != nums[i + 1] && nums[i] != nums[i-1]) {
                    ans = nums[i];
                    break;
                }
            }
        }

        return ans;
    }

    // better solution
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int xor = 0;
        for (int i = 0; i < arr.size(); i++) {
            xor ^= arr.get(i); // using xor -> xor of same numbers is 0
        }
        return xor; // final answer will be the number appearing once in the array.
    }

    // optimal solution
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // handling the edge cases
        if (n == 1) { // edge case: single element in array
            return nums[0];
        } else if (nums[0] != nums[1]) { // edge case: checking for first element
            return nums[0];
        } else if (nums[n - 1] != nums[n - 2]) { // edge case: checking for last element
            return nums[n - 1];
        }

        int low = 1, high = n - 2; // shrinking search space as edge cases already handled

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                ans = nums[mid];
                break;
            }

            // eliminating the sorted half
            // left half
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                low = mid + 1; // eliminate left half by moving right
            } else { // right half
                high = mid - 1; // eliminate right half by moving left
            }
        }
        return ans;
    }

    // if we are using data structures like arraylist as the parameter, always tend to use .equals() method for comparing the values
    // instead of using == operator for value comparison (as == is only valid for primitives).
    // In case of objects, == is used to compare the references. If you want to compare the values, then use .equals().
}
// link: https://www.naukri.com/code360/problems/unique-element-in-sorted-array_1112654
//link2: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
