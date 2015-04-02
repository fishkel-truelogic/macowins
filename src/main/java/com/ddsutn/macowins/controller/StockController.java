package com.ddsutn.macowins.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddsutn.macowins.model.Bill;
import com.ddsutn.macowins.model.Item;
import com.ddsutn.macowins.model.dao.BillDao;
import com.ddsutn.macowins.model.dao.ItemDao;

@Configurable
@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private BillDao billDao;
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String getStock(ModelMap model) {
		List<Item> items = itemDao.findAll();
		model.addAttribute("items", items);
		model.addAttribute("itemsLength", items.size());
		return "stock";
	}
	
	@RequestMapping(value="/purcharse", method = RequestMethod.POST)
	public String purcharse(@ModelAttribute("bill") Bill bill, ModelMap model) {
		bill.setDate(new Date());
		billDao.save(bill);
		return getStock(model);
		
	}
	
	@RequestMapping(value="/history", method = RequestMethod.GET)
	public String history(@RequestParam("date")String datestr, ModelMap model) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = sf.parse(datestr);
		List<Bill> bills = billDao.getByDate(date);
		model.addAttribute("bills", bills);

		return "history";
		
	}
	
	
}
