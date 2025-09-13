package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Find Fibonacci Series up to the Nth term
public class Recursion9 {
    //brute-force approach
    public static void fibonacci(int N) {
        int[] fiboArray = new int[N+1];
        fiboArray[0] = 0;
        fiboArray[1] = 1;

        for (int i = 2; i < N+1; i++) {
            fiboArray[i] = fiboArray[i-1] + fiboArray[i-2];
        }

        for (int i : fiboArray) {
            System.out.print(i + " ");
        }
    }

    //optimization approach
    public static int fibonacciSeries(int n) {
        if(n <= 0) {
            return 0;
        }
        int secondLast = 0;
        int last = 1;
        int curr = 0;
        System.out.print(secondLast + " " + last + " ");

        for(int i = 2; i <= n; i++) {
            curr = last + secondLast;
            secondLast = last;
            last = curr;
            System.out.print(curr + " ");
        }

        System.out.println();
        System.out.println("The " + n + "th term in fibonacci series is ");
        return curr;
    }

    //recursion method
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fibo(n-1);
        int secondLast = fibo(n-2);
        return last+secondLast;
    }

}
