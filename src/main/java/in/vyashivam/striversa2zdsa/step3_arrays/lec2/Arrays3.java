package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array nums of size n, return the majority element of the array.
    The majority element of an array is an element that appears more than n/2 times in the array.
    The array is guaranteed to have a majority element.
*/

public class Arrays3 {
    //brute-force solution
    public static int majorityElementInArray(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > (nums.length / 2)) {
                ans = nums[i];
            }
        }
        return ans;
    }


    //better solution - hashing
    public static int majorityElement(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                int freq = map.get(key);
                freq++;
                map.put(key, freq);
            } else {
                map.put(key, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
               ans = entry.getKey();
               break;
            }
        }
        return ans;
    }

    //optimal solution - Boyer–Moore Majority Vote algorithm
    public static int findMajority(int[] arr) {
        int element = 0, count = 0;

        //applying the algorithm:
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if(element == arr[i]) {
                count++;
            } else {
                count--;
            }
        }

        //checking if the stored element
        // is the majority element:
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                count1++;
            }
        }
        if (count1 > arr.length/2) {
            return element;
        }

        return -1;
    }



}
//link: https://leetcode.com/problems/majority-element/description/
//link2: https://www.naukri.com/code360/problems/majority-element_842495
