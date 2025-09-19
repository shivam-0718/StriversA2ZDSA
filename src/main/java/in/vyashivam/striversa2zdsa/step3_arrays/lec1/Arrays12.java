package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.HashMap;
import java.util.Map;

//In an array, find a number that appears once, and the other numbers twice
public class Arrays12 {
    //brute-force approach
    public static int findSingleNumberInArray(int[] nums){
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0; // reset counter for each new num
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num)
                    count++;  // increase count if match found
            }
            if (count == 1){
                ans = num; //return the number appeared once
                break;
            }
        }
        return ans;
    }

    //better approach
    public static int findSingleNumber(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //Iterating the elements of nums into map
        for (int key : nums) {
            int freq = 0;
            if (map.containsKey(key)) {
                freq = map.get(key); //get current frequency if number already exists
            }
            freq++; //increment the frequency and updating key-value pair in the map
            map.put(key, freq);
        }

        //Iterating through the map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) { //checking for equality
                ans = entry.getKey(); //retrieving the key from the map
                break;
            }
        }
        return ans;
    }

    //Optimal approach
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i]; //xor of all the elements in the array
        }
        return xor; // result is the single number
    }
}
//link: https://leetcode.com/problems/single-number/
