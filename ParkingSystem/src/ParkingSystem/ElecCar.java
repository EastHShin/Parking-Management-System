package ParkingSystem;
import java.util.Date;

public class ElecCar extends Car {
	private double CurrentBattery;
	private double concreteTime;
	private final double chargeH = 0.2;
	private final double MaxBattery = 60;
	
	public ElecCar(double CurBattery, int VeNum, Date inTime) {
		super(VeNum, inTime);
		if(CurBattery >= 60)
			this.CurrentBattery = 60;
		else
			this.CurrentBattery = CurBattery;
		}
	@Override
	public int calcFee() {
	
	return chargeFee() + super.calcFee();
	
	}
	@Override
	public void outTime(Date time) {
		double sub = (super.time.subTime(super.time.getinTime(), time)) / 60000;
		concreteTime = sub;
		int castSub;
		if(sub <30.0)
			castSub = 30;
		else {
			sub /= 10;
			castSub = (int) (Math.ceil(sub)*10);
		}
		super.time.setoutTime(castSub);
	}
	private int chargeFee() {
		if(concreteTime == 0)
			return 0;
		double charge = concreteTime * chargeH;
		double overCharge;
		if(MaxBattery < CurrentBattery + charge) {
			overCharge = (CurrentBattery + charge) - MaxBattery;
			charge = charge - overCharge;
			return (int)Math.ceil(charge) * 300;
		}
		else
			return (int)Math.ceil(charge) * 300;
	}
	
}
