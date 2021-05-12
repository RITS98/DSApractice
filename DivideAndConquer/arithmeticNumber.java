/*

Given three integers  'A' denoting the first term of an arithmetic sequence , 'C' denoting the common difference of an arithmetic sequence and an integer 'B'. you need to tell whether 'B' exists in the arithmetic sequence or not.

Example 1:

Input: A = 1, B = 3, C = 2
Output: 1
Explaination: 3 is the second term of the 
sequence starting with 1 and having a common 
difference 2.
Example 2:

Input: A = 1, B = 2, C = 3
Output: 0
Explaination: 2 is not present in the sequence.

*/

import java.io.*;
import java.util.*;

public class arithmeticNumber
{
	public static int isPresent(int A, int B, int C)
	{
		if(B==A)
        return 1;
        
        if(C!=0)
            if((B-A)%C == 0 && (((B-A<0) && C<0)||((B-A>0) && C>0)))
            return 1;
        return 0;
	}
	public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            int C = Integer.parseInt(arr[2]);
            
            System.out.println(isPresent(A, B, C));
        }
    }
}