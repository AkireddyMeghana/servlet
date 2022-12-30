package com.assignment.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.web.model.product;
import com.training.web.model.User;

/**
 * Servlet implementation class ProductWelcomeServlet
 */
@WebServlet("/ProductWelcomeServlet")
public class ProductWelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String product = (String)request.getAttribute("product");
		String productdesc = (String)request.getAttribute("desc");
		int productid = (int)request.getAttribute("id");
		int price = (int)request.getAttribute("price");
		
		
		List<product> productList = (List<product>)request.getAttribute("productList");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("productList", productList);
		
		//Cookie cookie1 = new Cookie("productname", product);
		//Cookie cookie2 = new Cookie("productdesc", product);
		//Cookie cookie3 = new Cookie("price", product);
		//Cookie cookie4 = new Cookie("id", product);
		
		//response.addCookie(cookie1);
		
		
		out.print("<h1>Welcome "+product+"!  </h1>");
		
		out.println("<table border='1'> ");
		out.println("<tr> <th>");
		out.println("Name </th>");
		out.println("<th> desc </th>");
		out.println("<th> price </th>");
		out.println("<th> id </th>");
		for(product product1:productList) {
			out.println("<tr><td>" +product1.getProductName() +"</td>");
			out.println("<td>" +product1.getProductdesc() +"</td> </tr>");
			out.println("<td>" +product1.getPrice() +"</td> </tr>");
			out.println("<td>" +product1.getProductid() +"</td> </tr>");
		} 
		out.println("<h3> Click on the below link to see productName and productdesc and productid and product price</h3><br/>");
		out.println("<a href='GetUrlParamServlet?productName="+product+"&password="+password+"'>Click here</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
