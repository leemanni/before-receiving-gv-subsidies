package day09_remind;
//변수

import java.util.Scanner;

//브랜드, 색상, 가격

//메소드
//시동 킴, 시동 끔
//비밀번호 입력해서 맞으면 시동 킴
class Car {
	int price;
	String brand;
	String color;
	String pw;
	boolean check;// false

	Car() {
		;
	}

	public Car(int price, String brand, String color, String pw) {
		super();
		this.price = price;
		this.brand = brand;
		this.color = color;
		this.pw = pw;
	}

	Boolean turnOn() {
		if (!check) {// 시동이 꺼져 있으면 시동을 켜기
			return true;

		} else {// 시동이 꺼져있으면 false로 해두기
			return false;
		}
	}

	boolean turnOff() {
		if (!check) {// 시동이 꺼져 있으면 시동을 켜기
			return false;

		} else {// 시동이 꺼져있으면 false로 해두기
			return true;
		}

	}

	boolean correctPW(String pw) {
		if (this.pw.equals(pw)) {// 비밀번호 일치하면 시동 켜줌
			return true;
		} else {
			return false;
		}
	}

}

public class Road_remind {
	public static void main(String[] args) {
		Car K9 = new Car(8000, "KIA", "Black", "4589");
		String msg = "1.시동켜기 \n2,시동끄기\n3.나가기";
		String erMSg = "잘못 입력하셨습니다.";
		Scanner sc = new Scanner(System.in);
		int ircorrectNum = 0;
		int choice = 0;
		while (choice != 3) {
			System.out.println(msg);
			choice = sc.nextInt();
			switch (choice) {
			case 1://시동켜기
				if (K9.turnOn()) {
					System.out.print("비밀번호를 입력하세요 :");
					if(K9.correctPW(sc.next())) {//비밀번호 일치
						System.out.println("시동켜기");
						K9.check = true;
					}else {
						ircorrectNum++;
						if (ircorrectNum==3) {
							System.out.println("경찰 출동");
							choice =3;
						}else {
							System.out.println("비밀번호가 일치하지 않습니다");
							System.out.println("(오류횟수 :" + ircorrectNum+"회)");
						}
					}
				}else {
					System.out.println("시동이 켜져있음.");
				}
				break;
			case 2:// 시동 끄기
				if (K9.turnOff()) {
					System.out.println("시동 꺼짐");
					K9.check = false;
				} else {
					System.out.println("시동이 꺼져있음");

				}
				
				break;
			case 3:// 시동 끄기
				System.out.println("나가기");
				break;

			default:
				System.out.println(erMSg);
				break;
			}
		}
		
	}

}
