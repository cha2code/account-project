package class_check;

import java.util.*;

public class CreateAccount {
	
	private String name;
	private String accountName;
	private int accountNumber;
	
	public void CreateCustomer() {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("Input your name : ");
	name = scan.next();
	
	//Create account number for customer - 고객 계좌 6자리 랜덤 생성
	Random rand = new Random();
	accountNumber = rand.nextInt(6);
	}
}
