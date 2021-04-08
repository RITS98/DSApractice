/*
Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently. 
Examples: 

Input: string = “this is a test string”, pattern = “tist” 
Output: Minimum window is “t stri” 
Explanation: “t stri” contains all the characters of pattern.
Input: string = “geeksforgeeks”, pattern = “ork” 
Output: Minimum window is “ksfor”

Method 2 ( Efficient Solution ) 

First check if the length of the string is less than the length of the given pattern, if yes then “no such window can exist “.
Store the occurrence of characters of the given pattern in a hash_pat[].
we will be using two pointer technique basically
Start matching the characters of pattern with the characters of string i.e. increment count if a character matches.
Check if (count == length of pattern ) this means a window is found.
If such a window found, try to minimize it by removing extra characters from the beginning of the current window.
delete one character from first and again find this deleted key at right, once found apply step 5 .
Update min_length.
Print the minimum length window.

//https://media.geeksforgeeks.org/wp-content/cdn-uploads/smallest-window.png

*/

//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class smallestWindowAllChar
{
	static final int no_of_chars = 256;
	public static String findsubString(String str, String pat)
	{
		int len1 = str.length();
        int len2 = pat.length();
 
        // Check if string's length is
        // less than pattern's
        // length. If yes then no such
        // window can exist
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }
 
        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];
 
        // Store occurrence ofs
        // characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;
 
        int start = 0, start_index = -1,
            min_len = Integer.MAX_VALUE;
 
        // Start traversing the string
        // Count of characters
        int count = 0;
        for (int j = 0; j < len1; j++)
        {
           
            // Count occurrence of characters
            // of string
            hash_str[str.charAt(j)]++;
 
            // If string's char matches
            // with pattern's char
            // then increment count
            if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
                count++;
 
            // If all the characters are matched
            if (count == len2) {
               
                // Try to minimize the window
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)]== 0) 
                {
 
                    if (hash_str[str.charAt(start)]> hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;

                    start++;
                }
 
                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) 
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
 
        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }
 
        // Return substring starting
        // from start_index
        // and length min_len
        return str.substring(start_index,start_index + min_len);
	}

	public static void main(String[] args)
    {
        String str = "this is a test string";
        String pat = "tist";
 
        System.out.println("Smallest window is : "+ findsubString(str, pat));
    }


}