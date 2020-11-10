package ParkingSystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
public class main {
	private static int i = 0;
	public static void main(String[] args) throws ParseException{
		String strNum;
		Scanner in = new Scanner(System.in);
		System.out.printf("�����忡 �ִ� �� �븦 ������ �� �ֽ��ϱ�? : ");
		strNum = in.nextLine();
		int maxp = Integer.parseInt(strNum);
		ParkingLot p = new ParkingLot(maxp);
		Vehicle[] vehicle = new Vehicle[maxp];
		int choice;
		char typeOfvehicle;
		int num;
		int vehiNum;
		
		String date;
		loop:
		while(true) {
			System.out.println("���ϴ� ����� �����ϼ���!");
			System.out.printf("1. ����\n2. ����\n3. �������� ����\n4. �� ���� ����\n5. ����\n");
			strNum = in.nextLine();
			choice = Integer.parseInt(strNum);
			switch(choice) {
			case 1:			//����
				System.out.println("���� ������ �Է��ϼ���! �¿���(c), ����(b), Ʈ��(t)");
				strNum = in.nextLine();
				typeOfvehicle = strNum.charAt(0);
				if(!RightType(typeOfvehicle)) {
					System.out.println("�ùٸ� ���� Ÿ���� �ƴմϴ�!");
					break;
				}
				System.out.println("�뷮�� �Է��ϼ���!  (�������� �ִ� �뷮�� 60KW�̸� �� �̻� �Է½� 60KW�� ����˴ϴ�.)" );
				strNum = in.nextLine();
				num = Integer.parseInt(strNum);
				System.out.println("���� ��ȣ�� �Է��ϼ���! (4�ڸ� ����)");
				strNum = in.nextLine();
				vehiNum = Integer.parseInt(strNum);
				if(p.existNum(vehicle, vehiNum)) {
					System.out.println("�̹� ��ϵ� ������ȣ �Դϴ�!");
					break;
				}
				System.out.println("�����ð��� �Է��ϼ���!");
				date = in.nextLine();
				insert(vehicle, typeOfvehicle, num, vehiNum, date);
				break;
			case 2:
				System.out.println("������ ������ȣ�� �Է��ϼ���!");
				strNum = in.nextLine();
				vehiNum = Integer.parseInt(strNum);
				System.out.println("�����ð��� �Է��ϼ���!");
				date = in.nextLine();
				SimpleDateFormat form = new SimpleDateFormat("yyyy MM dd HH mm");
				Date to = form.parse(date);
				p.findVehicleNum(vehicle, vehiNum, to);
				break;
			case 3:
				p.CurParking(vehicle);
				break;
			case 4:
				int total = p.TotalIncome();
				String str = String.format("%,d", total);
				System.out.printf("�� ������ %s�� �Դϴ�\n", str);
				break;
			case 5:
				System.out.println("���� �մϴ�.");
				break loop;
			default :
				System.out.println("�߸��� �޴� �����Դϴ�.");
				break;
			}
		}

	}
	
	private static void insert(Vehicle[] vehicle, char type, int num, int vehiNum, String date) throws ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy MM dd HH mm");
		Date to = fm.parse(date);
		if(type == 'c') {			//car
			if(num == 0)
				vehicle[i++] = new Car(vehiNum, to);
			else
				vehicle[i++] = new ElecCar(num, vehiNum, to);
		}
		else if(type == 'b') {			//bus
			vehicle[i++] = new Bus(num, vehiNum, to);
		}
		else if(type == 't') {			//truc
			vehicle[i++] = new Truc(num, vehiNum, to);
		}
	}
	public static int getCurrentIndex() {
		return i;
	}
	public static void setCurrentIndex(int index) {
		i = index;
	}
	private static boolean RightType(char type) {
		if(type == 'c' || type == 'b' || type == 't')
			return true;
		else
			return false;
	}
	
}

