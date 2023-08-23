package org.blendedcoffee.barista.command;

import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.common.cli.command.Command;
import org.blendedcoffee.common.cli.command.Input;
import org.blendedcoffee.vo.Member;

public class AccountInfoCommand implements Command {
	
	private static MemberService ms = new MemberService();

	@Override
	public void execute() {
		
		int check = ms.checkData(); //리스트 내 데이터 유무 확인
		
		if(check != 0) {

			String userid = Input.read("ID : ");
			Member member = ms.findMember(userid); //입력 받은 ID에 대한 데이터 확인
			
			//입력 받은 ID에 해당하는 데이터가 있을 때 실행
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
}
