package org.blendedcoffee.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Member {
	
	//입력 받을 변수
	private String userid;
	private String password;
	private String name;
	private String accountNumber;
	private String balance;

}
