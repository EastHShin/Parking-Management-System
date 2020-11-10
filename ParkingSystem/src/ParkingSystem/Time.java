package ParkingSystem;
import java.util.Date;

public class Time {
	private Date inTime;
	private int outTime = 0;
	
	public Time(Date intime) {
		inTime = intime;
	}
	public Date getinTime() {
		return this.inTime;
	}
	public int getoutTime() {
		return this.outTime;
	}
	
	public void setoutTime(int time) {
		this.outTime = time;
	}
	public double subTime(Date intime, Date outtime) {
		return (outtime.getTime() - intime.getTime());
	}
}
