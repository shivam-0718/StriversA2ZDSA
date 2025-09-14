package in.vyashivam.striversa2zdsa.step1_basics.lec6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashing1 {
    static Scanner sc = new Scanner(System.in);

    //Number Hashing
    public static void numberFrequency(int size) {
        int[] arr = new int[size];

        //adding elements in the array
        System.out.println("Add elements into the array of size " + size + ":");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //pre-computation
        int[] freqArray = new int[13]; //Size only taken 13 as of now. Max size = 10^7
        for (int i = 0; i < arr.length; i++) {
            freqArray[arr[i]] += 1;
        }

        //fetching
        System.out.println("Total times this needs to be tested [Enter a number between 1 to 9]: ");
        int testCases = sc.nextInt();
        while (testCases > 0 && testCases < 10) {
            System.out.println("Enter the number from array whose frequency needs to be checked: ");
            int number = sc.nextInt();
            System.out.println(freqArray[number]);
            testCases--;
        }
    }

    //Character hashing
    public static void characterFrequency(String str) {
        char[] strArray = str.toCharArray();

        //pre-computation
        int[] freqArray = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freqArray[strArray[i]] += 1;
        }

        //fetching
        System.out.println("Total times this needs to be tested [Enter a number between 1 to 9]: ");
        int testCases = sc.nextInt();
        while (testCases > 0 && testCases < 10) {
            System.out.println("Enter the character from string whose frequency needs to be checked: ");
            char letter = sc.next().charAt(0);
            System.out.println(freqArray[letter]);
            testCases--;
        }
    }

    //Number hashing using Map
    public static void numFreq(int size) {
        int[] arr = new int[size];

        //adding elements in the array
        System.out.println("Add elements into the array of size " + size + ":");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //pre-computation (For HashMap)
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            int freq = 0;
            if (map.containsKey(key)) {
                freq = map.get(key);
            }
            freq++;
            map.put(key, freq);
        }

        //Iterating through a map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //fetching
        System.out.println("Total times this needs to be tested [Enter a number between 1 to 9]: ");
        int testCases = sc.nextInt();
        while (testCases > 0 && testCases < 10) {
            System.out.println("Enter the number from array whose frequency needs to be checked: ");
            int number = sc.nextInt();
            System.out.println(map.getOrDefault(number, 0));
            testCases--;
        }

    }
}
