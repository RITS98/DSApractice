/*
A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.

Mapping the elements of a heap into an array is trivial: if a node is stored an index k, then its left child is stored at index 2k+1 and its right child at index 2k+2.

How is Max Heap represented? 



A-Max Heap is a Complete Binary Tree. A-Max heap is typically represented as an array. The root element will be at Arr[0]. Below table shows indexes of other nodes for the ith node, i.e., Arr[i]: 
Arr[(i-1)/2] Returns the parent node. 
Arr[(2*i)+1] Returns the left child node. 
Arr[(2*i)+2] Returns the right child node.

Operations on Max Heap: 

1) getMax(): It returns the root element of Max Heap. Time Complexity of this operation is O(1).

2) extractMax(): Removes the maximum element from MaxHeap. Time Complexity of this Operation is O(Log n) as this operation needs to maintain the heap property (by calling heapify()) after removing the root.

3) insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If the new key is smaller than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

Note: In the below implementation, we do indexing from index 1 to simplify the implementation. 

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class MaxHeap
{
	private int[] Heap;
	private int size;
	private int maxsize;

	MaxHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[maxsize+1];
		Heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int pos)
	{
		return pos/2;
	}

	private int leftChild(int pos)
	{
		return 2*pos;
	}

	private int rightChild(int pos)
	{
		return 2*pos+1;
	}

	private boolean isLeaf(int pos)
	{
		if(pos> (size/2) && pos<= size)
			return true;

		return false;
	}

	public void swap(int fpos, int spos)
	{
		int temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}

	private void maxHeapify(int pos)
	{
		if(isLeaf(pos))
			return;

		if(Heap[pos]<Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)])
		{
			if(Heap[leftChild(pos)] > Heap[rightChild(pos)])
			{
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else
			{
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}

	}

	public void insert(int element)
	{
		Heap[++size] = element;
		int current = size;
		while(Heap[current]>Heap[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print()
	{
		for(int i = 1;i<=size/2;i++)
		{
			System.out.println("Parent: "+Heap[i]+"  Left Child: "+Heap[2*i]+"  Right Child: "+Heap[2*i+1]);
		}
	}

	public int extractMax()
	{
		int pop = Heap[1];
		Heap[1] = Heap[size--];

		maxHeapify(1);
		return pop;
	}

	public static void main(String args[])
	{
		System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
  
        maxHeap.print();
        
        System.out.println("The max val is "+ maxHeap.extractMax());
    }
	
}