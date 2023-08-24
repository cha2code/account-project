package org.blendedcoffee.cli;

import org.blendedcoffee.common.cli.command.Input;
import org.blendedcoffee.dao.MemberDao;
import org.blendedcoffee.vo.Member;

public class MemberService {
	
private static MemberDao md = new MemberDao();
	
	//입력 받은 사용자 데이터 리스트에 저장
	public void saveList(Member member) {
		
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
	
	//계좌 출금
	public Member withdrawal(Member member) {
		
		member = md.withdrawalAccount(member);
		
		return member;
	}
	
	//비밀번호 확인
	public boolean checkPassword(Member member, String pwd) {
		
		boolean tf = md.matchPassword(pwd, member);
		
		return tf ? true : false;
	}
	
	//사용자 삭제
	public boolean delete(Member member) {
		
		while(true) {
			
			String yesNo = Input.read("Continue? y/n : ");
			
			if(yesNo.equalsIgnoreCase("y")) {
				
				boolean tf = md.deleteInfo(member);
				
				if(tf == true) {
					return true;
				}
				return false;
			}
			else if(yesNo.equalsIgnoreCase("n")) {
				System.out.println("Canceled.");
				return false;
			}
			else {
				System.out.println("Please enter the y/n.");
			}
		}
		
	}
}
