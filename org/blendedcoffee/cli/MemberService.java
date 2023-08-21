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
		
		while(true) {
			
			String userid = md.inputUserId();
			
			boolean tf = md.checkId(userid); 
			
			if(tf == true) {
				
				String password = Input.read("Password : ");
				String name = Input.read("Name : ");
				String accountNumber = md.createAccount();
				String balance = "0";
				
				Member member = new Member(userid, password, name, accountNumber, balance);
				
				return member;
			}
			
			System.out.println("Duplicate ID.");
		}
	}
	
	//리스트에 저장 된 고객 정보 출력
		public void printMember() {
				
				int index = md.checkList();
				
				if(index == 1) {
					
					String userid = md.inputUserId();

					Member member = md.findByUserid(userid);
					
					if(member != null) {
						
						System.out.printf("ID : %s\n", member.getUserid());			
						System.out.printf("Name : %s\n", member.getName());
						System.out.printf("Account number : %s\n", member.getAccountNumber());
						System.out.printf("Balance : %s\n", member.getBalance());
					}				
					
				}
				else {
					System.out.println("No data.");
				}			
		}
	
	//계좌 찾아서 입금
	public void deposit() {
		
		String userid = md.inputUserId();
		
		Member member = md.findByUserid(userid);
		
		if(member != null) {
			member = md.depositAccount(member);
			System.out.printf("Total blance : %s\n", member.getBalance());
		}
		else {
			System.out.println("No data.");
		}
	}
	
	//계좌 찾아서 출금
	public void withdrawal() {
		
		String userid = md.inputUserId();
		
		Member member = md.findByUserid(userid);
			
		member = md.withdrawalAccount(member);
		
		if(member != null) {
		System.out.printf("Total balance : %s\n", member.getBalance());
		}
		else {
			System.out.println("Insufficient funds.");
		}

	}
	
	//고객 정보 업데이트 - 이름, 비밀번호 (ID, 계좌 번호는 고정)
	public void update() {
		
		while(true) {
			
			System.out.println("----- Update menu -----");		
			String menu = Input.read("1.Name  2.Password  3.Return the menu");
			
			String userid;
			Member m;
			
			switch(menu) {
			
			case "1" :
				userid = Input.read("Enter your ID : "); //바꾸려는 계정 리스트에서 찾기
				m = md.findByUserid(userid);
				
				String changeName = Input.read("Name : "); //바꿀 이름을 입력받음
				md.updateName(m, changeName); //바꾸려는 계정과 바꿀 이름 업데이트
				
				System.out.println("Change the name is successful!");
				break;
				
			case "2" :
				userid = Input.read("Enter your ID : "); //바꾸려는 계정 리스트에서 찾기
				m = md.findByUserid(userid);
				
				String changePassword = Input.read("Password : "); //바꿀 비밀번호를 입력받음
				md.updatePassword(m, changePassword); //바꾸려는 계정과 바꿀 비밀번호 업데이트
				
				System.out.println("Change the password is successful!");
				break;
				
			case "3" :
				return;
				
			default : 
				System.out.println("Please enter the number.");
				break;
			}
		}
	}
	
	//고객 정보 삭제
	public void delete() {
		
		int index = md.checkList();
		
		//리스트에 정보가 하나라도 있을 때 실행
		if(index == 1) {
			
			String userid = md.inputUserId();
			Member member = md.findByUserid(userid);
			
			if(member != null) {
				
				boolean tf = md.deleteInfo(member);
				
				if(tf == true) {
					System.out.println("Deleted.");
				}
				else {
					System.out.println("not deleted.");
				}
			}
		}
		
		//리스트에 정보가 하나도 없을 때 실행
		else {
			System.out.println("No data.");
		}
	}
}
