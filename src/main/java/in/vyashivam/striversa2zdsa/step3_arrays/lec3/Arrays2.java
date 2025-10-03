package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given an integer array nums of size n, return the majority element of the array which appears more than n/3 times.
    For more understanding, refer to Step 3 Lec 2 Problem 3 (Majority Element (> n/2 times))
*/

public class Arrays2 {
    //brute-force solution
    public static List<Integer> majorityElementInAnArray(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n/3) {
                //to avoid duplicate elements
                if(!ans.contains(nums[i])) {
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }

    //better solution
    public static List<Integer> majorityElementII(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            int freq = 0;
            if(map.containsKey(key)) {
                freq = map.get(key);
            }
            freq++;
            map.put(key, freq);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > (n / 3)) {
                int value = entry.getKey();
                ans.add(value);
            }
        }

        return ans;
    }

    //optimal solution - Boyer Moore Majority Vote algorithm
    public static List<Integer> majorityElement(int [] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0, element1 = 0, count2 = 0, element2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0) {
                count2 = 1;
                element2 = nums[i];
            }
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            }else {
                count1--;
                count2--;
            }
        }

        int count1a = 0, count2a = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == element1) {
                count1a++;
            } else if(nums[i] == element2) {
                count2a++;
            }
        }
        if(count1a > nums.length / 3) {
            ans.add(element1);
        }
        if(count2a > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }
}
//link: https://leetcode.com/problems/majority-element-ii/description/
//link: https://www.naukri.com/code360/problems/majority-element_6915220
