package in.vyashivam.striversa2zdsa.step1_basics.lec5;

import java.util.Locale;

//Check whether a string is a palindrome or not.
public class Recursion8 {
    //brute-force approach
    public static boolean isPalindrome(String s) {
        char[] chArray = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase().toCharArray();
        char[] palindromeArray = new char[chArray.length];

        for (int i = 0; i < chArray.length; i++) {
            palindromeArray[chArray.length-1-i] = chArray[i];
        }
        return (String.valueOf(chArray).equals(String.valueOf(palindromeArray)));
    }

    //optimized approach - 1
    public static boolean isStringPalindrome(String s) {
        char[] chArray = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase().toCharArray();
        int start = 0;
        int end = chArray.length - 1;
        while (start < end) {
            if(chArray[start] == chArray[end]) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    //optimized approach - 2
    public static boolean isAStringPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);
            if(!Character.isLetterOrDigit(l)) {
                left++;
            } else if(!Character.isLetterOrDigit(r)) {
                right--;
            } else if (Character.toLowerCase(l) != Character.toLowerCase(r)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    //recursion method
    public static boolean stringPalindromeCheck(String s) {
        if(s == null)
            return false;
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
        return isPalindromeRecursive(0, cleaned);
    }

    private static boolean isPalindromeRecursive(int i, String s) {
        if(i >= s.length()/2) {
            return true;
        }
        if(s.charAt(i) != s.charAt(s.length() - 1 - i))
            return false;

        return isPalindromeRecursive(i+1, s);
    }


}
//link: https://leetcode.com/problems/valid-palindrome/description/
