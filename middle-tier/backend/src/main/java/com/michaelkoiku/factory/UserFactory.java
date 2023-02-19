package com.michaelkoiku.factory;

import com.michaelkoiku.user.User;

//This class implements the Factory Method and Singleton design pattern
public class UserFactory extends Factory {
	private static UserFactory instance;
	
	private UserFactory() {}
	
	public static UserFactory getInstance() {
		if(instance == null) {
			instance = new UserFactory();
		}
		return instance;
	}

	@Override
	public Entity createEntity() {
		return new User();
	}

}
