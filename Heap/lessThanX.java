import java.io.*;
import java.util.*;

public class lessThanX
{
	int heap[];
	int maxsize;

	lessThanX(int maxsize)
	{
		this.maxsize = maxsize;
		heap = new int[maxsize];
	}

	int parent(int i)
	{
		return (i-1)/2;
	}
	int leftChild(int i)
	{
		return 2*i+1;
	}
	int rightChild(int i)
	{
		return 2*i+2;
	}

	void printSmallerThanX(int x,int i, int n)
	{
		if(i>=n || heap[i] > x)
			return;

		System.out.print(heap[i]+" ");

		printSmallerThanX(x,2*i+1, n);
		printSmallerThanX(x,2*i+2, n);
	}

	int i = 0;
	void insertKey(int data)
	{
		if(i==maxsize)
		{
			System.out.println("Heap is Full");
		}

		int j = i;
		i++;
		heap[j] = data;

		while(j!=0 && heap[parent(j)]>heap[j])
		{
			int swap = heap[j];
			heap[j] = heap[parent(j)];
			heap[parent(j)] = swap;

			j = parent(j);
		}


	}

	public static void main(String[] args)
    {
        lessThanX h = new lessThanX(11);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        h.insertKey(80);
        h.insertKey(6);
        h.insertKey(150);
        h.insertKey(77);
        h.insertKey(120);
  		System.out.println(Arrays.toString(h.heap));
        // Print all nodes smaller than 100.
        int x = 100;
        h.printSmallerThanX(x, 0, h.maxsize);
    }
}