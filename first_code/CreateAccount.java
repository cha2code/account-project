package account;

import java.util.*;

public class CreateAccount {
	
	//고객 이름 입력
	protected String NameCustomer() {

		System.out.println("------------------------");
		System.out.print("Insert your name : ");
		
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		
		return name;
		
	}

	//고객 계좌번호 6자리 랜덤 생성
	protected int AccountCustomer() {
		
		int accountNumber = 0;
		
		accountNumber = (int)(Math.random() * 899999) + 100000;
		
		return accountNumber;
	}
}
