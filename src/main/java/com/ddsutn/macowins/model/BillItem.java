package com.ddsutn.macowins.model;

/**
 * @author lfishkel
 */
public class BillItem {

	private long id;
	private Item item;
	private int amount;
	
	
	public BillItem() {
	}

	public BillItem(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
