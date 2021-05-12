/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

*/
import java.util.*;
import java.io.*;
class twoSum {
    public static int[] twoSummation(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            int comp = target - nums[i];
            if(hs.containsKey(comp))
                return new int[]{hs.get(comp),i};
            
            hs.put(nums[i],i);
        }
        
        return new int[]{};
        
    }

    public static void main(String args[])
    {
    	int arr[] = {2,7,11,15};
    	int target = 18;

    	System.out.println(Arrays.toString(twoSummation(arr, target)));
    }

}