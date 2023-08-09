package account;

public class Index {

	public static void main(String[] args) {		
		
		String name;
		int accountNumber;
		
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
			
		case 2:	
			//Deposit dep = new Deposit();
		
		case 3:		
			//Withdrawal wd = new Withdrawal();
				
		case 4:	 
			//CheckBalance cb = new CheckBalance();
		
		case 5:
			System.out.println("Account program exit.");
			return;		
		}
		
	}

}
