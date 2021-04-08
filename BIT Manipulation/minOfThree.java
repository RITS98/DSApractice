//https://www.geeksforgeeks.org/smallest-of-three-integers-without-comparison-operators/


import java.io.*;


public class minOfThree
{
	public static int min(int x, int y, int z)
	{
		if(y/x>1)
		{
			return (y/z>1)?y:z;
		}
		return (x/z>1)?x:z;
	}

	public static void main(String[] args)
    {
        int x = 78, y = 88, z = 68;
        System.out.printf("Minimum of 3 numbers" + " is %d\n", min(x, y, z));
    }
}