package account;

import java.util.*;

public class CreateAccount extends ValueCheck {
	
	CreateAccount(String name, int accountNumber){
		super();
	}
	
	//고객 이름 입력
	public String CreateCustomer() {
		
		Scanner input = new Scanner(System.in);
	
		System.out.print("Input your name : ");
		name = input.next();
		
		return name;
	}
	
	//Create account number for customer - 고객 계좌 6자리 랜덤 생성
	public int CreateAccountNumber() {
		
		Random rand = new Random();
		accountNumber = rand.nextInt(6);
		
		return accountNumber;
	}

}
