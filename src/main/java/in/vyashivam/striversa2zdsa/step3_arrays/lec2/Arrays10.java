package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
*/

public class Arrays10 {
    //brute-force solution
    public static int longestConsecutive(int[] nums) {
        int longest = 1; //length of the longest consecutive sequence

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int count = 1;

            while (ls(nums, x+1)) { //checking if x+1 exists, if yes, then increment x and count
                x += 1;
                count++;
            }
            longest = Math.max(count, longest); //after that, return the max of count and longest to return the longest sequence.
        }
        return longest;
    }

    //linear search of the element
    private static boolean ls(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return true;
            }
        }
        return false;
    }

    //better solution
    public static int longestSuccessiveElements(int[] nums) {
        Arrays.sort(nums); //sorting the array
        int n = nums.length,
                count = 0, //current count of the sequence
                longest = 1, //count of the longest sequence
                lastSmallest = Integer.MIN_VALUE; //value of the last element in the sequence

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmallest) {
                //if this is true, this means that nums[i] is a part of sequence
                count++;
                lastSmallest = nums[i];
            } else if (nums[i] != lastSmallest) {
                //this means nums[i] is not part of the sequence, then this will be the new sequence and count will be 1
                // New sequence starts from this element
                lastSmallest = nums[i];
                count = 1;
            }
            longest = Math.max(count, longest);
        }
        return longest;
    }


    //optimal solution (This has some constraints)
    public static int longestConsecutiveElements(int[] nums) {
        int longest = 1, n = nums.length;
        Set<Integer> set = new HashSet<>();

        //adding elements in a set to avoid duplicates
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        //iterating through a set
        for (int it : set) {
            if(set.contains(it - 1)) {
                continue; // Only start counting if 'it' is the start of a sequence. A start means (it - 1) does NOT exist in the set
            } else {
                int count = 1;
                int x = it;

                // Count all consecutive numbers starting from 'it'
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }

                //updating the longest sequence length found so far.
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}
//link: https://leetcode.com/problems/longest-consecutive-sequence/description/
//link2: https://www.naukri.com/code360/problems/longest-successive-elements_6811740
