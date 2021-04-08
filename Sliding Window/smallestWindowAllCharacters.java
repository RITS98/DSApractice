/*

Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .
Examples: 

Input: aabcbcdbca
Output: dbca
Explanation: 
Possible substrings= {aabcbcd, abcbcd, 
bcdbca, dbca....}
Of the set of possible substrings 'dbca' 
is the shortest substring having all the 
distinct characters of given string. 

Input: aaab
Output: ab
Explanation: 
Possible substrings={aaab, aab, ab}
Of the set of possible substrings 'ab' 
is the shortest substring having all 
the distinct characters of given string.  

Algorithm : 
Maintain an array (visited) of maximum possible characters (256 characters) and as soon as we find any in the string, mark that index in the array (this is to count all distinct characters in the string).
Take two pointers start and end which will mark the start and end of window.
Take a counter=0 which will be used to count distinct characters in the window.
Now start reading the characters of the given string and if we come across a character which has not been visited yet increment the counter by 1.
If the counter is equal to total number of distinct characters, Try to shrink the window.
For shrinking the window -: 
If the frequency of character at start pointer is greater than 1 increment the pointer as it is redundant.
Now compare the length of present window with the minimum window length.


*/


//https://www.geeksforgeeks.org/smallest-window-contains-characters-string/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class smallestWindowAllCharacters
{
	public static String smallestSubstring(String st)
	{
		HashMap<String, Integer> dist = new HashMap<>();

		for(int i = 0;i<st.length();i++)
		{
			dist.put(st.charAt(i)+"", dist.getOrDefault(st.charAt(i)+"", 0)+1);
		}
		int size = dist.size();
		//System.out.println(size);

		HashMap<String, Integer> curr = new HashMap<>();
		int start  = 0, end = 0;
		int n = st.length();

		int min_win_size = n;
		int start_index = 0, end_index = 0;
		while(end<=n && start<=end)
		{
			//System.out.println(curr);
			

			int s = curr.size();
			
			if(s<size && end<n)
			{
				curr.put(st.charAt(end)+"", curr.getOrDefault(st.charAt(end)+"", 0)+1);
				end++;
				
			}	
			else if(s == size)
			{
				
				int win_size = -start + end  ;
				//System.out.println(win_size+" " + min_win_size+" " + end+" "+start);
				if(win_size<min_win_size)
				{
					start_index = start;
					end_index = end-1;
					min_win_size = win_size;
				}

				int x = curr.get(st.charAt(start)+"").intValue();
				if(x==1)
				{
					curr.remove(st.charAt(start)+"");
				}
				else
				{
					curr.put(st.charAt(start)+"", curr.getOrDefault(st.charAt(start)+"", 0)-1);
				}
				start++;
			}
			else
				break;
		}

		return st.substring(start_index, end_index+1);
	}

	public static void main(String args[])
	{
		String st = "aabcbcdbca";

		System.out.println(smallestSubstring(st)); 
		System.out.println(smallestSubstring("aaab")); 
		System.out.println(smallestSubstring("aabcbcdb")); 


	}
}