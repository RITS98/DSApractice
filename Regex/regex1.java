import java.util.regex.*;

public class regex1
{
	public static void main(String args[])
	{
		String r1 = "a?";
		Pattern p1 = Pattern.compile(r1);
		Matcher m1 = p1.matcher("abaa");
		while(m1.find())
		{
			System.out.println(m1.start()+" "+m1.end());
		}

		System.out.println("------------------------------------");

		String r2 = "a*";
		Pattern p2 = Pattern.compile(r2);
		Matcher m2 = p2.matcher("abaa");
		while(m2.find())
		{
			System.out.println(m2.start()+" " + m2.end());
		}

		System.out.println("-------------------------------------");

		String r3 = ".*+end";
		Pattern p3 = Pattern.compile(r3);
		Matcher m3 = p3.matcher("This is the end");
		while(m3.find())
		{
			System.out.println(m3.start()+" "+m3.end());
		}
	}

}