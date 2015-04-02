package com.ddsutn.macowins.model;

/**
 * @author lfishkel
 */
public class Item {

	private long id;
	private String name;
	private Long price;
	private Boolean imported;
	
	public static final long businessStaticPrice = 3;

	
	public Item() {
	}

	public Item(String name, Long price, Boolean imported) {
		this.name = name;
		this.price = price;
		this.imported = imported;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

}
