import java.util.*;

public class comparatorImp
{
	String Name;
	int Age;
	public comparatorImp(String Name, Integer Age)
	{
		this.Name = Name;
		this.Age = Age;
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String Name)
	{
		this.Name = Name;
	}

	public Integer getAge()
	{
		return Age;
	}

	public void setAge(Integer Age)
	{
		this.Age = Age;
	}

	public String toString()
	{
		return "Customer { "+ " NAME = " + Name + ", Age = "+Age+" }";
	}

	static class SortingComparator implements Comparator<comparatorImp>
	{
		public int compare(comparatorImp c1, comparatorImp c2)
		{
			int NameComp = c1.getName().compareTo(c2.getName());
			int AgeComp = c1.getAge().compareTo(c2.getAge());
			if(NameComp == 0)
			{
				return AgeComp == 0? NameComp : AgeComp;
			}
			else
			return NameComp;
		}
	}

	public static void main(String args[])
	{
		List<comparatorImp> al = new ArrayList<>();

		comparatorImp obj1 = new comparatorImp("Ajay", 27);
        comparatorImp obj2 = new comparatorImp("Sneha", 23);
        comparatorImp obj3 = new comparatorImp("Simran", 37);
        comparatorImp obj4 = new comparatorImp("Ajay", 22);
        comparatorImp obj5 = new comparatorImp("Ajay", 29);
        comparatorImp obj6 = new comparatorImp("Sneha", 22);
 
        // add customer objects to ArrayList
        al.add(obj1);
        al.add(obj2);
        al.add(obj3);
        al.add(obj4);
        al.add(obj5);
        al.add(obj6);


        

        Iterator<comparatorImp> custIterator = al.iterator();
 
        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }
 
        // sorting using Collections.sort(al, comparator);
        Collections.sort(al, new SortingComparator());
 
        // after Sorting arraylist: iterate using enhanced for-loop
        System.out.println("\n\nAfter Sorting:\n");
        for (comparatorImp customer : al) {
            System.out.println(customer);
        }
	}
}