/*

Prerequisite : Priority Queue, Comparator
Priority Queue is like a regular queue, but each element has a “priority” associated with it. In a priority queue, an element with high priority is served before an element with low priority. For this, it uses a comparison function which imposes a total ordering of the elements.

The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used

Constructors :

public PriorityQueue() : This creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
public PriorityQueue(Collection c) : This creates a PriorityQueue containing the elements in the specified collection(c). If the specified collection is an instance of a SortedSet, this priority queue will be ordered according to the same ordering, else this priority queue will be ordered according to the natural ordering of its elements.
public PriorityQueue(int capacity, Comparator comparator) : This creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
Parameters:
capacity - the initial capacity for this priority queue
comparator - the comparator that will be used to order this priority queue. 
If null, the natural ordering of the elements will be used.
public PriorityQueue(SortedSet ss) : Creates a PriorityQueue containing the elements in the specified sorted set. This priority queue will be ordered according to the same ordering as the given sorted set.

*/

import java.util.*;
import java.io.*;

public class prorityQueueComparator
{
	static class Student
	{
		String name;
		double cgpa;
		Student(String name, double cgpa)
		{
			this.name = name;
			this.cgpa = cgpa;
		}
		String getName()
		{
			return name;
		}
		double getCGPA()
		{
			return cgpa;
		}
	}

	public static void pQueue()
	{
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new Comparator<Student>(){

			public int compare(Student s1, Student s2) 
			{
                
                if (s1.cgpa < s2.cgpa)
                    return 1;
                else if (s1.cgpa > s2.cgpa)
                    return -1;
                                
                else
                	return s1.getName().compareToIgnoreCase(s2.getName());
            }
		});


		Student student1 = new Student("Nandini", 3.2);
                  
        // Adding a student object containing fields 
        // name and cgpa to priority queue 
        pq.add(student1);
        Student student4 = new Student("Vivek", 3.6);
                pq.add(student4);
        Student student2 = new Student("Anmol", 3.6);
                pq.add(student2);         
        Student student3 = new Student("Palak", 4.0);
                pq.add(student3);
          
        // Printing names of students in priority order,poll()
        // method is used to access the head element of queue
        System.out.println("Students served in their priority order");
        
          
        while (!pq.isEmpty()) 
        {
        	System.out.println(pq.peek().getName()+" "+pq.peek().getCGPA());
        	pq.remove();
       	}
	}

	public static void main(String args[])
	{
		pQueue();
	}

}



