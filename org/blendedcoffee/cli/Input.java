package org.blendedcoffee.cli;

import java.util.*;

public class Input {
	
	//Scanner 사용 때 마다 닫지 않아도 됨
	static Scanner scan = new Scanner(System.in);
	
	//enter 전까지 입력 받은 값 리턴
	public static String read(String title) {
		
		System.out.println(title);
		
		return scan.nextLine();
	}
}
