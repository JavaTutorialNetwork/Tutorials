package net.javatutorial.tutorials.gfauthexample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "findUserById", query = "SELECT u FROM User u WHERE u.email = :email")
})
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = -5892169641074303723L;
	
	@Id
	@Column(name="email", nullable=false, length=255)
	private String email;
	
	@Column(name="password", nullable=false, length=64)
	private String password;
	
	@Column(name="name", nullable=false, length=30)
	private String name;
	
	public User(){}

	public User(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
