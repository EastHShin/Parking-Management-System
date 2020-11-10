package ParkingSystem;
import java.util.Date;

public class Car extends Vehicle{
	
	public Car(int VeNum, Date inTime) {
		super.VehicleNum = VeNum;
		super.time = new Time(inTime);
	}
	
	@Override
	public int calcFee() {
		int n = super.time.getoutTime();
		if(n == 0)
			return 0;
		n -= 30;
		if(n<=0)
			return 1000;
		else {
			return 1000 + (n/10)*500;
		}
	}
	
	@Override
	public void outTime(Date time) {
		double sub = (super.time.subTime(super.time.getinTime(), time)) / 60000;
		int castSub;
		if(sub <30.0)
			castSub = 30;
		else {
			sub /= 10;
			castSub = (int) (Math.ceil(sub)*10);
		}
		super.time.setoutTime(castSub);
	}
}
