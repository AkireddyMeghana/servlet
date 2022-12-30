package com.assignment.web.service;

import java.util.List;

import com.assignment.web.model.product;

public interface productservice {

	boolean isValidproduct(String productName, int productid, int price, String productdesc);
	List<product> getproduct();
}
