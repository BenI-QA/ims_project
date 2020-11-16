
package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Runner {
	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		
		LOGGER.info("Welcome to this Item Management System!");
		imsMain menu = new imsMain();
		menu.start();
		

	  

	}
}