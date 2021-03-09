public class Person
{
    String fname,lname;
    int age;

    Person(String fname,String lname,int age)
    {
        this.fname=fname;
        this.lname=lname;
        this.age=age;
    }

    String getFirstName()
    {
        return fname;
    }
    String getLastName()
    {
        return lname;
    }
    int getAge()
    {
        return age;
    }
    void print()
    {
        System.out.println(fname+" "+lname+"    "+age);
    }
}