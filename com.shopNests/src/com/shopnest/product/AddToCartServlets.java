package com.shopnest.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopnest.dbHandler.DataFetcher;

/**
 * Servlet implementation class AddToCartServlets
 */
@WebServlet("/add-to-cart")
public class AddToCartServlets extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int productId=Integer.parseInt(request.getParameter("productId"));
      Product product=DataFetcher.getProductById(productId);
     HttpSession session=request.getSession();
     Cart cart=(Cart) session.getAttribute("cart");
     if(cart==null)
     {
    	 cart=new Cart();
    	 session.setAttribute("cart", cart);
     }
     cart.addItem(product);
     response.sendRedirect("cart.jsp");
}
}
