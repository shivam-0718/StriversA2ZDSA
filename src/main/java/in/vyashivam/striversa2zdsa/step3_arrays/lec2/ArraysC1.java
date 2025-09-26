package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.ArrayList;
import java.util.List;

//(C -> Concept - C after class name tells that this file is a concept for a Data Structure)

// Q: Finding all permutations of a given array
public class ArraysC1 {

    //Approach 1: Using extra List
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // Result list to store all permutations
        List<Integer> ds = new ArrayList<>(); // Temporary list (current permutation being built)
        boolean[] freq = new boolean[nums.length];  // Boolean array to track which elements are already used
        recurPermute(nums, ds, ans, freq); // Start recursion with empty "ds"
        return ans;
    }

    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        //Base condition: If the current permutation has all numbers → add to result
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds)); //creating new copy before adding
            return;
        }

        // Try placing every number in the current "slot"
        for (int i = 0; i < nums.length; i++) {
            // If nums[i] is not already used
            if (!freq[i]) {
                freq[i] = true; // Mark nums[i] as used
                ds.add(nums[i]); // add nums[i] into current permutation

                // Recurse to fill the next slot
                recurPermute(nums, ds, ans, freq);

                //Backtrack: Undo the choice
                ds.remove(ds.size() - 1); // remove last added element
                freq[i] = false; // mark nums[i] as unused again
            }
        }
    }

    //Approach 2: Swapping between 2 numbers in an array
    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursivePermutation(0, nums, ans); // start from index 0
        return ans;
    }

    private void recursivePermutation(int index, int[] nums, List<List<Integer>> ans) {
        // Base case: if index reaches end of array
        if(index == nums.length) {
            // add nums elements to ds and add ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums); // Swap current index with i
            recursivePermutation(index+1, nums, ans); // Recurse for next index
            swap(i, index, nums); // Backtrack: swap back
        }
    }

    private void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//link: https://leetcode.com/problems/permutations/
