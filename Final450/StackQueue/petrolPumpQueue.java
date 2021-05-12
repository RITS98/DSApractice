import java.util.Scanner;
class petrolPumpQueue
{
    static int printTour(int arr[][], int n) 
    {   
        int start = 0; 
        int end = 1; 
        int curr_petrol = arr[start][0] - arr[start][1]; 
        while(end != start || curr_petrol < 0) 
        { 
            while(curr_petrol < 0 && start != end) 
            { 
                curr_petrol -= arr[start][0] - arr[start][1]; 
                start = (start + 1) % n; 
                if(start == 0) 
                    return -1; 
            } 
            curr_petrol += arr[end][0] - arr[end][1]; 
              
            end = (end + 1)%n; 
        } 
        return start; 
    } 
    public static void main(String[] args)  
    { 
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0] = sr.nextInt();
            arr[i][1] = sr.nextInt();
        } 
        int start = printTour(arr, n); 
        System.out.println(start == -1 ? "No Solution" : + start);  
    } 
}