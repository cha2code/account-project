package org.blendedcoffee.cli;

import org.blendedcoffee.dao.MemberDao;
import org.blendedcoffee.vo.Member;

public class MemberService {
	
	MemberDao memberdao = new MemberDao();
	
	//가입 시 정보 입력 받은 후 리스트 생성
	public Member inputMember() {
		
		String userid = inputUserId();
		String password = Input.read("Password : ");
		String name = Input.read("Name : ");
		String accountNumber = createAccount();
		String balance = "0";
		
		Member member = new Member(userid, password, name, accountNumber, balance);
		
		return member;
	}
	
	//userid 입력
	public String inputUserId() {
				
		String userid = Input.read("ID : ");
		
		return userid;
			
	}
	
	//계좌 번호 랜덤 생성 000000-00-000000
	public String createAccount() {
		
		String accountNumber = "";
		
		RandomNumber rn = new RandomNumber();
		accountNumber = rn.randomNumber();
		
		return accountNumber;
	}
}
