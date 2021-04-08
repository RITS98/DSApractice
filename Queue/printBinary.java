/*
Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n. 

Examples: 

Input: n = 2
Output: 1, 10

Input: n = 5
Output: 1, 10, 11, 100, 101

Efficient Method – 

Following is an interesting method that uses queue data structure to print binary numbers. Thanks to Vivek for suggesting this approach. 

1) Create an empty queue of strings 
2) Enqueue the first binary number "1" to queue. 
3) Now run a loop for generating and printing n binary numbers. 
......a) Dequeue and Print the front of queue. 
......b) Append "0" at the end of front item and enqueue it. 
......c) Append "1" at the end of front item and enqueue it.

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class printBinary
{
	public static void print(int n)
	{
		Queue<String> q = new LinkedList<String>();

		q.add("1");
		for(int i = 1;i<=n;i++)
		{
			String s = q.peek();
			q.remove();

			System.out.print(s+" , ");
			q.add(s+"0");
			q.add(s+"1");
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		print(n);
	}
}