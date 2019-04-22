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
*@date 2019年3月31日 下午2:38:10 
*@version 1.0 
**/
@Entity
@Table(name="status")
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int id;
	@Column(name="status")
	private String status;
	@OneToMany(targetEntity=Forder.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="status")
	private Set<Forder> forders;
	
	
	public Status() {
	}

	
	public Status(String status) {
		super();
		this.status = status;
	}


	/** full constructor */
	public Status(String status, Set<Forder> forders) {
		this.status = status;
		this.forders = forders;
	}

	
	public Status(Integer id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Forder> getForders() {
		return forders;
	}
	public void setForders(Set<Forder> forders) {
		this.forders = forders;
	}
	

}
