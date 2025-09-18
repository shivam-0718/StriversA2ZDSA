package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

//Finding a missing element in an array
public class Arrays10 {
    //brute-force solution
    public static int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i <= nums.length; i++) {
            int flag = 0; // flag to check if 'i' exists in nums
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == i) {
                    flag = 1; // mark found
                    break;
                }
            }
            if (flag == 0) { //if not found, then that is our missing number
                ans = i;
            }
        }
        return ans;
    }

    //better solution - hashing
    public static int getMissingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] freqArray = new int[n + 1];

        //pre-computation as per hashing concept, -> iterate through nums[] and mark presence in freqArray
        for (int i = 0; i < n; i++) {
            freqArray[nums[i]]++;
        }

        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    //optimal solution 1 - sum
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int sumN = (n * (n + 1)) / 2; //finding sum of n natural numbers -> n can be found by getting length of nums
        int sumA = 0;

        for (int i = 0; i < n; i++) {
            sumA += nums[i]; //Doing the sum of elements in nums
        }

        return sumN - sumA;
    }

    //optimal solution 2 - xor
    public static int getMissingValue(int[] nums) {
        int xor1 = 0, xor2 = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            xor2 = xor2 ^ nums[i]; //doing xor for elements in nums
            xor1 = xor1 ^ (i+1); //doing xor for n natural numbers
        }
        return xor1 ^ xor2; //returns the missing element after doing xor of both values
    }

}
//link: https://www.naukri.com/code360/problems/missing-number_6680467
//link2: https://leetcode.com/problems/missing-number/description/
