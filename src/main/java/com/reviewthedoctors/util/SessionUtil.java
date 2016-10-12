package com.reviewthedoctors.util;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SessionUtil {
	
	public static final  com.reviewthedoctors.model.entity.User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			User user = (User) principal;
			com.reviewthedoctors.model.entity.User userOne = new com.reviewthedoctors.model.entity.User();
			userOne.setEmail(user.getUsername());
			Collection<GrantedAuthority> authorities =user.getAuthorities();
			for(GrantedAuthority authority :authorities){
				userOne.setAuthority(authority.getAuthority());
			}
		
			return userOne;
		}
		return null;
	}
}
