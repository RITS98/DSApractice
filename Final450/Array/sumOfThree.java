/*

Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with the sum smaller than the given sum value X.

*/

class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0;i<n-2;i++)
        {
            int left = i+1, right = n-1;
            while(left<right)
            {
                if(arr[i]+arr[left] + arr[right] >= sum)
                right--;
                else
                {
                    ans = ans + (right-left);
                    left++;
                }
            }
        }
        
        return ans;
    }
}
