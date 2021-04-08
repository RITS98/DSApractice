/*

Given a number n and a value k, turn off the k’th bit in n. Please note that k = 1 means the rightmost bit.

Examples:

Input:  n = 15, k = 1
Output: 14

Input:  n = 14, k = 1
Output: 14
The rightmost bit was already off, so no change.

Input:  n = 15, k = 2
Output: 13

Input:  n = 15, k = 3
Output: 11

Input:  n = 15, k = 4
Output: 7

Input:  n = 15, k >= 5
Output: 15 
The idea is to use bitwise <<, & and ~ operators. Using expression "~(1 << (k – 1))“, we get a number which has all bits set, except the k’th bit. If we do bitwise & of this expression with n, we get a number which has all bits same as n except the k’th bit which is 0.

*/

public class turnOffKthBit
{
	public static int newNum(int x, int k)
	{
		if(k<=0)
			return x;
		k = ~(1 << (k-1));
		x = x & k;

		return x;
	}

	public static void main (String[] args) 
    {
        int n = 15;
        int k = 4;
        System.out.println(newNum(n, k));
    }
}