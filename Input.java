package org.coffeebean.common;

import java.util.*;

public class Input {
	
	//Scanner 사용 때 마다 닫지 않아도 됨
	static Scanner scan = new Scanner(System.in);
	
	//enter 전까지 입력 받은 String값 리턴
	public static String read(String title) {
		
		System.out.print(title);
		
		return scan.nextLine();
	}
	
	//숫자 입력 값 리턴
	public static int readInt(String title) {
		
		System.out.print(title);
		int number = scan.nextInt();
		scan.nextLine(); // enter 제거
		
		return number;
	}
}
