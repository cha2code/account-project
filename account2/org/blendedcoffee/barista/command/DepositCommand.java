package org.blendedcoffee.barista.command;

import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.common.cli.command.Command;
import org.blendedcoffee.common.cli.command.Input;
import org.blendedcoffee.vo.Member;

public class DepositCommand implements Command {
	
	private static MemberService ms = new MemberService();
	
	@Override
	public void execute() {
		
		int check = ms.checkData();
		
		if(check != 0) {
		
			String userid = Input.read("ID : ");
			Member member = ms.findMember(userid); //입력 받은 ID에 대한 데이터 확인
			
			if(member != null) {
				member = ms.deposit(member);
				System.out.printf("Total blance : %s\n", member.getBalance());
			}
			
		}
		
	}

}
