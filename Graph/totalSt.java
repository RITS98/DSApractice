import java.io.*
import java.util.*;

public class totalSt
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("No. of nodes - ");
		int n = sc.nextInt();

		int total = Math.pow(n, n-2);
		System.out.println("Total Spanning Tress - "+total);
	}
}