package account;

import java.util.*;

public class Deposit implements InputFunctionable {

	@Override
	public int CollectCheck() {
		
		int money = 0;
		
		try {
			money = InputData();
		}catch(InputMismatchException e) {
			System.out.println("Please enter the number.");
			InputData();
		}
		return money;
	}

	@Override
	public int InputData() {

		System.out.println("-------------------------------------");
		System.out.print("How much would you like to deposit? : ");
		
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		
		return money;
	}
}
