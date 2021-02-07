public class Bubble 
{

    public static void main(String args[])
    {
        int arr[] = new int[]{98, 45, 65, 23, 89, 20, 64, 57, 16, 51, 36};

        int n = arr.length;

        for(int i = 0; i < n-1; i++)
        {
            //Used to check whether the array is already sorted for the remaing numbers
            boolean swapped = false;
            for(int j = 0; j < n-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(swapped == false)
            break;
        }

        System.out.println("Sorted array - ");
        for(int i : arr)
        {
            System.out.print(i+ " - - ");
        }
        System.out.println("\n");
    }
    
}
