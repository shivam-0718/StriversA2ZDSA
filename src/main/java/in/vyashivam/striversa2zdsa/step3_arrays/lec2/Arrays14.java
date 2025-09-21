package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

import java.util.HashMap;
import java.util.Map;

//Count the number of subarrays out of the array with given sum of K
public class Arrays14 {
    //brute-force approach
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++){
                int sum = 0;
                for (int K = i; K <= j; K++) {
                    sum += nums[K];
                }
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //better approach
    public static int countSubarraySum(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //optimal solution - hashing
    public static int countSumSubarray (int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int n = nums.length, count = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            //Case: If sum of subarray is k, then increase count
            if(sum == k) {
                count++;
            }

            //find prefix sum i.e. x-k, for which we need its occurrence
            int rem = sum - k;

            //retrieve the x-k subarray if rem exists in the map, and add it to count
            if(preSumMap.containsKey(rem)) {
                count += preSumMap.get(rem);
            }

            //if sum exists in the map, update the currentcount of that subarray, and update it in map
            if(preSumMap.containsKey(sum)) {
                int currentCount = preSumMap.get(sum);
                preSumMap.put(sum, ++currentCount);
            }

            //put the sum in the map if sum does not exist.
            if(!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, 1);
            }
        }
        return count;
    }

}
//link: https://www.naukri.com/code360/problems/subarray-sums-i_1467103
//link2: https://leetcode.com/problems/subarray-sum-equals-k/description/
