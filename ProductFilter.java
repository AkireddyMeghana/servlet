package com.assignment.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.print.PrintService;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.assignment.web.model.product;
import com.assignment.web.service.productserviceimpl;

/**
 * Servlet Filter implementation class ProductFilter
 */
@WebFilter("/ProductWelcomeServlet")
public class ProductFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ProductFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @param productList 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain, Object productList) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String productName = request.getParameter("name");
		String productdesc = request.getParameter("desc");
		String productid = request.getParameter("id");
		String price= request.getParameter("price");
		
		PrintService service = new productserviceimpl();
				
		if(productName.equals("") || productdesc.equals("")||productid.equals("") ||price.equals("")){
			out.print("<h2>**Please enter username and password**<h2>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		 
		else if(service.isValidproduct(productName,productdesc,productid,price)) {
			
			List<product> userList = service.getproduct();
			request.setAttribute("productname", productName);
			request.setAttribute("productdesc", productdesc);
			request.setAttribute("productid", productid);
			request.setAttribute("productprice", price);
			
			request.setAttribute("productList", productList);
			chain.doFilter(request, response);
		}
	
		else {
			out.print("<h2>Incorrect login credential!!<h2>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
