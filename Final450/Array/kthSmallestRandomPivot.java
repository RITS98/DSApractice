import java.util.*;
import java.util.stream.*;
import java.io.*;
public class kthSmallestRandomPivot
{
	public static int findKthsmallest(int[] nums, int k) {
        
        if(nums.length == 1){
            return nums[0];
        }
        return randomSelect(nums,0,nums.length - 1,k);
    }
    
    private static  int randomSelect(int[] nums, int start, int end, int k){
        
            int index = randomPartition(nums,start,end);
            if(index == (k-1)){
                return nums[index];
            }
            else if(index >= k){
                return randomSelect(nums,start,index-1,k);
            }else{
                
                return randomSelect(nums,index+1,end,k);
            }
    }
    
    
    private static int randomPartition(int[] nums,int start, int end){
        int randomIndex = getRandomIndex(start, end);
        exchange(nums,randomIndex,end);
        
        int pivot = nums[end];
        int pointer = start -1;
        for(int i = start; i < end; i++){
            if(nums[i] <= pivot){
                pointer++;
                exchange(nums,i,pointer);
            }
        }exchange(nums,pointer+1,end);
        return pointer+1;
    }
    
    private static int getRandomIndex(int min, int max){
        Random random = new Random();
        int limit = ((max-min)+ 1);
        return random.nextInt(limit) + min;
    }
    
    private static  void exchange(int[] nums,int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		System.out.println("Enter an array - ");
		int arr[] = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		System.out.println("Enter the kth value - ");
		int k = Integer.parseInt(br.readLine());

		bw.write(""+findKthsmallest(arr, k)+"\n");
		bw.flush();
	}
}