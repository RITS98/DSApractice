import java.util.*;
public class sqrt
{
    public static int sqrtRoot(int x)
    {
        int low = 0,high = x;
        if(x==0 || x==1)
        return x;
        int ans = 0 ;
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(mid*mid == x)
            return mid;

            else if (mid*mid < x)
            {
                low  = mid+1;
                ans = mid;
            } 
            else
            high = mid - 1;

        }

        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("\nEnter a +ve number (input -ve No. to stop): ");
            int n = sc.nextInt();
            if(n<0)
            {
                System.out.println("Square ROOT OF -ve number is not possible!!!");
                break;
            }
            int ans = sqrtRoot(n);
            System.out.print("Square Root : "+ans);

        }
    }
}