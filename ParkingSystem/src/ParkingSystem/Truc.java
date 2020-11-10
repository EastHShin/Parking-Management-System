package ParkingSystem;
import java.util.Date;

public class Truc extends Vehicle{
	private int weight;
	public Truc(int weight, int VeNum, Date inTime) {
			this.weight = weight;
			super.VehicleNum = VeNum;
			super.time = new Time(inTime);
		}
	
	@Override
	public int calcFee() {
		int w = this.weight;
		if(w >= 10) {
			return super.time.getoutTime() * 4000;
		}
		else if(w >= 5 ) {
			return super.time.getoutTime() * 3000;
		}
		else {
			return super.time.getoutTime() * 2000;
		}
	}
	@Override
	public void outTime(Date time) {
		double sub = super.time.subTime(super.time.getinTime(), time) / 3600000;
		int castSub;
		castSub = (int)(Math.ceil(sub));
		
		super.time.setoutTime(castSub);
	}
}
