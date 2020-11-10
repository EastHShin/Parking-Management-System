package ParkingSystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
public class main {
	private static int i = 0;
	public static void main(String[] args) throws Exception {
		String strNum;
		Scanner in = new Scanner(System.in);
		System.out.printf("주차장에 최대 몇 대를 주차할 수 있습니까? : ");
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
			System.out.println("원하는 기능을 선택하세요!");
			System.out.printf("1. 입차\n2. 출차\n3. 주차차량 보기\n4. 총 수입 보기\n5. 종료\n");
			strNum = in.nextLine();
			choice = Integer.parseInt(strNum);
			switch(choice) {
			case 1:			//입차
				System.out.println("차량 종류를 입력하세요! 승용차(c), 버스(b), 트럭(t)");
				strNum = in.nextLine();
				typeOfvehicle = strNum.charAt(0);
				if(!RightType(typeOfvehicle)) {
					System.out.println("올바른 차량 타입이 아닙니다!");
					break;
				}
				System.out.println("용량을 입력하세요!  (전기차의 최대 용량은 60KW이며 그 이상 입력시 60KW로 저장됩니다.)" );
				strNum = in.nextLine();
				num = Integer.parseInt(strNum);
				System.out.println("차량 번호를 입력하세요! (4자리 숫자)");
				strNum = in.nextLine();
				if(strNum.length() > 4) {
					System.out.println("차량번호는 4자리 입니다!");
					break;
				}
				try {
					vehiNum = Integer.parseInt(strNum);
				}catch(NumberFormatException e) {
					System.out.println("올바른 차량번호를 입력하세요!");
					break;
				}
				if(p.existNum(vehicle, vehiNum)) {
					System.out.println("이미 등록된 차량번호 입니다!");
					break;
				}
				System.out.println("입차시간을 입력하세요!");
				date = in.nextLine();
				try {
				SimpleDateFormat fm = new SimpleDateFormat("yyyy MM dd HH mm");
				Date to = fm.parse(date);
				insert(vehicle, typeOfvehicle, num, vehiNum, to);
				}catch(ParseException e) {
					System.out.println("잘못된 날짜 입력 형식입니다!");
					break;
				}
				break;
			case 2:
				System.out.println("출차할 차량번호를 입력하세요!");
				strNum = in.nextLine();
				vehiNum = Integer.parseInt(strNum);
				System.out.println("출차시간을 입력하세요!");
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
				System.out.printf("총 수입은 %s원 입니다\n", str);
				break;
			case 5:
				System.out.println("종료 합니다.");
				break loop;
			default :
				System.out.println("잘못된 메뉴 범위입니다.");
				break;
			}
		}

	}
	
	private static void insert(Vehicle[] vehicle, char type, int num, int vehiNum, Date to) {
		
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

