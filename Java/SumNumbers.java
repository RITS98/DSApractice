class Stats<T extends Number>
{
    T nums[];
    Stats(T[] o)
    {
        nums = o;
    }
    double average()
    {
        double sum = 0.0;
        for(int i=0;i<nums.length;i++)
        sum+=nums[i].doubleValue();

        return sum/nums.length;
    }
}
public class SumNumbers
{
    public static void main(String args[])
    {
        Integer inums[]= {1,2,3,4,5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println("Average : "+v);

        //String sb[] = {"1","2","3","4"};
        //Stats<String> ob = new Stats<String>(sb);

        //System.out.println("Aversge Strings : "+ob.average());
    }
    
}