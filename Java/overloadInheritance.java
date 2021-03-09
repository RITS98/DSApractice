public class overloadInheritance {
    public static void main(String args[])
    {
        Derieved ob=new Derieved();
        System.out.println(ob.fun(3));
        System.out.println(ob.fun(3.3));
    }
}

class Base
{
    public int fun(int a)
    {
        return a+3;
    }
}
class Derieved extends Base{
    public double fun(double a)
    {
        return a+3.3;
    }
}
