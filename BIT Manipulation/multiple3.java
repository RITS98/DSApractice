//Write an Efficient Method to Check if a Number is Multiple of 3
import java.util.*;
class multiple3
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number - ");
		int n=sc.nextInt();

		int countOdd=0;
		int countEven=0;

		while(n!=0)
		{
			if((n&1) !=0)
				countOdd++;
			if((n&2) !=0)
				countEven++;

			n>>=2;
		}

		if((countOdd-countEven)%3==0)
			System.out.println("Divisible by 3");
		else
			System.out.println("Not Divissible");

	}
}