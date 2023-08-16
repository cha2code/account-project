package org.blendedcoffee.cli;

import org.blendedcoffee.dao.MemberDao;
import org.blendedcoffee.vo.Member;

public class MemberService {
	
	private static MemberDao md = new MemberDao();
	
	public void joinMember() {
		
		Member member = inputMember();
		md.addInfo(member);
	}
	
	//가입 시 정보 입력 받은 후 리스트 생성
	public Member inputMember() {
		
		String userid = md.inputUserId();
		String password = Input.read("Password : ");
		String name = Input.read("Name : ");
		String accountNumber = createAccount();
		String balance = "0";
		
		Member member = new Member(userid, password, name, accountNumber, balance);
		
		return member;
	}
	
	//리스트에 저장 된 고객 정보 출력
		public void printMember() {
			
			int index = md.checkList();
			
			if(index == 1) {
				
				String userid = md.inputUserId();
				//System.out.println("userid:"+userid);

				Member member = md.findByUserid(userid);
				
				System.out.printf("ID : %s\n", member.getUserid());			
				System.out.printf("Name : %s\n", member.getName());
				System.out.printf("Account number : %s\n", member.getAccountNumber());
				System.out.printf("Balance : %s\n", member.getBalance());
			}
			else {
				System.out.println("No data.");
			}
		}
	
	//계좌 번호 랜덤 생성 000000-00-000000
	public String createAccount() {
		
		while(true) {
			
			String accountNumber = "";
			RandomNumber rn = new RandomNumber();
			accountNumber = rn.randomNumber();
			
			int index = md.checkAccount(accountNumber);
			
			if(index == 1) {
				return accountNumber;
			}
			
		}
	}
	
	//계좌 찾아서 입금
	public void deposit() {
		
		String userid = md.inputUserId();
		
		Member member = md.findByUserid(userid);
		
		member = md.depositAccount(member);
		
		System.out.printf("Total blance : %s\n", member.getBalance());
	}
	
	//계좌 찾아서 출금
	public void withdrawal() {
		
		String userid = md.inputUserId();
		
		Member member = md.findByUserid(userid);
		
		member = md.withdrawalAccount(member);
		
		System.out.printf("Total balance : %s\n", member.getBalance());
	}
	
	//고객 정보 삭제
	public void delete() {
		
		int index = md.checkList();
		
		if(index == 1) {
			
			String userid = md.inputUserId();
			Member member = md.findByUserid(userid);
			boolean tf = md.deleteInfo(member);
			
			if(tf == true) {
				System.out.println("Deleted.");
			}
			else {
				System.out.println("not deleted.");
			}
		}
		else {
			System.out.println("No data.");
		}
		
	}
}
