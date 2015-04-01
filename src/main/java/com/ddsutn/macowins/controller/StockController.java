package com.ddsutn.macowins.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddsutn.macowins.model.Item;

@Controller
@RequestMapping("/stock")
public class StockController {

	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("Saco negro", Long.valueOf(300), false));
		items.add(new Item("Saco blanco", Long.valueOf(300), true));
		items.add(new Item("Pantalon negro", Long.valueOf(300), false));
		items.add(new Item("Pantalon blanco", Long.valueOf(300), true));
		items.add(new Item("Camisa negra", Long.valueOf(300), false));
		items.add(new Item("Camisa blanca", Long.valueOf(300), true));
		
		model.addAttribute("items", items);
		return "stock";
 
	}
}
