/*


Given a number having only one ‘1’ and all other ’0’s in its binary representation, find position of the only set bit. Source: Microsoft Interview | 18


The idea is to start from the rightmost bit and one by one check value of every bit. Following is a detailed algorithm.

1) If number is power of two then and then only its binary representation contains only one ‘1’. That’s why check whether the given number is a power of 2 or not. If given number is not a power of 2, then print error message and exit.

2) Initialize two variables; i = 1 (for looping) and pos = 1 (to find position of set bit)

3) Inside loop, do bitwise AND of i and number ‘N’. If value of this operation is true, then “pos” bit is set, so break the loop and return position. Otherwise, increment “pos” by 1 and left shift i by 1 and repeat the procedure.

*/

import java.io.*;
public class posOfFirstSetBit
{
	public static int findPosition(int num)
	{
		int i = 1, pos = 1;

		while((i&num) == 0)
		{
			i = i<<1;
			pos++;
		}
		return pos;
	}

	public static void main(String[] args)
    {
        int n = 16;
        int pos = findPosition(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);
  
        n = 12;
        pos = findPosition(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);
  
        n = 128;
        pos = findPosition(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);
    }
}