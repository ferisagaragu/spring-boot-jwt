package org.neurobrain.tlozbotw.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.UniqueConstraint;

import org.neurobrain.tlozbotw.util.Text;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastName;
	private String phoneNumber;
	private String imageUrl;
	private String userName;
	private String email;
	private String password;
	private String recoverCode;

	@Column(columnDefinition = "boolean default true")
	private boolean firstSession;

	@Column(columnDefinition = "boolean default false")
	private boolean blocked;

	@Column(columnDefinition = "boolean default false")
	private boolean delete;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
		name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name="role_id"),
		uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id", "role_id"}) }
	)
	private List<Role> roles;
	

	public User(
		String name, String lastName, 
		String phoneNumber, String imageUrl, 
		String userName, String email, 
		String password, boolean firstSession
	) {
		super();
		this.name = name;
		this.lastName = lastName; 
		this.phoneNumber = phoneNumber;
		this.imageUrl = imageUrl; 
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstSession = firstSession;
	}
	
	public User() { }


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public boolean isFirstSession() {
		return firstSession;
	}

	public void setFirstSession(boolean firstSession) {
		this.firstSession = firstSession;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public String getRecoverCode() {
		return recoverCode;
	}

	public void setRecoverCode(String recoverCode) {
		this.recoverCode = recoverCode;
	}

	@Override
	public String toString() {
		return Text.toJSONString(this);
	}
	
}
