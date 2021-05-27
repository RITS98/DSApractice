/*


Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.

*/

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        Arrays.sort(arr);
        
        for(int i = 0;i<arr.length - 3;i++)
        {
            if (i > 0 && arr[i] == arr[i - 1])              //to not select same number
            continue;
            
            for(int j = i + 1;j<arr.length - 2;j++)
            {
                if (j > i + 1 && arr[j] == arr[j - 1])      //to not select same number
                continue;
                
                int left = j+1;
                int right = arr.length-1;
                int sum = k - arr[i]-arr[j];
                while(left<right)
                {
                    int old_l = left;
                    int old_r = right;
                    if(arr[left] + arr[right] < sum)
                    left++;
                    else if(arr[left] + arr[right]>sum)
                    right--;
                    else
                    {
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[left]);
                        al.add(arr[right]);
                        left++;
                        right--;
                        ar.add(al);
                        
                        while (left < right && arr[left] == arr[old_l])         //to not select same number
                        left++;
                        while (left < right && arr[right] == arr[old_r])        //to not select same number
                        right--;
                    }
                }
            }
        }
        
        return ar;
        
    }
}