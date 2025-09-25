package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.ArrayList;
import java.util.List;

/*
  Rearrange Array by Sign:
  - Equal positives & negatives
  - Alternate signs
  - Keep relative order
  - Must start with positive
*/

public class Arrays7 {
    //brute-force approach
    public static int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Store positives and negatives separately into their lists
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        // Place them alternately: positive at even index, negative at odd index
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2*i] = pos.get(i);
            nums[2*i + 1] = neg.get(i);
        }

        return nums;
    }

    //optimal solution
    public static int[] rearrangeTheArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1; // Use two pointers directly to place positive numbers at even indices and negative numbers at odd indices

        // Traverse array once and place elements in their correct positions
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i]; // Negative goes to odd index
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i]; //Positive goes to even index
                posIndex += 2;
            }
        }
        return ans;
    }

    /*
        Second case: Number of positive and negative elements are different
        In that case, there is only one solution -> Brute-force solution
    */
    
    public static int[] rearrange(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                neg.add(arr[i]);
            } else {
                pos.add(arr[i]);
            }
        }

        //Execution of the part of code depending upon the number of positives and negatives

        //If number of positives > number of negatives
        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        } else {
            //If number of positives < number of negatives
            for (int i = 0; i < pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }

        return arr;
    }
}
//link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
//link2: https://www.naukri.com/code360/problems/rearrange-alternatively_873851
