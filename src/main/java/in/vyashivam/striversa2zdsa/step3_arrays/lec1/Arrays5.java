package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

//Left-rotate an array by one place; and right rotate an array by one place.
public class Arrays5 {
    //Left-rotation
    public static void rotateArrayByOneLeft(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }
        nums[nums.length - 1] = temp;
    }

    //Right-rotation
    public static void rotateArrayByOneRight(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = temp;
    }


}
//link: https://leetcode.com/problems/rotate-array/description/
//This will be solved in next file.
