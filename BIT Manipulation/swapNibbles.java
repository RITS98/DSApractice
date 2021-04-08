// Java program to swap two
// nibbles in a byte

public class swapNibbles 
{
	
	static int swap(int x)
	{
		return ((x & 0x0F) << 4 | (x & 0xF0) >> 4);
	}

	// Driver code
	public static void main(String arg[])
	{
		int x = 100;
		System.out.print(swap(x));
	}
	}

// This code is contributed by Anant Agarwal.
