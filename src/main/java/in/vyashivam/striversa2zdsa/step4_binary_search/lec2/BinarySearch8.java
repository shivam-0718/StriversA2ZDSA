package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

import java.util.Arrays;

/*
    You are given an array 'arr' of size 'n' which denotes the position of stalls.
    You are also given an integer 'k' which denotes the number of aggressive cows.
    You are given the task of assigning stalls to 'k' cows such that the minimum
    distance between any two of them is the maximum possible.
    Find the maximum possible minimum distance.
 */
public class BinarySearch8 {
    public static int aggressiveCow(int []stalls, int k) {
        int minDistance = 0;
        Arrays.sort(stalls); // sorting stalls to evaluate min distance correctly

        // Try every possible minimum distance from 1 to the largest possible distance
        for(int i = 1; i <= (max(stalls) - min(stalls)); i++) {
            if(!canWePlace(stalls, i, k)) { //if all cows can be placed with the least min distance 'i' or not
                minDistance = i - 1; // if no, then the ans will be previous min distance between the cows.
                break;
            } // if yes, then continue with next min distance
        }
        return minDistance;
    }

    // helper method to find the max coordinate value of the stall
    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    // helper method to find the min coordinate value of the stall
    private static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // Checks if all cows can be placed in stalls maintaining at least 'minDistance' apart
    private static boolean canWePlace(int[] stalls, int minDistance, int cows) {
        int countCows = 1; // first cow has been placed
        int coordinate = stalls[0]; //first cow has been placed at first stall

        // Placing the remaining cows
        for (int i = 0; i < stalls.length; i++) {
            if(stalls[i] - coordinate >= minDistance) { // if current stall is far enough from the last placed cow
                countCows++; // Place another cow
                coordinate = stalls[i]; // update it's last placed position
            }
            // We calculate the distance from the last placed cow’s position,
            // not from the beginning of the stalls. Once a new cow is placed,
            // we update 'coordinate' to mark the stall of this newly placed cow.

            // If all cows are placed successfully, return true
            if(countCows >= cows) {
                return true;
            }
        }
        return false; // return false, which means not all cows have been placed with the given minDistance
    }

    //binary search
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls); // sorting stalls to evaluate min distance correctly
        int low = 1, high = max(stalls) - min(stalls);
        int ans = 0;

        while(low <= high) {
            int mid = (low + high) / 2; //resembles min distance between cows, whether true or false.

            if(canWePlace(stalls, mid, k)) {  //if all cows can be placed with the least min distance 'mid' or not
                ans = mid; // if yes, then we can move to the right, since we need to find the greater value of min distance
                low = mid + 1;
            } else {
                high = mid - 1; // if not, then move to the left, to find the correct min distance
            }
        }
        return ans; // Maximum value of min distance between any 2 cows.
    }
}
//link: https://www.naukri.com/code360/problems/aggressive-cows_1082559
