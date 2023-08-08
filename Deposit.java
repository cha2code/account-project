package account;

import java.util.*;

public class Deposit extends ValueCheck {
	
	protected int money;
	
	Deposit(String accountName, String accountNumber, int money){
		super();
	}
	
	public int DepositCustomer() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Input money : ");
		money = scan.nextInt();
		
		return money;
	}

}
