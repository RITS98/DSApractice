import java.io.*;
import java.util.*;
class StringToken
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = new String(br.readLine());

		StringTokenizer st = new StringTokenizer(s);
		//StringTokenizer st = new StringTokenizer(s, true);

		int count = st.countTokens();

		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}

		System.out.println("---------------------------");
		String mydelim = " : "; 
        String mystr = "JAVA : Code : String : Tokenizer : Geeks"; 
  
        // Use of Constructor 2 
        // Here we are passing Delimiter - "mydelim" 
        StringTokenizer geeks3 = new StringTokenizer(mystr, mydelim);

        int count1 = geeks3.countTokens(); 
        System.out.println("Number of tokens : " + count1 + "\n"); 
        for (int i = 0; i <count1; i++) 
            System.out.println("token at [" + i + "] : " + geeks3.nextToken()); 
  
        // .hasMoreTokens() method checks for more Tokens. 
        // Here not working as no Tokens left 
        while (geeks3.hasMoreElements()) 
  
            // .nextToken is method is returning next token. 
            System.out.println(geeks3.nextElement()); 


	}
}