import java.io.*;
import java.util.*;

public class subsequence
{ 
	public static ArrayList<String> getSub(String str)
	{
		if(str.length() == 0)
		{
			ArrayList<String> arr = new ArrayList<>();
			arr.add("");
			return arr;
		}

		char c = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> get = getSub(ros); // returns [--, -c, b-, bc]
		ArrayList<String> myResult = new ArrayList<>();
		for(String i: get)
		{
			myResult.add(""+i);
			myResult.add(c+i);
		}

		

		return myResult;
	}	

	public static void main(String args[])
	{
		String str = "abc";
		ArrayList<String> res = getSub(str);
		Collections.sort(res);
		System.out.println(res);
	}
}