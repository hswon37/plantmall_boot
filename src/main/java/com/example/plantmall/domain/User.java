package com.example.plantmall.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String zipcode;
	private String address;
}
