package org.blendedcoffee.dao;

import java.util.ArrayList;
import java.util.List;

import org.blendedcoffee.cli.Input;
import org.blendedcoffee.cli.RandomNumber;
import org.blendedcoffee.vo.Member;

import lombok.Getter;

public class MemberDao {

	@Getter
	private List<Member> memberList; //고객 정보 저장 리스트

	public MemberDao() {
			memberList = new ArrayList<Member>();	
	}
	
	//리스트에 고객 정보 저장
	public void addInfo(Member info) {
		
		memberList.add(info);
	}
	
	//리스트에 정보가 있는 지 확인
		public int checkList() {
			
			if(memberList.size() == 0) {
				return 0;
			}
			else {
				return 1;
			}
		}
	
	//userid 입력
	public String inputUserId() {
					
		String userid = Input.read("ID : ");
			
		return userid;
				
	}
	
	//ID 중복 찾기
	public boolean checkId(String userid) {
		
		for(int i = 0; i < memberList.size(); i++ ) {
			if(userid.equals(memberList.get(i).getUserid())) {
				return false;
			}
		}
		
		return true;
	}
	
	//ID를 기준으로 고객 정보 찾기
	public Member findByUserid(String userid) {
		
		Member member = new Member();
		
		for(int i = 0; i < memberList.size(); i++) {
			member = memberList.get(i);
			if(member.getUserid().equals(userid) == true) {
				return member;
			}
		}
		System.out.println("Without your account.");
		
		return null;
		
	}
	
	//계좌 번호 랜덤 생성 000000-00-000000
		public String createAccount() {
			
			while(true) {
				
				String accountNumber = "";
				RandomNumber rn = new RandomNumber();
				accountNumber = rn.randomNumber();
				
				int index = checkAccount(accountNumber);
				
				if(index == 1) {
					return accountNumber;
				}
				
			}
		}
	
	//계좌 번호 중복 확인
		public int checkAccount(String account) {
				
			for(int i = 0; i < memberList.size(); i++) {
				Member member = memberList.get(i);
				if(member.getAccountNumber().equals(account)) {
					return 0;
				}
			}
			return 1;
	}
	
	//입금
	public Member depositAccount(Member m) {
		
		while(true) {
			
			String money = Input.read("How much? : ");
			
			//입력 받은 값이 숫자인 지 판단 후 계산
			try {
				Integer.parseInt(money);
				
				int result = Integer.parseInt(m.getBalance()); //member에 저장 된 잔액을 int형으로 변환
				int deposit = Integer.parseInt(money); //money에 저장 된 입금액을 int형으로 변환
				
				result += deposit;
				
				money = Integer.toString(result); //잔액+입금액한 결과를 String으로 변환
				
				
				
				m.setBalance(money); //리스트에 잔액 저장
				
				return m;

			} catch (NumberFormatException e) {
				System.out.println("Please enter the number.");
			}
			
		}
	}
	
	//출금
	public Member withdrawalAccount(Member m) {
		
		while(true) {
			
			String money = Input.read("How much? : ");
			
			//입력 받은 값이 숫자인 지 판단 후 계산
			try {
				Integer.parseInt(money);
				
				int result = Integer.parseInt(m.getBalance()); //member에 저장 된 잔액을 int형으로 변환
				int withdrawal = Integer.parseInt(money); //money에 저장 된 출금액을 int형으로 변환
				
				if(result < withdrawal) { //잔액 < 출금액
					return null;
				}
				
				result -= withdrawal;
				
				money = Integer.toString(result); //잔액+입금액한 결과를 String으로 변환
				
				m.setBalance(money); //리스트에 잔액 저장
				
				return m;

			} catch (NumberFormatException e) {
				System.out.println("Please enter the number.");
			}
			
		}
	}
	
	//고객 정보 삭제
	public boolean deleteInfo(Member info) {
		
		System.out.println("Check the account to delete.");
		System.out.printf("Id : %s\n", info.getUserid());
		System.out.printf("Name : %s\n", info.getName());
		System.out.printf("Account number : %s\n", info.getAccountNumber());
		
		while(true) {
			
			String yesNo = Input.read("Continue? y/n : ");
			
			if(yesNo.equalsIgnoreCase("y")) {
				
				return memberList.remove(info);
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
	
	//고객 이름 변경
	public void updateName(Member m, String name) {
		
		m.setName(name);
	} 
	
	//고객 비밀번호 변경
	public void updatePassword(Member m, String password) {
		
		m.setPassword(password);
	} 
}
