package com.ddsutn.macowins.model.dao.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ddsutn.macowins.model.Bill;
import com.ddsutn.macowins.model.dao.BillDao;

public class BillDaoImpl extends AbstractDao<Serializable, Bill> implements BillDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Bill> getByDate(Date date) {
		Criteria criteria = getSession().createCriteria(getPersistentType());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date lo = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date hi = calendar.getTime();
		criteria.add(Restrictions.between("date", lo, hi));
		
		return criteria.list();
	}

}
