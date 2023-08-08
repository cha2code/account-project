package account;

import java.util.*;

public class Index {

	public static void main(String[] args) {
		
		//고객의 이름, 계좌번호, 잔액 저장
		String customerName;
		int accountNumber = 0;
		int balance = 0;
		
		//사용자가 잘못 입력하거나 종료 하기 전까지 반복
		System.out.print("Select Menu Number\n");
		System.out.print("--------------------\n");
		System.out.print("1. Create Account  2. Deposit  3. Withdrawal  4. Check your balance  5. Exit : ");
		
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		
		//Check whether the number or not - 1~5까지 맞게 입력했는지 확인
		ValueCheck vc = new ValueCheck();
		vc.NumberCheck(number);
				
		//Select number menu
		if(number.equals("1")==true) {
			CreateAccount ca1 = new CreateAccount(null, 0);
			customerName = ca1.CreateCustomer();
					
			CreateAccount ca2 = new CreateAccount(null, 0);
			accountNumber = ca2.CreateAccountNumber();
			}
				
			else if(number.equals("2")==true) {
				Deposit dep = new Deposit(null, null, 0);
				int deposit = dep.DepositCustomer();
				balance += deposit;
			}
				
			else if(number.equals("3")==true) {
				//withdrawal
				//Withdrawal wd = new Withdrawal(balance);
				//int withdrawal = wd.Withdrawal();
				//balance -= withdrawal;
			}
				
			else if(number.equals("4")==true) {
				CheckBalance cb = new CheckBalance();
				cb.ResultBalance(balance);
			}
				
			else if(number.equals("5")==true) {
				return;
			}
		
	}

}
