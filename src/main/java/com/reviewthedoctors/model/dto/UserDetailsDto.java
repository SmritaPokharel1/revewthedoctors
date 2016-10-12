package com.reviewthedoctors.model.dto;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.reviewthedoctors.model.entity.User;
import com.reviewthedoctors.util.StringConstants;

public class UserDetailsDto implements  UserDetails, Serializable, Comparable<UserDetailsDto> {
	/** * */
	private static final long serialVersionUID = 1L;
	private final Collection<GrantedAuthority> authorities;
	private final User user;
	private String remoteAddress;

	public UserDetailsDto(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	public UserDetailsDto(User user, Collection<GrantedAuthority> authorities, String remoteAddress) {
		this.user = user;
		this.authorities = authorities;
		this.remoteAddress = remoteAddress;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		if (user.getUserStatus().equals(StringConstants.USER_STATUS_DELETED)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if (user.getUserStatus().equals(StringConstants.USER_STATUS_DELETED)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if (user.getUserStatus().equals(StringConstants.USER_STATUS_ACTIVE)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEnabled() {
		if (user.getUserStatus().equals(StringConstants.USER_STATUS_ACTIVE)) {
			return true;
		}
		return false;
	}

	public User getUser() {
		return user;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserDetailsDto) {
			return ((UserDetailsDto) obj).getUser().getUserId()==user.getUserId();
		}
		return false;
	}

	@Override
	public int compareTo(UserDetailsDto userDetails) {
		return 0;
	}

	@Override
	public String toString() {
		return "user" + user.getUserId();
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(user.getUserId() + "");
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

}