package org.blendedcoffee.print;

import org.blendedcoffee.barista.command.AccountInfoCommand;
import org.blendedcoffee.barista.command.DepositCommand;
import org.blendedcoffee.barista.command.JoinCommand;
import org.blendedcoffee.common.cli.command.Input;

public class MemberServiceTest {	
	
	private static JoinCommand join = new JoinCommand();
	private static AccountInfoCommand ac = new AccountInfoCommand();
	private static DepositCommand dc = new DepositCommand();
	
	public static void main(String[] args) {
		
		selectMenu();

	}
	
	static void selectMenu() {
		
		while(true) {
			
			System.out.println("----------------------------- Select the menu -----------------------------");		
			String select = Input.read("1.Join  2.Check your account  3.Deposit  4.Withdrawal  "
					+ "5.Change your information  6.Delete your account  7.Exit : ");
			
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
				//withdrawalInfo();
				break;
				
			case "5" : //정보 수정
				//updateInfo();
				break;
				
				
			case "6" ://계좌 삭제
				//deleteInfo();
				break;
				
			case "7" : //프로그램 종료
				System.out.println("Exit the program.");
				return;
				
				default :
					System.out.println("Please enter the number.");
				
			}
		}		
	}
	
	//case 1 : 사용자가 입력한 ID, Name + 자동 생성 된 계좌 번호 출력 
	static void createInfo() {
		join.execute();

	}
	
	//case 2 : 입력 된 계좌 정보 출력
	static void printInfo() {
		ac.execute();
	}
	
	//case 3 : 입금
	static void depositInfo() {
		dc.execute();		
	}
	/*
	//case 4 : 출금
	static void withdrawalInfo() {
		ms.withdrawal();
	}
	
	//case 5: 정보 수정
	static void updateInfo() {
		ms.update();
	}
	
	//case 6 : 계좌 삭제
	static void deleteInfo() {
		ms.delete();
	}*/
}