package org.blendedcoffee.common.cli.ui;

import org.blendedcoffee.common.cli.command.Command;

//메뉴 캡슐화
public class MenuItem {
	
	//인스턴스 생성
	private String menu; //메뉴 이름
	private Command cmd; //메뉴를 실행할 명령
	
	//생성자 (인스턴스 변수에 접근)
	public MenuItem(String menu, Command cmd) {
		
		super();
		this.menu = menu;
		this.cmd = cmd;
	}
	
	//Getter
	public String getMenu() {
		return menu;
	}

	public void execute() {
		
		if(cmd != null) {
			cmd.execute();
		}
	}

}
