import java.io.*;
class Address
{
	private int doorNo;
	private String rem;
	public int getDoorNo()
	{
		return doorNo;
	}
	public void setDoorNo(int doorNo)
	{
		this.doorNo = doorNo;
	}
	public String getRem()
	{
		return rem;
	}
	public void setRem(String rem)
	{
		this.rem = rem;
	}
	public String toString()
	{
		return  "Address: " + doorNo+" , " + rem;
	}
}

class Person
{
	private String name;
	private Address address;
	public Person()
	{
		address = new Address();
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Address getAddress()
	{
		return address;
	}
	public String toString()
	{
		return "Person Name: " + name + "   ,"+address;
	}
}
public class PersonAddress {
    public static void main(String args[]) {
      Person person = new Person();
      person.setName("Mahendra Singh Dhoni");
      person.getAddress().setDoorNo(07);          
      person.getAddress().setRem("XXX, Ranchi, Jharkhand.");
      System.out.println(person);
      person = null;
      if(person != null)
	  {
	    System.out.println(person.getAddress());
	  }
      else
        System.out.println("Address Does not Exist");    
    }
}
