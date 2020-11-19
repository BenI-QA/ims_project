package com.qa.ims.controller;


import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.domain.Item;
import com.qa.ims.util.Utils;
import com.qa.ims.dao.ItemDAO;

public class ItemController implements CrudController<Item>{
	
	private static Logger LOGGER = LogManager.getLogger();
	ItemDAO itemDAO = new ItemDAO();
	Utils util = new Utils();
	
	public ItemController(ItemDAO itemDAO) {
		super();
		this.itemDAO = itemDAO;
	}
	
	/**
	 * Creates a Items by taking in user input
	 */
	
	@Override
	public Item create() {
		LOGGER.info("Shoe Name");
		String item_name = util.getString();
		LOGGER.info("Shoe Size");
		double size = util.getDouble();
		LOGGER.info("Set Price");
		double price = util.getDouble();
		LOGGER.info("Number in Stock");
		long stock = util.getLong();
		Item newItem = itemDAO.create(new Item(item_name, size, price, stock));
		return newItem;
	}
	
	/**
	 * Reads all items
	 */

	@Override
	public List<Item> readAll() {
		LOGGER.info("List Of Items: \n");
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;	
		
	}
	

	/**
	 * Updates an existing items by taking in user input
	 */
	
	@Override
	public Item update() {
		
		readAll();
	
		LOGGER.info("State the shoe name you wish to update");
		String name = util.getString().toLowerCase();;
		LOGGER.info("State the size you wish to update");
		double size = util.getDouble();
		LOGGER.info("Change price");
		double price = util.getDouble();
		LOGGER.info("Change amount in stock");
		long stock = util.getLong();

		itemDAO.update(new Item(name,size,price,stock));
	
		
		return null;
	}
	
	/**
	 * Deletes an existing item by the id or name of the item
	 * 
	 * 
	 */

	@Override
	public Item delete() {
		//user can select either to delete a customer from system with either their id or name
				LOGGER.info("Do you want to delete record by Item ID or Item Name?");
				LOGGER.info("  1) ID  \n  2) Name");
				String option = util.getString().toLowerCase();
				switch (option) {
					case "id":
						LOGGER.info("    Select by ID:");
						long id = util.getLong();
						itemDAO.deleteById(id);
						break;
					case "name":
						LOGGER.info("    Select by Item Name:");
						String name = util.getString();
						LOGGER.info("    Select by Item Size:");
						Double size = util.getDouble(); 
						itemDAO.deleteByName(name, size);
						break;
				}
		return null;
	}

	
}