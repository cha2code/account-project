package org.blendedcoffee.barista.command;

import org.blendedcoffee.cli.MemberService;
import org.blendedcoffee.common.cli.command.Command;
import org.blendedcoffee.common.cli.command.Input;
import org.blendedcoffee.vo.Member;

public class JoinCommand implements Command {
	
	private static MemberService ms = new MemberService();

	@Override
	public void execute() {
		
		//가입 시 정보 입력 받은 후 리스트 생성
		while(true) {
			
			String userid = Input.read("ID : ");
			int check = ms.duplicationCheck(userid);
			
			if(check != 0) { //리스트에 저장 된 userid 중 같은 값이 없을 때
				String password = Input.read("Password : ");
				String name = Input.read("Name : ");
				String accountNumber = ms.createAccount();
				String balance = "0";
					
				Member member = new Member(userid, password, name, accountNumber, balance);
					
				ms.saveList(member); //리스트에 저장
				
				System.out.printf("Welcome %s!\n", userid);
				break;
			}
				
			System.out.println("Duplicate ID.");
		}
		
	}

	
}
