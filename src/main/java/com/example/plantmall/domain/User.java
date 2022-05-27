package com.example.plantmall.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class User {
	@NotNull
	private String userId;
	@NotNull
	private String userName;
	
	@NotNull
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[~!@#$%^&*])[a-zA-z\\d]{8,}")
	private String password;
	
	@NotNull
	@Pattern(regexp = "^[\\w]+@[\\w]+\\.[\\w]*\\.[\\w]{2,3}")
	private String email;
	
	@Pattern(regexp="^01[01679]-\\d{3,4}-\\d{4}")
	private String phone;
	
	@Pattern(regexp = "\\d{5}")
	private String zipcode;
	private String address;
	
	public User(@NotNull String userId, @NotNull String userName,
			@NotNull @Pattern(regexp = "^(?=.*[A-Z])(?=.*[~!@#$%^&*])[a-zA-z\\d]{8,}") String password,
			@NotNull @Pattern(regexp = "^[\\w]+@[\\w]+\\.[\\w]*\\.[\\w]{2,3}") String email,
			@Pattern(regexp = "^01[01679]-\\d{3,4}-\\d{4}") String phone, @Pattern(regexp = "\\d{5}") String zipcode,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address = address;
	}
	
	
}