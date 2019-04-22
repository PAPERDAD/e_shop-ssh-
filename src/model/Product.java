package model;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;


/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="product")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -5102917489458854913L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity=Category.class)
	@JoinColumn(name = "cid",referencedColumnName="id")
	private Category category;
	
	@Column(name = "name", length = 20)
	private String name;
	
	@Column(name = "price", precision = 8)
	private BigDecimal price;
	
	@Column(name = "pic", length = 200)
	private String pic;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "xremark")
	private String xremark;
	
	@Column(name = "date", nullable = true, length = 19)
	private Date date;
	
	@Column(name = "commend")
	private Boolean commend;
	
	@Column(name = "open")
	private Boolean open;

	@Override
	public String toString() {
	
		return "Product [id=" + id + ", category=" + category + ", name="
				+ name + ", price=" + price + ", pic=" + pic + ", remark="
				+ remark + ", xremark=" + xremark + ", commend=" + commend + ", open=" + open + "]";
	}

	// Constructors
	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
//	public Product(Timestamp date) {
//		this.date = date;
//	}


	/** full constructor */
	public Product(Category category, String name, BigDecimal price, String pic,
			String remark, String xremark, Date date, Boolean commend,
			Boolean open) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.xremark = xremark;
//		this.date = date;
		this.commend = commend;
		this.open = open;
	}

	public Product(Integer id, String name, BigDecimal price, String pic,
			String remark, String xremark, Boolean commend, Boolean open) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.xremark = xremark;
		this.commend = commend;
		this.open = open;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getXremark() {
		return this.xremark;
	}

	public void setXremark(String xremark) {
		this.xremark = xremark;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getCommend() {
		return this.commend;
	}

	public void setCommend(Boolean commend) {
		this.commend = commend;
	}

	public Boolean getOpen() {
		return this.open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}


}