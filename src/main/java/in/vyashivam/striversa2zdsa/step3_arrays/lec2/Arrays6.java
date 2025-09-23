package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

/*
    Given an array arr of n integers, where arr[i] represents price of the stock on the ith day.
    Determine the maximum profit achievable by buying and selling the stock at most once.
 */

public class Arrays6 {
    //brute-force approach
    public static int stockBuySell(int[] arr) {
        int profit = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int cost = arr[j] - arr[i];
                    profit = Math.max(profit, cost);
                }
            }
        }
        return profit;
    }

    //optimal approach
    public static int stockBuyAndSell(int[] arr) {
        int profit = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            // Update the minimum buying price so far
            if (arr[i] < min) {
                min = arr[i];
            }

            int cost = arr[i] - min; // Calculate profit if sold today
            profit = Math.max(cost, profit); // Update max profit
        }
        return profit;
    }
}
//link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//link2: https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock_893405
