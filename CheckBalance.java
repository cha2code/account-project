package account;

public class CheckBalance {

	protected int balance;
	
	public void ResultBalance(int balance) {
		
		this.balance = balance;
		
		if(balance == 0) {
			System.out.println("잔액이 없습니다.");
		}
		
		System.out.println("잔액 : " + balance);
	}

}
