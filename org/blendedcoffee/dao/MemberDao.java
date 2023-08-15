package org.blendedcoffee.dao;

import lombok.Getter;
import java.util.*;

import org.blendedcoffee.cli.Input;
import org.blendedcoffee.vo.Member;

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
	
	//userid 입력
	public String inputUserId() {
					
			String userid = Input.read("ID : ");
			
			return userid;
				
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
		
		return null;
		
		/*
		int max_index = 0;
		int uid_pos = 0;

		Member array_output = new Member();
		
		max_index = memberList.size();
		
		System.out.println("max_index:"+max_index);
		
		for(int array_idx = 0; array_idx < max_index; array_idx++) {
			array_output = memberList.get(array_idx);
			if(array_output.getUserid().equals(userid) == true) {
				uid_pos = array_idx;
				break;
			}
		}
		array_output = memberList.get(uid_pos);
		return array_output;
		*/
		
	}
	
	//입금
	public Member depositAccount(Member m) {
		
		String money = Input.read("How much? : ");
		
		int result = Integer.parseInt(m.getBalance());
		int deposit = Integer.parseInt(money);
		
		result += deposit;
		
		money = Integer.toString(result);
		
		memberList.get(0).setBalance(money);
		
		return m;
	}
	
	//출금
		public Member withdrawalAccount(Member m) {
			
			String money = Input.read("How much? : ");
			
			int result = Integer.parseInt(m.getBalance());
			int withdrawal = Integer.parseInt(money);
			
			if(result < withdrawal) {
				
				System.out.println("Insufficient funds.");
				
				return null;
			}
			
				result -= withdrawal;
				
				money = Integer.toString(result);
				
				memberList.get(0).setBalance(money);
				
				return m;
		}
	
	
	//고객 정보 변경 (userid를 기준으로 찾아서 변경)
	public Member updateInfo(Member info) {
		
		for(int i = 0;  i <= memberList.size(); i++) {
			if(info.getUserid().equals(memberList.get(i).getUserid())) {
				memberList.get(i).getBalance();
			}
		}
		
		return null;
	}
	
	//고객 정보 삭제
	public Member deleteInfo(Member info) {
		
		return null;
	}
}
