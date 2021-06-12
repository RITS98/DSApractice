/*

1. There are 3 towers. Tower 1 has n disks, where n is a positive number. Tower 2 and 3 are empty.
2. The disks are increasingly placed in terms of size such that the smallest disk is on top and largest disk is at bottom.
3. You are required to 
    3.1. Print the instructions to move the disks.
    3.2. from tower 1 to tower 2 using tower 3 
    3.3. following the rules
        3.3.1 move 1 disk at a time.
        3.3.2 never place a smaller disk under a larger disk.
        3.3.3 you can only move a disk at the top.
*/

import java.io.*;
import java.util.*;

public class towerOfHanoi
{
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//no of disk
		String t1d = sc.next();		//Source tower
		String t2d = sc.next();		//destination tower
		String t3d = sc.next();		//helper tower

		toh(n, t1d, t2d, t3d);
	}

	public static void toh(int n, String t1d, String t2d, String t3d)
	{
		if(n == 0)
			return;

		toh(n-1, t1d, t3d, t2d);
		System.out.println(n + "["+t1d+" -> "+t2d+"]");
		toh(n-1, t3d, t2d, t1d);
	}
}