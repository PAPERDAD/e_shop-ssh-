package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午2:25:51 
*@version 1.0 
**/
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name="login")
	private String login;
	@Column(name="name")
	private String name;
	@Column(name="pass")
	private String pass;
	@Column(name="sex")
	private String sex;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	String email;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "user")
	private Set<Forder> forders = new HashSet<Forder>();
	
	public User() {
		
	}
	public User(String login, String name, String pass, String sex,
			String phone, String email, Set<Forder> forders) {
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.forders = forders;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Forder> getForders() {
		return forders;
	}
	public void setForders(Set<Forder> forders) {
		this.forders = forders;
	}
	

}
