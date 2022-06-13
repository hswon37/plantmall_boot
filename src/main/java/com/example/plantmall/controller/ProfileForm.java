package com.example.plantmall.controller;

import com.example.plantmall.domain.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ProfileForm {
	
	private final Profile profile = new Profile();
	public Profile getProfile() {
		return profile;
	}
	
	
	

}
