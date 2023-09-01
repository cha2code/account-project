package org.blendedcoffee.barista.command;

import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.common.cli.command.Command;
import org.blendedcoffee.common.cli.command.Input;
import org.blendedcoffee.vo.Member;

public class DeleteCommand implements Command {
	
	private static MemberService ms = new MemberService();

	@Override
	public void execute() {
		
		int check = ms.checkData();
		
		//리스트에 정보가 하나라도 있을 때 실행
		if(check != 0) {
			
			String userid = Input.read("Enter your ID : ");
			Member member = ms.findMember(userid);
			
			if(member != null) {
				
				boolean tf = ms.delete(member);
				
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
		
	}

}
