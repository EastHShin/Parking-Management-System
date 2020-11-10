package ParkingSystem;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ParkingLot {
	private static int capacity;
	private static int income;
	public ParkingLot(int capa) {
		capacity = capa;
		income = 0;
	}
	
public	void CurParking(Vehicle[] vehi) {
		int i,j;
		int size = main.getCurrentIndex();
		Vehicle temp;
		for(i=0; i<size-1; i++) {
			for(j= 1; j<size-i; j++) {
				if(vehi[j-1].time.getinTime().getTime() > vehi[j].time.getinTime().getTime()) {
					temp = vehi[j-1];
					vehi[j-1] = vehi[j];
					vehi[j] = temp;
				}
			}
		}
		for(i =0; i<size; i++)
			printInfoCar(vehi[i]);
		for(i =0; i<size; i++)
			printInfoTruc(vehi[i]);
		for(i =0; i<size; i++)
			printInfoBus(vehi[i]);
	}
	
	
	public void printInfoCar(Vehicle car) {
		SimpleDateFormat transform = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		if(car instanceof Car) {
			System.out.printf("�¿��� %d %s\n", car.VehicleNum, transform.format(car.time.getinTime()));
		}
	}
	public void printInfoTruc(Vehicle truc) {
		SimpleDateFormat transform = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		if(truc instanceof Truc) {
			System.out.printf("Ʈ�� %d %s\n", truc.VehicleNum, transform.format(truc.time.getinTime()));
		}
	}
	public void printInfoBus(Vehicle bus) {
		SimpleDateFormat transform = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		if(bus instanceof Bus) {
			System.out.printf("���� %d %s\n", bus.VehicleNum, transform.format(bus.time.getinTime()));
		}
	}
	
	
	public void findVehicleNum(Vehicle[] vehi, int vehinum,Date date) {
		int i;
		int j = main.getCurrentIndex();
		int isThere = 0;
		for(i=0; i<j; i++) {
			if(vehi[i].VehicleNum == vehinum) {
				isThere = 1;
				break;
			}
		}
		if(isThere == 0) {
			System.out.println("�� ��ȣ�� ������ ��ϵǾ� ���� �ʽ��ϴ�.");
			return;
		}
		if((date.getTime() - vehi[i].time.getinTime().getTime()) < 0) {
			System.out.println("�����ð��� �����ð����� ���� �ð��̾�� �մϴ�!");
			return;
		}
		vehi[i].outTime(date);
		if(vehi[i] instanceof Car) {
			System.out.printf("�����ð��� %d�� �Դϴ�.\n",vehi[i].time.getoutTime());
		}
		else if(vehi[i] instanceof Bus) {
			System.out.printf("�����ð��� %d�� �Դϴ�.\n",vehi[i].time.getoutTime());
		}
		else if(vehi[i] instanceof Truc) {
			System.out.printf("�����ð��� %d�ð� �Դϴ�.\n",vehi[i].time.getoutTime());
		}
		System.out.printf("��������� %d ���Դϴ�.\n", vehi[i].calcFee());
		income += vehi[i].calcFee();
		int delIndex = i;
		for(i = delIndex; i<j-1; i++) {
			vehi[i] = vehi[i+1];
		}
		main.setCurrentIndex(--j);
		
	}

	public int TotalIncome() {
		return income;
	}
	public boolean existNum(Vehicle[] vehicle, int num) {
		int i;
		int j = main.getCurrentIndex();
		
		for(i=0; i<j; i++) {
			if(vehicle[i].VehicleNum == num) {
				return true;
			}
		}
		return false;
		
	}
	
}
