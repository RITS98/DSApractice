/*

Write a function Add() that returns sum of two integers. The function should not use any of the arithmetic operators (+, ++, –, -, .. etc).
Sum of two bits can be obtained by performing XOR (^) of the two bits. Carry bit can be obtained by performing AND (&) of two bits. 
Above is simple Half Adder logic that can be used to add 2 single bits. We can extend this logic for integers. If x and y don’t have set bits at same position(s), then bitwise XOR (^) of x and y gives the sum of x and y. To incorporate common set bits also, bitwise AND (&) is used. Bitwise AND of x and y gives all carry bits. We calculate (x & y) << 1 and add it to x ^ y to get the required result. 
 

 */

//https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class sum
{
	public static void add(int x, int y)
	{
		while(y!=0)
		{
			int carry = x&y;
			x = x^y;

			y = carry<<1;
		}

		return x;
	}

	public static void main(String arg[])
    {
        System.out.println(Add(15, 32));
    }
}