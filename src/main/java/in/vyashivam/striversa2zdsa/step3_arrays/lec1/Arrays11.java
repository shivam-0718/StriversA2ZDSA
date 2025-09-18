package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

//Finding max consecutive 1s in an array
public class Arrays11 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1 && count >= max) {
                count++;
                max++;
            } else if (nums[i] == 1 && count < max) {
                count++;
            } else {
                count = 0;
            }
        }
        return max;
    }
}
