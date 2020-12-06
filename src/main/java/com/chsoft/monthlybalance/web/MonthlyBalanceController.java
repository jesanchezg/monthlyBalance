package com.chsoft.monthlybalance.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monthlyBalance")
public class MonthlyBalanceController {
	
	@RequestMapping(value = "/lstPaym", method = RequestMethod.GET)
	public String getLstPaymOfTheMonth(){
		return "­<h2>List</h2>";
	}
	
	@RequestMapping("/monthResult")
	public String getFinalBalanceOfTheMonth(){
		return "­<h2>100</h2>";
	}
	
	@RequestMapping("/getNewValuePriceForm") // it's a GET, but the POST method replace it in the method of the form.
												// But it's possible to change to GET instead of POST
	public String getNewValueForm(){
		return "<form action=\"/monthlyBalance/setPriceValue\" method=\"POST\">\n" + 
				"  Value:<br>\n" + 
				"  <input type=\"text\" name=\"value\">\n" + 
				"  <br>\n" + 
				"  Place:<br>\n" + 
				"  <input type=\"text\" name=\"place\">\n" + 
				"  <br><br>\n" + 
				"  <input type=\"submit\" value=\"Submit\">\n" + 
				"</form>";
	}
	
	@RequestMapping(value = "/setPriceValue", method = RequestMethod.POST)
	public String setPriceValue(@RequestParam String value,@RequestParam String place){
		return "Value: " + value + ", Price: "+ place;
	}
	
	@RequestMapping(value="/month/{id}", method=RequestMethod.GET) //Identify values of a month to show the list
	public String getMonthListPayments(@PathVariable String id){
		return "­Month ID:"+ id;
	}
	
}
