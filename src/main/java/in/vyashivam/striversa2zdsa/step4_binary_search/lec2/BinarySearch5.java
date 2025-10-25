package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;
/*
    You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'.
    Your task is to find the smallest positive integer divisor, such that upon dividing all
    the elements of the given array by it, the sum of the division's result is less than or
    equal to the given threshold value.

    Ex: arr = [1, 2, 5, 9], threshold = 6
        If we take divisor = 4, and move through the array, and
        we found ceil of (arr[i] / divisor) and then add to the
        sum.
        After getting sum of array with given divisor, we then
        check
            if sum <= threshold
                We got the latest divisor
*/
public class BinarySearch5 {
    //brute-force solution
    public static int smallestDivisorNumber(int[] nums, int limit) {
        if(nums.length > limit) { // return -1 if the length of array is more than limit
            return -1;
        }
        int ans = 0;
        for (int divisor = 1; divisor <= maxValue(nums); divisor++) { // range from 1 to max(array) for smallest divisor
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += (int) Math.ceil((double) nums[i] / (double) divisor); // finding the ceil of (nums[i]/divisor and adding to sum
            }
            if (sum <= limit) { // found the smallest divisor
                ans = divisor;
                break;
            }
        }
        return ans;
    }

    // Helper: Find maximum bloom day
    private static int maxValue(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    //optimal solution - binary search
    public static int smallestDivisor(int[] nums, int limit) {
        if (nums.length > limit) { // return -1 if the length of array is more than limit
            return -1;
        }

        int low = 1, high = maxValue(nums); // range from 1 to max(array) as smallest divisor will be within this range

        while (low <= high) {
           int mid = (low + high) / 2; // finding divisor by calculating mid
           int sum = sumOfIndividualDivision(nums, mid); // checking sum with this given mid

           if(sum <= limit) { // found the possible value (mid -> divisor)
               high = mid - 1; // go left to find the smallest divisor
           } else { // not the possible value
               low = mid + 1; // go left to find the possible value
           }
        }

        return low; // return the smallest divisor
    }

    // Helper method to find the sum of individual divisions of every array element with a given divisor
    private static int sumOfIndividualDivision(int[] nums, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double) nums[i] / (double) divisor);
        }
        return sum;
    }
}
//link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
//link2: https://www.naukri.com/code360/problems/smallest-divisor-with-the-given-limit_1755882
