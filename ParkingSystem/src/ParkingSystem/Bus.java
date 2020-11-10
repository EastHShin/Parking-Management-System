package ParkingSystem;
import java.util.Date;

public class Bus extends Vehicle{
	private int MaxPassenger;
	
	public Bus(int Maxpassenger, int VeNum, Date intime) {
		this.MaxPassenger = Maxpassenger;
		super.VehicleNum = VeNum;
		super.time = new Time(intime);
	}
	@Override
	public int calcFee() {
		int passenger = this.MaxPassenger;
		int minute = super.time.getoutTime();
		if(minute == 0)
			return 0;
		minute -= 60;
		if(passenger >= 40) {
			if(minute <= 0)
				return 4000;
			else
				return 4000 + (minute/30)*2000;
		}
		else if(passenger >= 24) {
			if(minute <= 0)
				return 3000;
			else
				return 3000 + (minute/30)*1500;
		}
		else {
			if(minute <= 0)
				return 3000;
			else
				return 3000 + (minute/30)*1000;
		}
	}
	@Override
	public void outTime(Date time) {
		double sub = super.time.subTime(super.time.getinTime(), time) / 3600000;
		int castSub;
		double a = sub - Math.floor(sub);
		
		if(a <= 0.5)
			castSub = (int)((0.5 + Math.floor(sub)) * 60);
		else
			castSub = (int)(Math.ceil(sub) * 60);
		
		super.time.setoutTime(castSub);
		
	}
}
