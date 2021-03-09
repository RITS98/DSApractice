import java.io.*;
public class exception3
{
		public static void main(String args[])
		{
			String s[] = {"Hello","423",null,"Hi"};
			for(int i =0 ;i<5;i++)
			{
				try
				{
					int a = s[i].length() + Integer.parseInt(s[i]);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Number format Exception occured");
				}
				catch(NullPointerException e)
				{
					System.out.println("NUll pointer exception found");
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Array index out of bounds");
				}
				System.out.println("After catch, this statement will exceute");
			}

			String arr[] = new String[]{"abc", "7657", null,"4945fwoijf"};
			System.out.println("---------------------------\n\n");
			for(int i = 0;i<5;i++)
			{
				try
				{
					int a = s[i].length()+ Integer.parseInt(s[i]);
				}
				//catch(Exception e)
				//{

				//}
				catch(NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex)
				{
					System.out.println("Exception handled");
				}

				System.out.println(i);
			}
		}
}