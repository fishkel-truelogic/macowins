package com.ddsutn.macowins.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ddsutn.macowins.model.Bill;

public interface BillDao extends Dao<Serializable, Bill> {

	public List<Bill> getByDate(Date date);

}
