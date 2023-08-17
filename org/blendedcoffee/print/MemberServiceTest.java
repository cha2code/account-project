package org.blendedcoffee.print;

import org.blendedcoffee.cli.Input;
import org.blendedcoffee.cli.MemberService;

public class MemberServiceTest {	
	
	static MemberService ms = new MemberService();
	
	public static void main(String[] args) {
		
		selectMenu();

	}
	
	static void selectMenu() {
		
		while(true) {
			
			System.out.println("----------------------------- Select the menu -----------------------------");		
			String select = Input.read("1.Join  2.Check your account  3.Deposit  4.Withdrawal  5.Delete your account  6.Exit : ");
			
			switch(select) {
			
			case "1" : //계정 생성
				createInfo();
				break;
				
			case "2" : //계좌 확인
				printInfo();			
				break;
				
			case "3" : //입금
				depositInfo();
				break;
				
			case "4" : //출금
				withdrawalInfo();
				break;
				
			case"5" : //계좌 삭제
				deleteInfo();
				break;
				
			case "6" : //프로그램 종료
				System.out.println("Exit the program.");
				return;
				
			}
		}		
	}
	
	//case 1 : 사용자가 입력한 ID, Name + 자동 생성 된 계좌 번호 출력 
	static void createInfo() {
		ms.joinMember();

	}
	
	//case 2 : 입력 된 계좌 정보 출력
	static void printInfo() {
		ms.printMember();
		
	}
	
	//case 3 : 입금
	static void depositInfo() {
		ms.deposit();
		
	}
	
	//case 4 : 출금
	static void withdrawalInfo() {
		ms.withdrawal();
	}
	
	//case 5 : 계좌 삭제
	static void deleteInfo() {
		ms.delete();
	}
}
