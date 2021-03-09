
class Teacher
{
    private String designation;
    private String collegeName;
    Teacher()
    {
        designation="Professor";
        collegeName="VIT";
    }

    public String getDesignation()
    {
        return designation;
    }
    public void setDesignation(String designation)
    {
        this.designation=designation;
    }
    public String getCollegeName()
    {
        return collegeName;
    }
    public void setCollegeName(String collegeName)
    {
        this.collegeName=collegeName;
    }

    void does()
    {
        System.out.println("Teaching the students");
    }
}

public class inheritance1 extends Teacher
{
    String mainSubject="Physics";
    public static void main(String args[])
    {
        inheritance1 obj=new inheritance1();
        System.out.println(obj.getDesignation());
        System.out.println(obj.getCollegeName());
        System.out.println(obj.mainSubject);
    }
}
