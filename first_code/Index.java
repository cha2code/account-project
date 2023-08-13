package account;

public class Index {

	public static void main(String[] args) {		
		
		String name;
		int accountNumber = 0;
		int money = 0;
		int balance = 0;
		
		
		while(true) {
		
			//사용자 메뉴 호출
			InputValue iv = new InputValue();
			int number = iv.CollectCheck();
		
			//메뉴 선택에 따라 해당 클래스 실행
			switch(number) {
		
			case 1:
				CreateAccount ca_name = new CreateAccount();
				name = ca_name.NameCustomer(); //이름 입력 메서드 호출
			
				CreateAccount ca_number = new CreateAccount();
				accountNumber = ca_number.AccountCustomer(); //계좌번호 6자리 난수 생성 메서드 호출
				
				//사용자 입력 이름, 생성된 계좌번호 출력			
				System.out.printf("Your name : %s\nYour account number : %d\n", name, accountNumber);
				break;
			
			case 2:	
				Deposit dep = new Deposit();
				money = dep.CollectCheck(); //입금할 금액 입력 메서드 호출
				
				balance += money; //잔액 + 입금금액
				
				//입금 금액 및 잔액 출력
				System.out.printf("Your deposit : %d\n", money);
				System.out.printf("Balance : %d\n", balance);
				break;
		
			case 3:		
				Withdrawal wd = new Withdrawal();
				money = wd.CollectCheck(); //출금할 금액 입력 메서드 호출
				
				balance -= money; // 잔액 - 출금 금액
				
				//출금 금액 및 잔액 출력
				System.out.printf("Your withdrawal : %d\n", money);
				System.out.printf("Balance : %d\n", balance);
				break;
		
			case 4:
				System.out.println("Account program exit."); //프로그램 종료
				return;		
			}
		}
	}
}
