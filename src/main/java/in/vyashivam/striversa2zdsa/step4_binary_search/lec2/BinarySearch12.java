package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

import java.util.PriorityQueue;

/*
    You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis.
    You are also given an integer ‘k’. You have to place 'k' new gas stations on the X-axis.
    You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions.
    Let 'dist' be the maximum value of the distance between adjacent gas stations after adding k new gas stations.
    Find the minimum value of ‘dist’.

    Note: Answers within 10^-6 of the actual answer will be accepted.
    For example, if the actual answer is 0.65421678124, it is okay to return 0.654216.
    Our answer will be accepted if that is the same as the actual answer up to the 6th decimal place.
*/
public class BinarySearch12 {
    //brute-force solution
    public static double minimiseMaxDistanceBetweenGasStations(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1]; // howMany[i] -> number of extra stations placed in the segment between arr[i] and arr[i+1]

        //Pick and place k gas stations one at a time
        for(int gasStations = 1; gasStations <= k; gasStations++) {
            // Find the segment currently having the largest distance between existing stations
            // when divided by (existing splits + 1)
            double maxSection = -1;
            int maxIndex = -1;

            for(int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double)(howMany[i] + 1);

                // Track the segment that currently forms the largest section length
                if(maxSection < sectionLength) {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++; // Place an additional station in the segment with the maximum current section length
        }

        // After placing all k stations, compute the final maximum distance between any two consecutive stations
        double maxAns = -1;
        for(int i = 0; i < n - 1; i++) {
            double sectionLength = (arr[i + 1] - arr[i]) / (double)(howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    //Better approach - Priority Queue
    public static class Pair {
        double first; //current max section length for this segment
        int second; //segment index

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double minimiseMaximumDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        //creating a max Heap PQ of Pair objects, ordered by the first value of each Pair
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        // insert the first n-1 elements into pq
        // with respective distance values:
        for(int i = 0; i < n - 1; i++) {
            pq.add(new Pair((arr[i + 1] - arr[i]), i));
        }

        // Pick and place k gas stations:
        for(int gasStations = 1; gasStations <= k; gasStations++) {
            Pair tp = pq.poll(); //largest current section
            int secInd = tp.second; //segment index
            howMany[secInd]++; //add a station to this segment
            double initialDifference = arr[secInd + 1] - arr[secInd];
            double newSectionLength = initialDifference / (double) (howMany[secInd] + 1); //updated max section length in this segment
            pq.add(new Pair(newSectionLength, secInd));
        }

        // The top of the heap now reflects the minimized maximum section length
        return pq.peek().first;
    }

    //Optimal Approach - Binary Search

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0, high = 0; // search space for the maximum adjacent distance
        double diff = 1e-6; //precision threshold

        //Finding max distance between 2 existing consecutive gas stations
        for(int i = 1; i < n; i++) {
            high = Math.max(high, (arr[i] - arr[i - 1]));
        }

        // Binary search the minimal possible "maximum distance"
        while(high - low > diff) {
            double mid = (low + high) / 2.0; // candidate maximum adjacent distance
            int count = numberOfGasStationsNeeded(arr, mid); // stations needed to keep all gaps ≤ mid
            if(count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    //Ensuring with the given distance between 2 consecutive gas stations, how many gas stations are needed
    private static int numberOfGasStationsNeeded(int[] arr, double distance) {
        int count = 0, n = arr.length;
        for(int i = 1; i < n; i++) {
            // How many cuts needed to ensure each sub-gap ≤ distance:
            // ceil(gap / distance) - 1
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / distance);
            if(arr[i] - arr[i - 1] == distance * numberInBetween) {
                numberInBetween--;
            }
            count+=numberInBetween;
        }
        return count;
    }
}

//link: https://www.naukri.com/code360/problems/minimise-max-distance_7541449
