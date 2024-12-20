package com.tutorial.employeemanagmentbackend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity


public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @NotBlank(message = "Password is required")
    private String password;

    private String role;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(new SimpleGrantedAuthority(role));
	}
	@Override
	public String getPassword() {
		
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	public User(Long id, String email, @NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Phone Number is required") String phoneNumber,
			@NotBlank(message = "Password is required") String password, String role, List<Booking> bookings) {
		
		this.id = id;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.bookings = bookings;
	}
	public User() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	

}
