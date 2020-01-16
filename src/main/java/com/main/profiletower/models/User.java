package com.main.profiletower.models;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
	
    @NotEmpty
	@Column(name="username")
	private String username;
	
	
    @NotEmpty
	private String email;
	
	
    @NotEmpty
	private String password;
	
	
	private Integer enabled;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="UserRole", joinColumns = @JoinColumn(name ="user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
