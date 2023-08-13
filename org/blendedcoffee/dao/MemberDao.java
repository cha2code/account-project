package org.blendedcoffee.dao;

import lombok.Getter;
import java.util.*;

import org.blendedcoffee.cli.Input;
import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.vo.Member;

public class MemberDao {

	@Getter
	//고객 정보 저장 리스트
	List<Member> memberList;
	
	public MemberDao() {
		
		
		
	}
	
	//리스트에 고객 정보 저장
	public void addInfo(Member info) {
		
		memberList.add(info);
		
	}
	
	//고객 정보 변경 (userid를 기준으로 찾아서 변경)
	public Member updateInfo(Member info) {
		
		return null;
	}
	
	//고객 정보 삭제
	public Member deleteInfo(Member info) {
		
		return null;
	}

}
