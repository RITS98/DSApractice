//Write a one line function to return position of first 1
// from right to left, in binary representation of an Integer.


import java.util.*;
class posRightBit
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a no. - ");
		int n=sc.nextInt();


		int x=(int)(Math.log10(n & -n)/Math.log10(2))+1;
		System.out.println("Position : "+x);
	}
}