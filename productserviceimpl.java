package com.assignment.web.service;

import java.util.List;

import javax.print.PrintService;

import com.assignment.web.dao.productdao;
import com.assignment.web.dao.productdaoimpl;
import com.assignment.web.model.product;

public class productserviceimpl implements productservice {

	productdao dao = new productdaoimpl();
	public boolean isValidproduct(String productName, int productid, int price, String productdesc) {
		
		boolean isValid = false;
		List<product> productList = dao.getproduct();
		for (product product : productList) {
			if (product.getProductName().equals(productName) && product.getProductdesc().equals(productdesc) &&
				product.getProductid()==(productid) && product.getPrice()==( price)){
				isValid = true;
			}
		}
		return isValid;
	}

	public List<product> getproduct() {
		List<product> productList = dao.getproduct();
		return productList;
	}

}
