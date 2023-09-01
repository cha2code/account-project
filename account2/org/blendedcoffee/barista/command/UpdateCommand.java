package org.blendedcoffee.barista.command;

import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.common.cli.command.Command;
import org.blendedcoffee.common.cli.command.Input;
import org.blendedcoffee.vo.Member;

public class UpdateCommand implements Command {
	
	private static MemberService ms = new MemberService();

	@Override
	public void execute() {
		
		while(true) {
			
			System.out.println("----- Update menu -----");		
			String menu = Input.read("1.Name  2.Password  3.Return to the menu");
			
			String userid;
			Member member;
			
			switch(menu) {
			
			case "1" :
				userid = Input.read("Enter your ID : "); //바꾸려는 계정 리스트에서 찾기
				member = ms.findMember(userid);
				
				if(member != null) {
					String changeName = Input.read("Name : "); //바꿀 이름 입력
					member.setName(changeName); //변경할 name 저장
					ms.saveList(member); //바꾸려는 계정 업데이트
					
					System.out.println("Change the name is successful!");
				}
				
				break;
				
			case "2" :
				userid = Input.read("Enter your ID : "); //바꾸려는 계정 리스트에서 찾기
				member = ms.findMember(userid);
				
				if(member != null) {
					String pwd = Input.read("Current your password :");
					boolean tf = ms.checkPassword(member, pwd); //기존 비밀번호 확인
					
					if(tf == true) { 
						
						String changePassword = Input.read("Password : "); //바꿀 비밀번호를 입력받음
						member.setPassword(changePassword); //변경할 password 저장
						ms.saveList(member); //바꾸려는 계정과 바꿀 비밀번호 업데이트
						
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

}
