package ParkingSystem;
import java.util.Date;
import java.util.Comparator;
public abstract class Vehicle{
	public int VehicleNum;
	public Time time;
	public abstract int calcFee();
	public abstract void outTime(Date time);
	
	
}
