package com.moviebookingapp.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moviebookingapp.models.User;

//UserDetails simply store user information which is later encapsulated into Authentication objects. 
public class UserDetailsImpl implements UserDetails {

	private ObjectId _id;

	private String loginId;

	private String firstName;

	private String lastName;

	private String email;

	private Long contactNumber;

	@JsonIgnore
	private String password;

	//Represents an permissions granted to an Authentication object. 
	private Collection<? extends GrantedAuthority> authorities;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public UserDetailsImpl(ObjectId _id, String loginId, String firstName, String lastName, String email,
			Long contactNumber, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this._id = _id;
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.authorities = authorities;
	}

	public UserDetailsImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserDetailsImpl(user.get_id(), user.getUsername(), user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getContactNumber(), user.getPassword(), authorities);
	}

	@Override
	public String getUsername() {
		return loginId;
	}
	
	public void setUsername(String loginId) {
		this.loginId=loginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(_id, user._id);
	}

}