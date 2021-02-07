/*Write a function that, for a given no n, finds a number p which is greater than or equal to n and is a smallest power of 2.
Examples :

    Input : n = 5
    Output: 8     

    Input  : n = 17
    Output : 32     

    Input  : n = 32
    Output : 32  

 */

 import java.io.*;
 class power2
 {
 	public static void main(String args[])throws IOException
 	{
 		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 		System.out.println("Enter a number - ");
 		int n=Integer.parseInt(br.readLine());

 		int x=1;
 		while(x<n)
 		{
 			x=x<<1;
 		}

 		System.out.println("THE number is : "+x);
 	}
 }