package in.vyashivam.striversa2zdsa.step1_basics.lec4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Divisors6 {
    //brute-force approach for number of Divisors.
    public static int noOfDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    //optimized approach for number of Divisors.
    public static int numberOfDivisors(int n) {
        int noOfDivisors = 0;
        for (int i = 1; i <= (int)Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                noOfDivisors++;
            }
        }
        return noOfDivisors;
    }

    //optimized approach for list of Divisors.
    public static List<Integer> listOfDivisorsOfNumber(int n) {
        List<Integer> divisorsList = new ArrayList<>();
        for (int i = 1; i <= (int)Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                divisorsList.add(i);
                if((n/i) != i) {
                    divisorsList.add((n/i));
                }
            }
        }
        Collections.sort(divisorsList);
        return divisorsList;
    }
}
//link: https://www.naukri.com/code360/problems/print-all-divisors-of-a-number_1164188
