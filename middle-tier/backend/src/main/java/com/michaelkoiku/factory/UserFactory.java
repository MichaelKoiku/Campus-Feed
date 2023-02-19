package com.michaelkoiku.factory;

import com.michaelkoiku.user.User;

//This class implements the Factory Method design pattern
public class UserFactory extends Factory {

	@Override
	public Entity createEntity() {
		return new User();
	}

}
