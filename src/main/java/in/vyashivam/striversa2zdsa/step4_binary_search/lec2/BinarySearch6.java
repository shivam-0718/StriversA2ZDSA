package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

/*
    You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another.
    The packages must be shipped within 'd' days.

    The weights of the packages are given in an array 'of weights'.
    The packages are loaded on the conveyor belts every day in the same order as they appear in the array.
    The loaded weights must not exceed the maximum weight capacity of the ship (sum of weights in 1 day <= capacity).
    Find out the least-weight capacity so that you can ship all the packages within 'd' days.

    Ex: weights[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], d = 5

        By considering capacity of ship = 15
        1st day = [1, 2, 3, 4, 5], 2nd day = [6, 7], 3rd day = [8], 4th day = [9], 5th day = [10]
        Total days to ship all weights = 5, which is <= d. Hence least capacity of ship = 15
*/
public class BinarySearch6 {
    //brute-force solution
    public static int shipWithinDDays(int[] weights, int days) {
        // Try every possible ship capacity from max(weights) to sum(weights) and return the first one that can ship within 'days'.
        int ans = 0;

        // Try every capacity between the heaviest package and total weight
        for(int capacity = maxValue(weights); capacity <= sum(weights); capacity++) {
            int totalDays = daysRequiredToTransport(weights, capacity);

            // If we can ship all packages within given days, that’s our answer
            if(totalDays <= days) {
                ans = capacity;
                break;
            }
        }
        return ans;
    }

    //helper method to calculate max value of an array - as capacity can't be less than the heaviest package
    private static int maxValue(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    //helper method to calculate sum of all package weights with the given ship capacity
    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //helper method to calculate the number of days required to ship all weights considering the given capacity of ship
    private static int daysRequiredToTransport(int[] weights, int capacity) {
        int days = 1; // Start with day 1
        int load = 0; // Current day's total weight
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) { // If adding current package exceeds capacity, move to next day
                days += 1;
                load = weights[i]; // start new day with current package
            } else {
                load += weights[i]; // Keep loading on the same day till it exceeds the given ship capacity
            }
        }
        return days;
    }

    //optimal solution - Binary search
    public static int shipWithinDays(int[] weights, int days) {
        // Search for the minimum capacity using binary search between max(weights) and sum(weights)
        int low = maxValue(weights), high = sum(weights);

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalDays = daysRequiredToTransport(weights, mid);
            if(totalDays <= days) {
                high = mid - 1; // Current capacity works -> try smaller
            } else {
                low = mid + 1; // Capacity too small -> increase it
            }
        }

        return low; // return the least capacity
    }
}
