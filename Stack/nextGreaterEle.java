/*Given an array, print the Next Greater Element (NGE) for every element. 
The Next greater Element for an element x is the first greater element on the right side of x in array. 
Elements for which no greater element exist, consider next greater element as -1.

Examples:

For any array, rightmost element always has next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25], the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12      -->     -1
*/

import java.util.*;
public class nextGreaterEle
{
    public static void findGreater(int arr[])
    {
        int l = arr.length;
        
        int p = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(arr[0]);
        for(int i = 1;i<arr.length;)
        {            
            while(!st.isEmpty() && arr[i] > st.peek())
            {
                System.out.println(st.pop()+" --> " +arr[i]);
            }
            if(st.isEmpty() || arr[i]<st.peek())
            {
                st.push(arr[i]);
                i++;
            }            
        }
        while(!st.isEmpty())
        {
            System.out.println(st.pop()+" --> "+"-1");
        }

        
    }
    public static void main(String args[])
    {
        int arr[]={13, 7, 6, 12};
        findGreater(arr);
    }
}

