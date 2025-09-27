package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Return a list of all the leaders in an array
    A leader in an array is an element whose value is strictly greater than all elements to its right in the given array.
    The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.
 */

public class Arrays9 {
    //brute-force solution
    public static List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            boolean leader = true; //to check if current element "nums[i]" is the leader
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] >= nums[i]) {  // If any element on right is >= nums[i], then nums[i] is not leader
                    leader = false;
                    break;
                }
            }
            if (leader) {
                ans.add(nums[i]); // If still leader, add to the result list
            }
        }
        Collections.sort(ans); // Optional step: Only sort if problem specifically asks for sorted leaders
        return ans;
    }

    //optimal solution
    public static List<Integer> findLeaders(int[] a) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE; // Track maximum from right
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > max) { // If current element is greater than all seen so far, it's a leader
                ans.add(a[i]);
            }
            max = Math.max(max,a[i]); // Update max
        }
        return ans;
    }
}
//link: https://www.naukri.com/code360/problems/superior-elements_6783446
