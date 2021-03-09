import java.util.*;
class Bicycle
{
	public int gear, speed;

	Bicycle(int gear, int speed)
	{
		this.gear = gear;
		this.speed = speed;

		System.out.println(this.hashCode() + " - " + this.getClass().getName());
	}

	public void applyBrake(int decrement)
	{
		speed -= decrement;
	}

	public void speedUp(int increment)
	{
		speed += increment;
	}

	public String toString()
	{
		return ("No of gears - "+ gear +"\n Speed = "+speed);
	}
}

class MountainBike extends Bicycle
{
	public int seatHeight;

	public MountainBike(int gear, int speed, int seatHeight)
	{
		super(gear, speed);
		this.seatHeight = seatHeight;
	}
	public void display()
	{
		System.out.println("Subclass - ");
		System.out.println(this.getClass().getName() +" HashCode - "+this.hashCode());
		System.out.println(super.getClass().getName() + " HashCode - "+this.hashCode());

	}
	public String toString()
	{
		return (super.toString() + "\n Seat Height - " + seatHeight);
	}
}

public class inherit1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.  of gears - ");
		int gear = sc.nextInt();
		System.out.println("Enter speed - ");
		int speed  = sc.nextInt();
		System.out.println("Enter Seat Height - ");
		int seatHeight = sc.nextInt();

		MountainBike mb = new MountainBike(gear, speed, seatHeight);
		System.out.println(mb.toString());

		System.out.println(mb instanceof MountainBike);
		System.out.println(mb instanceof Bicycle);

		mb.display();
	}
}