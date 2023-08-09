package account;

import java.util.*;

public class InputValue implements InputFunctionable {
	
	@Override
	public int InputNumber() {
		
		//사용자 메뉴 출력		
		System.out.println("-------------------------------------");
		System.out.println("Customer Select Menu");
		System.out.print("1.Create Account  2.Deposit  3.Withdrawal  4.Check the balance  5.Exit : ");
				
		//사용자에게 메뉴 입력 받기
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
				
		return number;
	}


	@Override
	public int CollectCheck() {
		
		int number = 0;

		//사용자 입력값 확인
		try {			
			number = InputNumber();
		}catch(InputMismatchException e) {
			System.out.println("Please Input number.");
			InputNumber();
		}
		
		return number;
	}

}
