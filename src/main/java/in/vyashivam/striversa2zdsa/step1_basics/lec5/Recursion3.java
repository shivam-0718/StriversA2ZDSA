package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Printing numbers from 1 to n using recursion
public class Recursion3 {
    public static void printNumbers(int n) {
        //base condition
        if(n == 0) {
            return;
        }

        //recursive call
        printNumbers(n-1);

        //printing statement
        System.out.println(n);

    }
}
