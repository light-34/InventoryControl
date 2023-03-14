package com.inventory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", length = 45, nullable = false, unique = true)
	@NotBlank(message = "This field cant be blank")
	private String username;
	
	@Column(name = "password", length = 100, nullable = false)
	@NotBlank(message = "This field cant be blank")
	private String password;
	
	@Column(name = "email", length = 80, nullable = false, unique = true)
	@NotBlank(message = "This field cant be blank")
	private String email;
	
	@Column(name = "fname", nullable = false, length = 30)
	@NotBlank(message = "This field cant be blank")
	private String fName;
	
	@Column(name = "lname", length = 30, nullable = false)
	@NotBlank(message = "This field cant be blank")
	private String lName;
	
	@Column(name = "expired")
	private boolean expired = true;
	
	@Column(name = "locked")
	private boolean locked = true;
	
	@Column(name = "credentials_exp")
	private boolean credExpired = true;
	
	@Column(name = "enabled")
	private boolean enabeled = true;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( //This is used to join tables
				name = "users_roles",
				joinColumns = @JoinColumn(name = "users_id"),
				inverseJoinColumns = @JoinColumn(name = "roles_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	//This add roles to the user
	public void addRole(Role role) {
		this.roles.add(role);
	}

	public User() {
		
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public boolean getExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean getLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean getCredExpired() {
		return credExpired;
	}

	public void setCredExpired(boolean credExpired) {
		this.credExpired = credExpired;
	}

	public boolean getEnabeled() {
		return enabeled;
	}

	public void setEnabeled(boolean enabeled) {
		this.enabeled = enabeled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", fName="
				+ fName + ", lName=" + lName + ", roles=" + roles + "]";
	}

	
}
