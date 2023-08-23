package org.blendedcoffee.cli;

import org.blendedcoffee.dao.MemberDao;
import org.blendedcoffee.vo.Member;

public class MemberService {
	
private static MemberDao md = new MemberDao();
	
	//입력 받은 사용자 데이터 리스트에 저장
	public void joinMember(Member member) {
		
		md.addInfo(member);
	}
	
	//리스트에 값이 있는 지 확인
	public int checkData() {
			
		int index = md.checkList();
			
		return index;
	}
		
	//user id 중복 확인
	public int duplicationCheck(String userid) {
		
		int check = md.checkId(userid);
			
		return check;
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
	
	//userid가 일치하는 사용자의 리스트 리턴
	public Member findMember(String userid) {
		
		Member member = md.findByUserid(userid);
		
		return member;
	}
	
	//계좌 입금
	public Member deposit(Member member) {
		
		member = md.depositAccount(member);
		
		return member;
	}

/*	
	
	//계좌 찾아서 출금
	public void withdrawal() {
		
		String userid = md.inputUserId();
		
		Member member = md.findByUserid(userid);
		
		if(member != null) {
			if(member.getBalance() != "0") {
				member = md.withdrawalAccount(member);
				System.out.printf("Total balance : %s\n", member.getBalance());
			}
			
			else {
				System.out.println("Your balance is 0.");
			}
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
				
				if(m != null) {
					String changeName = Input.read("Name : "); //바꿀 이름을 입력받음
					md.updateName(m, changeName); //바꾸려는 계정과 바꿀 이름 업데이트
					
					System.out.println("Change the name is successful!");
				}
				
				break;
				
			case "2" :
				userid = Input.read("Enter your ID : "); //바꾸려는 계정 리스트에서 찾기
				m = md.findByUserid(userid);
				
				if(m != null) {
					String pwd = Input.read("Current your password :");
					boolean tf = md.matchPassword(pwd, m); //기존 비밀번호 확인
					
					if(tf == true) { 
						
						String changePassword = Input.read("Password : "); //바꿀 비밀번호를 입력받음
						md.updatePassword(m, changePassword); //바꾸려는 계정과 바꿀 비밀번호 업데이트
						
						System.out.println("Change the password is successful!");
					}
					
					else {
						System.out.println("Disagreement.");
					}
				}

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
		
		//리스트에 정보가 없을 때 실행
		else {
			System.out.println("No data.");
		}
	}*/
}
