import java.util.*;
abstract class Base
{
	Base()
	{
		System.out.println("Base constructor");
	}
	void fun()
	{
		System.out.println("Let's have some fun");
	}
}

class Derived extends Base
{
	Derived()
	{
		System.out.println("Derived Constructor");
	}
	void fun()
	{
		System.out.println("Derived fun()");
	}
}

public class abstractClass
{
	public static void main(String args[])
	{
		Derived d = new Derived();
		d.fun();
	}
}
