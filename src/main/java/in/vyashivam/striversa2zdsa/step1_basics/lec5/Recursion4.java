package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Printing numbers from n to 1 using recursion
public class Recursion4 {
    public static void printNumbers(int n) {
        if(n == 0){
            return;
        }
        System.out.println(n);
        printNumbers(n-1);
    }
}
