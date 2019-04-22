package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午2:45:57 
*@version 1.0 
**/
@Entity
@Table(name="forder")
public class Forder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,unique=true,name="id")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="uid",referencedColumnName="id")
	private User user;
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER,targetEntity=Status.class)
	@JoinColumn(name="sid",referencedColumnName="id")
	private Status status;
	@Column(name="name",length = 20)
	private String name;
	@Column(name="phone",length = 20)
	private String phone;
	@Column(name="remark",length = 20)
	private String remark;
	@Column(name="date",length = 20,nullable=false)
	private Date date;
	@Column(name="total",precision=8)
	private BigDecimal total;
	@Column(name="post",length=20)
	private String post;
	@Column(name="address",length=200)
	private String address;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="forder")
	private List<Sorder> sorders = new ArrayList<Sorder>();
	@Transient
	private int  count;
	
	
	public Forder() {
	}

	/** minimal constructor */
	public Forder(Date date) {
		this.date = date;
		this.count = sorders.size();
	}

	public Forder(List<Sorder> sorders) {
		super();
		this.sorders = sorders;
		this.count = sorders.size();
	}

	/** full constructor */
	public Forder(User user, Status status, String name, String phone,
			String remark, Date date, BigDecimal total, String post,
			String address, List<Sorder> sorders) {
		this.user = user;
		this.status = status;
		this.name = name;
		this.phone = phone;
		this.remark = remark;
		this.date = date;
		this.total = total;
		this.post = post;
		this.address = address;
		this.sorders = sorders;
		this.count = sorders.size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Sorder> getSorders() {
		return sorders;
	}

	public void setSorders(List<Sorder> sorders) {
		this.sorders = sorders;
	}

	public int getCount() {
		return sorders.size();
	}



}
