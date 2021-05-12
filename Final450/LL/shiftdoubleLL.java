/*

Given a doubly linked list, rotate the linked list counter-clockwise by N nodes. Here N is a given positive integer and is smaller than the count of nodes in linked list.

*/

import java.io.*;
import java.util.*;

public class shiftdoubleLL
{
	static doubleNode head;
	public static void shift(int n)
	{
		if(head == null || n ==0)
			return ;

		doubleNode curr = head;
		int count = 0;
		while(count<n && curr != null)
		{
			curr = curr.next;
			count++;
		}

		doubleNode nth = curr;

		while(curr.next != null)
			curr = curr.next;

		curr.next = head;
		head.prev = curr;

		head = nth;

		head.prev.next = null;
		head.prev=null;
	}

	static void push(char new_data) 
	{ 
	    doubleNode new_node = new doubleNode(); 
	    new_node.data = new_data; 
	    new_node.prev = null; 
	    new_node.next = (head); 
	    if ((head) != null) 
	        (head).prev = new_node; 
		head = new_node; 
	} 
	  
	/* Function to print linked list */
	static void printList(doubleNode node) 
	{ 
	    while (node != null && node.next != null)
	    { 
	        System.out.print(node.data + " "); 
	        node = node.next; 
	    } 
	    if(node != null)
	    System.out.print(node.data); 
	} 
	  
	// Driver's Code 
	public static void main(String[] args) 
	{ 
	    /* Start with the empty list */
	    // Node head = null; 
	  
	    /* Let us create the doubly 
	    linked list a<->b<->c<->d<->e */
	    push( 'e'); 
	    push( 'd'); 
	    push('c'); 
	    push('b'); 
	    push( 'a'); 
	  
	    int N = 2; 
	  
	    System.out.println("Given linked list "); 
	    printList(head); 
	    shift(N); 
	    System.out.println();
	    System.out.println("Rotated Linked list "); 
	    printList(head); 

	    System.out.println();
	} 

}