package account;

public class ValueCheck {
	
	protected String number;
	protected String name;
	protected String accountName;
	protected int accountNumber;
	
	//Input number check
		public void NumberCheck(String number) {
			
			this.number = number;
			//int num = Integer.parseInt(number);
			
			if(!this.number.equals("1")) {
				System.out.println("Please Insert number.\n");
			}
			
			else if(!this.number.equals("2")) {
				System.out.println("Please Insert number.\n");
			}
			
			else if(!this.number.equals("3")) {
				System.out.println("Please Insert number.\n");
			}
			
			else if(!this.number.equals("4")) {
				System.out.println("Please Insert number.\n");
			}
		}

		
		
		
		
		
		//getter & setter
		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
}
