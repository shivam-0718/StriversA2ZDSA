package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

import java.util.ArrayList;

/*
    Given an array ‘arr' of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i''th’ book.
    There are a ‘m’ number of students, and the task is to allocate all the books to the students.
    Allocate books in such a way that:
        Each student gets at least one book.
        Each book should be allocated to only one student.
        Book allocation should be in a contiguous manner.

    You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
    If the allocation of books is not possible. return -1
 */
public class BinarySearch9 {
    public static int findMinimumPages(ArrayList<Integer> arr, int n, int m) {
        if(m > n) {
            return -1;
        }

        int minimum = max(arr); // Each student must get at least one book, so min pages = max(pages in a single book)
        int maximum = sum(arr); // If one student gets all books, total pages = sum of all pages

        int minPages = 0;
        for(int i = minimum; i <= maximum; i++) {

            // counting noOfStudents who will get a book each and should not exceed maxNumberOfPages (i)
            int noOfStudents = countNumberOfStudents(arr, i);
            if(noOfStudents == m) { // If exactly m students can be allocated with this max page limit
                minPages = i;
                break;
            }
        }
        return minPages; // Return answer
    }

    // Helper method — counts how many students are needed if no student gets more than maxNumberOfPages
    private static int countNumberOfStudents(ArrayList<Integer> arr, int maxNumberOfPages) {
        int students = 1; // Starting allocation from first student
        int pagesStudent = 0; //currently holding number of pages for current student
        for (int i = 0; i < arr.size(); i++) {
            if(pagesStudent + arr.get(i) <= maxNumberOfPages) {
                pagesStudent += arr.get(i); // Add book pages for current student if within limit
            } else {
                students++; // Else, assign it to next student
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    // Helper method — returns the maximum pages in a single book
    public static int max(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    // Helper method — returns the total number of pages across all books
    public static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    //optimal solution - Binary solution
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        int low = max(arr); // Each student must get at least one book, so min pages = max(pages in a single book)
        int high = sum(arr); // If one student gets all books, total pages = sum of all pages

        while(low <= high) {
            int mid = (low + high) / 2; // Mid represents the assumed max pages per student
            int noOfStudents = countNumberOfStudents(arr, mid); // Calculate required students for this limit
            if(noOfStudents > m) { // if noOfStudents to which books allocated is more than given student number
                low = mid + 1; // move to right side to find the increased allowed pages per student
            } else {
                high = mid - 1; // move to left side to find min possible value for max pages per student
            }
        }
        return low; //return the minimum value of maximum number of pages
    }

}
