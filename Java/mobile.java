import java.util.*;
interface primary
{
	void call();
	void alarm();
	void ringtone();
}
interface secondary
{
	void internet();
}

class basic_mobile implements primary
{
	String name;int time;String song;
	public basic_mobile(String name, int time, String song)
	{
		this.song = song;
		this.time = time;
		this.name = name;
	}

	public void call()    {
        System.out.println("Calling " + name);
    }
    public void alarm()    {
        System.out.println("Alarm ringing at " + time + " am");
    }
    public void ringtone() {
		 System.out.println("Ringing " + song +"....");
		
	}

}

class android extends basic_mobile implements secondary
{
	String net;
	public android(String name,  int time,String song, String net) {
		super(name, time, song);
		this.net = net;
	}
	public void internet() {
		if(net.equals("available"))
		{
			System.out.print("You can access the internet");
		}
		else
			System.out.print("No internet access");
	}

}
public class mobile
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String song = sc.nextLine();
        int time = sc.nextInt();
        String x = sc.next();
        android oneplus = new android(name, time, song, x);
        oneplus.call();
        oneplus.alarm();
        oneplus.ringtone();
        oneplus.internet();
    }
}