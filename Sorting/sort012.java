/**
 * Algorithm:
Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range containing 0), low to mid (the range containing 1), mid to high (the range containing unknown elements) and high to N (the range containing 2).
Traverse the array from start to end and mid is less than high. (Loop counter is i)
If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
If the element is 1 then update mid = mid + 1
If the element is 2 then swap the element with the element at index high and update high = high – 1 and update i = i – 1. As the swapped element is not processed
Print the output array.

Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

 */



import java.util.*;
class sort012
{
    public static void main(String args[])
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortnos(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortnos(int arr[])
    {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        int temp;
        while(mid<=high)
        {
            switch(arr[mid])
            {
                case 0: temp = arr[mid];
                        arr[mid] = arr[low];
                        arr[low] = temp;
                        low ++;
                        mid ++;
                        break;
                case 1:mid++;
                        break;
                case 2: temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high --;
                break;
                
            }
        }
    }

}