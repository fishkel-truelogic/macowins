package com.ddsutn.macowins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lfishkel
 */
public class Bill {
	
	private long id;
	private Date date;
	private Long total;
	private List<BillItem> billItems;
	
	
	
	public Bill() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	public List<BillItem> getBillItems() {
		if (billItems == null) billItems = new ArrayList<BillItem>();
		return billItems;
	}
	
	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}
	
	public void addItem(BillItem billItem) {
		this.getBillItems().add(billItem);
	}
	
	public boolean removeBillItem(long billItemId) {
		boolean exists = false;
		for (BillItem billItem : this.getBillItems()) {
			if (billItem.getId() == billItemId) {
				this.getBillItems().remove(billItem);
				exists = true;
			}
		}
		return exists;
	}
	
}
