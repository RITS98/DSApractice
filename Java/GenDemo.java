//Generic class Demo

class GenDemo
{
    public static void main(String args[])
    {
        Gen<Integer> iob = new Gen<Integer>(88);
        iob.showType();

        int v = iob.getob();
        System.out.println("The value : "+v);



    }
    

}