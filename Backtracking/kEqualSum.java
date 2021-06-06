import java.io.*;
import java.util.*;

public class kEqualSum
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String parts[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
		{
			arr[i] = Integer.parseInt(parts[i]);
		}

		int k = Integer.parseInt(br.readLine());

		if(k == 1)
		{
			System.out.println(Arrays.toString(arr));
		}


		int sum = 0;
		for(int i:arr)
			sum+=i;

		if(k<0 || k>n || sum%k!=0)
		{
			System.out.println(-1);
			return;
		}	


		int subsetSum[] = new int[k];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0;i<k;i++)
		{
			list.add(new ArrayList<>());
		}

		solution(arr,0, n, k, subsetSum, 0, list);
	}

	public static void solution(int arr[], int vidx, int n, int k, int subsetSum[], int v, ArrayList<ArrayList<Integer>> list)
	{
		if(vidx == arr.length)
		{
			if(v == k)
			{
				boolean flag = true;
				for(int i = 0;i<subsetSum.length - 1;i++)
				{
					if(subsetSum[i] != subsetSum[i+1])
					{
						flag = false;
						break;
					}
				}

				if(flag)
				{
					for(ArrayList<Integer> li : list)
						System.out.println(li);
					System.out.println();
				}


			}
			return;
		}
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i).size()>0)
			{
				list.get(i).add(arr[vidx]);
				subsetSum[i] += arr[vidx];
				solution(arr, vidx + 1, n, k, subsetSum, v, list);
				subsetSum[i] -= arr[vidx];
				list.get(i).remove(list.get(i).size()-1);
			}
			else
			{
				list.get(i).add(arr[vidx]);
				subsetSum[i] += arr[vidx];
				solution(arr, vidx + 1, n, k, subsetSum, v+1, list);
				subsetSum[i] -= arr[vidx];
				list.get(i).remove(list.get(i).size()-1);
				break;
			}

		}
	}
}