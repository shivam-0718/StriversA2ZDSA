package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

/*
    You are given a read-only array of N integers with values also in the range [1, N] both inclusive.
    Each integer appears exactly once except A which appears twice and B which is missing.
    The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
*/

public class Arrays9 {
    //brute-force solution
    public static int[] missingAndRepeating(int[] arr, int n) {
        int repeatNo = 0; //store the repeated number
        int missingNo = 0; //store the missing number

        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            int count = 0; //counter to check the existence of 'i' in the given array

            // Count occurrences of 'i' in the array
            for (int j = 0; j < n; j++) {
                if(arr[j] == i) {
                    count++;
                }
            }

            // If 'i' occurs twice -> repeating number, else if 'i' found missing -> missing number
            if(count == 2) {
                repeatNo = i;
            } else if (count == 0) {
                missingNo = i;
            }

            // Break from the loop if both numbers found early
            if(repeatNo != 0 && missingNo != 0) {
                break;
            }
        }

        return new int[]{missingNo, repeatNo};
    }

    //better solution
    public static int[] missingAndRepeatingNo(int[] arr, int n) {
        int repeatingNo = 0; // stores the repeating number
        int missingNo = 0; //store the missing number

        int[] freqArray = new int[n+1]; /// Frequency array of size n+1 to represent numbers from 1 to n

        // Fill frequency array with counts of each number
        for (int i = 0; i < arr.length; i++) {
            freqArray[arr[i]]++;
        }

        // Start from 1 (since 0 is not a valid number in this problem)
        // Check which number is missing or repeating
        for (int i = 1; i < freqArray.length; i++) {

            // If 'i' occurs twice -> repeating number, and if 'i' found missing -> missing number
            if(freqArray[i] == 2) {
                repeatingNo = i;
            } else if (freqArray[i] == 0) {
                missingNo = i;
            }
        }

        return new int[]{missingNo, repeatingNo};
    }

    //optimal solution - 1
    public static int[] missingAndRepeatingNumber (int[] arr, int n) {
        int x = 0; //repeating number
        int y = 0; //missing number

        // sumA = sum of array elements
        // sumSqA = sum of squares of array elements
        int sumA = 0, sumSqA = 0;

        // Expected sum of first n natural numbers: 1 + 2 + ... + n = n*(n+1)/2
        int sumN = n * (n + 1) / 2;

        // Expected sum of squares of first n natural numbers: 1² + 2² + ... + n² = n*(n+1)*(2n+1)/6
        int sumSqN = n * (n + 1) * ((2*n) + 1) / 6;

        // Calculate actual sums from array
        for (int i = 0; i < n; i++) {
            sumA += arr[i];
            sumSqA += (int) Math.pow(arr[i], 2);
        }

        // sumA - sumN = x - y
        int val1 = sumA - sumN;

        // sumSqA - sumSqN = x² - y² = (x - y)(x + y)
        int val2 = sumSqA - sumSqN;

        x = (val1 + (val2 / val1)) / 2;
        y = x - val1;

        return new int[]{x, y};
    }

}
//link: https://www.naukri.com/code360/problems/missing-and-repeating-numbers_873366
