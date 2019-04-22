package model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午3:02:08 
*@version 1.0 
**/
@Entity
@Table(name="sorder")
public class Sorder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable = false)
	private Integer id;
	@ManyToOne(targetEntity=Forder.class,fetch=FetchType.LAZY)
	@JoinColumn(name="fid",referencedColumnName="id")
	private Forder forder;
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Product.class)
	@JoinColumn(name="pid",referencedColumnName="id")
	private Product product;
	@Column(name="name",length=20)
	private String name;
	@Column(name="BigDecimal",precision=8)
	private BigDecimal price;
	@Column(name="number",nullable=false)
	private int number;
	
	public Sorder() {
	}

	public Sorder(Integer number) {
		this.number = number;
	}

	public Sorder(Forder forder, Product product, String name, BigDecimal price,
			Integer number) {
		this.forder = forder;
		this.product = product;
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Forder getForder() {
		return forder;
	}

	public void setForder(Forder forder) {
		this.forder = forder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
