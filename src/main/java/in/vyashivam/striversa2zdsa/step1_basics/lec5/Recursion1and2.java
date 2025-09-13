package in.vyashivam.striversa2zdsa.step1_basics.lec5;

//Printing name n times with recursion
public class Recursion1and2 {
    public static void printName(int n) {
        int n1 = n;
        n = 0;

        //base condition
        if (n == n1) {
            return;
        }
        System.out.println("SV");

        //n incremented
        n++;

        //recursive call
        printName(n1-n);
    }

    //another method
}
