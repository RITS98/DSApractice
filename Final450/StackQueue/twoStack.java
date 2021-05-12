import java.io.*;
import java.util.*;

class twoStacks
{
	int size;
	int arr[];
	int top1, top2;

	twoStacks(int n)
	{
		size = n;
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	public void insert1(int data)
	{
		if(top1 < top2 - 1)
		{
			top1++;
			arr[top1] = data;
		}
		else
		{
			System.out.println("StackOverflowError");
		}
	}

	public void insert2(int data)
	{
		if(top1<top2-1)
		{
			top2--;
			arr[top2] = data;
		}
		else
		{
			System.out.println("StackOverflowError");
		}
	}

	public int remove1()
	{
		if(top1>-1)
		{
			int x = arr[top1];
			top1--;
			return x;
		}

		return -1;
	}

	public int remove2()
	{
		if(top2<size)
		{
			return arr[top2++];
		}
		return -1;
	}

	public static void main(String args[])
	{
		twoStacks ts = new twoStacks(5);
        ts.insert1(5);
        ts.insert2(10);
        ts.insert2(15);
        ts.insert1(11);
        ts.insert2(7);
        System.out.println(Arrays.toString(ts.arr));
        System.out.println("Popped element from"
                           + " stack1 is " + ts.remove1());

        ts.insert2(40);

        System.out.println(Arrays.toString(ts.arr));
        System.out.println("Popped element from"
                           + " stack2 is " + ts.remove2());
        System.out.println(Arrays.toString(ts.arr));
        ts.insert1(13231);

	}
}