package org.coffeebean.common.ui;

import org.coffeebean.common.cli.command.ExitCommand;

//Template Method Pattern
//구현이 안 되어 있거나 수정이 필요한 부분만 자식이 구현
//부모 클래스로만 사용하기 위해 추상클래스로 선언
public abstract class Application {

	private Menu menu;
	
	// 메뉴 생성 - 프로그램마다 구현하는 메뉴가 다름
	public void createMenu(Menu menu) {
		
	}
	
	// 메뉴 초기화
	public void init() {
		
		menu = new Menu();
		createMenu(menu);
		
		//모든 프로그램에서 종료 사용 (자기 자신을 종료)
		menu.add(new MenuItem("종료", new ExitCommand(this)));
	}
	
	// 연결 종료
	// 프로그램마다 사용한 연결들이 다름
	public void cleanUp() {
		
	}
	
	// 실행 - Application의 부모 역할 method
	public void run() {
		
		init(); // 메뉴 초기화
		
		// 메뉴 출력 및 입력 - 입력 값이 맞을 때 까지 무한루프
		while(true) {
			
			menu.print();
			MenuItem item = menu.select();
			
			if(item != null) {
				item.execute();
				System.out.println();
			}
		}
	}
}
