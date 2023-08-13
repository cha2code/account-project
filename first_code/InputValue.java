package account;

import java.util.*;

public class InputValue implements InputFunctionable {
	
	
	@Override
	public int CollectCheck() { //메뉴 입력 값 예외처리
		
		int number = 0;

		//사용자 입력값 확인
		try {			
			number = InputData();
		}catch(InputMismatchException e) {
			System.out.println("Please enter the number.");
			InputData();
		}
		
		return number;
	}

	@Override
	public int InputData() {  //메뉴 값 입력
		
		System.out.println("-------------------------------------");
		System.out.println("Customer Select Menu");
		System.out.print("1.Create Account  2.Deposit  3.Withdrawal  4.Exit : ");
				
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
				
		return number;
	}

}
