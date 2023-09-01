package class_check;

import java.util.*;

public class InsertValue {
	
		//Select from customer	
	public String Insert() {
		
		Scanner scan = new Scanner(System.in);
		String number;
		
		//Menu select loop - 맞는 번호 
		
		System.out.print("Select Menu Number\n");
		System.out.print("--------------------\n");
		System.out.print("1. Create Account  2. Deposit  3. Withdrawal  4. Check your balance  5. Exit : ");
		
		number = scan.next();
		
		//Check whether the number or not - 1~5까지 맞게 입력했는지 확인
		if(number.equals("1") == false) {
			System.out.println("Please Insert number.\n");
		}
		else if(number.equals("2") == false) {
			System.out.println("Please Insert number.\n");
		}
		else if(number.equals("3") == false) {
			System.out.println("Please Insert number.\n");
		}
		else if(number.equals("4") == false) {
			System.out.println("Please Insert number.\n");
		}
		else if(number.equals("5") == false) {
			System.out.println("Please Insert number.\n");
		}
		
		//return to main - 입력 값 메인 함수로 반환
		return number;
		
		
	}
}
