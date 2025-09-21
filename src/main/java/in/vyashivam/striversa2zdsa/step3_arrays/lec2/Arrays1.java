package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//2 Sum Problem - Return the indices of 2 elements from a given array which makes the sum = given number
public class Arrays1 {
    //brute-force approach
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        return ans;
    }

    //better solution - hashing (Most effective for all the cases, whether array is sorted or unsorted)
    public static int[] getTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int val1 = i;
            int val2 = target - val1;
            if(map.containsKey(val2)) {
                ans[0] = map.get(val2);
                ans[1] = i;
            }
            map.put(val1, i);
        }
        return ans;
    }

    //optimal solution - 2 pointer (Only works if the array is already given sorted, otherwise hashing is the most effective solution)
    public static int[] calculateTwoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
           int sum = nums[left] + nums[right];
           if (sum == target) {
               ans[0] = left;
               ans[1] = right;
               break;
           } else if (sum < target) {
               left++;
           } else {
               right--;
           }
        }
        return ans;
    }
}
//link: https://leetcode.com/problems/two-sum/description/
//link2: https://www.naukri.com/code360/problems/two-sum_839653
