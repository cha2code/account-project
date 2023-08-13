package org.blendedcoffee.print;

import org.blendedcoffee.cli.Input;
import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.vo.Member;

public class MemberServiceTest {

	public static void main(String[] args) {
		
		selectMenu();

	}
	
	static void selectMenu() {
		
		while(true) {
			
			System.out.println("-------------------- Select the menu --------------------");		
			String select = Input.read("1.Join  2.Check your account  3.Deposit  4.Withdrawal  5.Exit : ");
			
			switch(select) {
			
			case "1" : //계정 생성
				MemberService ms = new MemberService();
				Member member = ms.inputMember();
				System.out.println(member);
				break;
				
			case "2" : //계좌 확인
				break;
				
			case "3" : //입금
				break;
				
			case "4" : //출금
				break;
				
			case "5" : //프로그램 종료
				System.out.println("프로그램 종료");
				return;
				
			}
		}		
	}
}
