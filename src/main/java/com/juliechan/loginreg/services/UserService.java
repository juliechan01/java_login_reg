package com.juliechan.loginreg.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.juliechan.loginreg.models.LoginUser;
import com.juliechan.loginreg.models.User;
import com.juliechan.loginreg.repositories.UserRepo;

@Service
public class UserService {
	// CONNECTING USER REPO
	@Autowired
	private UserRepo uRepo;
	
	// REG & LOGIN METHODS
	public User register(User newUser, BindingResult result) {
		Boolean hasErrors = false; // HELPS SHOW ERRORS ALL AT ONCE
		// DOES EMAIL ALREADY EXIST; IF NOT CREATE USER
		Optional<User> u = uRepo.findByEmail(newUser.getEmail());
		if(u.isPresent()) {
			result.rejectValue("email", "Matches", "User email already in use. Please use a different email.");
			hasErrors = true;
		}
		
		// DO PASSWORDS MATCH; IF MATCH THEN HASH
		if(!newUser.getPw().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "Passwords don't match!");
		    hasErrors = true;
		}
		if(!hasErrors) {
			String hashed = BCrypt.hashpw(newUser.getPw(), BCrypt.gensalt());
			newUser.setPw(hashed);
			return uRepo.save(newUser);							
		}
		else {
			return null;
		}
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		// DOES EMAIL ENTERED MATCH DB
		Optional<User> u = uRepo.findByEmail(newLogin.getEmail());
		if(!u.isPresent()) {
			result.rejectValue("email", "Matches", "This wasn't the email used when registering. Please try again.");
			return null;
		}
		User dbUser = u.get();
		// DOES PW MATCH DB
		if(!BCrypt.checkpw(newLogin.getPw(), dbUser.getPw())) {
		    result.rejectValue("pw", "Matches", "Incorrect password!");
		    return null;
		}
		return dbUser;
	}
	
	// ALL USERS
	public List<User> getAll() {
		return uRepo.findAll();
	}
}