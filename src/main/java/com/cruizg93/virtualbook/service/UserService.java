package com.cruizg93.virtualbook.service;

import com.cruizg93.virtualbook.model.User;

public interface UserService {
	public User findUserByEmail( String email);
	public User findUserByUsername( String username);
	public void saveUser( User user);
}
