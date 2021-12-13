package com.metaarivu;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Stock {

	private String id;
	private String companyCode;
	private Double price;
	private Date dateTime;

	public Stock(String id, String companyCode, Double price, Date dateTime) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.price = price;
		this.dateTime =  dateTime;
	}

	public String getId() {
		return id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public Double getPrice() {
		return price;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String toJSON() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String toCSV() {
		return id+"|"+companyCode+"|"+price+"|"+dateTime.getTime();
	}

}
