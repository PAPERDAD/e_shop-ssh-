package model;

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
*@date 2019年3月24日 下午8:14:29 
*@version 1.0 
**/
@Entity
@Table(name="account")
public class Account implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5864679877277797478L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable = false)
	private Integer id;
	
	@Column(name="login",length=20)
	private String login;
	
	@Column(name="name",length=20)
	private String name;
	
	@Column(name="pass",length=20)
	private String pass;
	
	@OneToMany(targetEntity=Category.class,mappedBy="account",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Category> categories;

	
	public Account() {
		
	}
	
	public Account(String login,String name,String pass) {
		this.login = login;
		this.name = name;
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Account [id="+id+", login="+login+", name="+name+",pass="+pass+"]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
