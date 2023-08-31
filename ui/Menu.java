package org.coffeebean.common.ui;

import java.util.ArrayList;
import java.util.List;

import org.coffeebean.common.Input;

public class Menu {
	
	// 메뉴 추가 - 몇 개가 되어도 상관 없이 리스트에 저장
	// 메뉴 추가는 프로그램의 Application에서 구현
	List<MenuItem> list;
	
	// 생성자 - 메뉴 리스트 생성
	public Menu() {
		
		list = new ArrayList<MenuItem>();
	}
	
	// menu Item을 받아서 ArrayList에 추가
	public void add(MenuItem item) {
		
		list.add(item);
	}
	
	// 리스트에 저장 된 메뉴 출력
	public void print() {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%d) %s      ", (i + 1), list.get(i).getMenu());
		}
		System.out.println();
	}
	
	// 메뉴 번호 선택
	public MenuItem select() {
		
		// 배열에 저장하기 위해 입력 받은 번호 -1의 값을 얻음
		int number = Input.readInt("메뉴를 선택하세요 : ") -1;
		
		if(list.size() > number) {
			return list.get(number);
		}
		
		return null;
	}

}
