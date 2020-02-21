package com.internet.base.application.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Products")
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long products_id;
	
	private Long product_quantity;

	@NotNull
	private String productDescription;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "technologyType_id")
	private TechnologyType technologyType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private DeviceType deviceType;

	private int price;
	
	public Products() {
		super();
	}

	public Products(Long id, @NotNull String productDescription, @NotNull Users users, TechnologyType technologyType,
			DeviceType deviceType) {
		super();
		this.id = id;
		this.productDescription = productDescription;
		this.users = users;
		this.technologyType = technologyType;
		this.deviceType = deviceType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public TechnologyType getTechnologyType() {
		return technologyType;
	}

	public void setTechnologyType(TechnologyType technologyType) {
		this.technologyType = technologyType;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public Long getProducts_id() {
		return products_id;
	}

	public void setProducts_id(Long products_id) {
		this.products_id = products_id;
	}

	public Long getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Long product_quantity) {
		this.product_quantity = product_quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
