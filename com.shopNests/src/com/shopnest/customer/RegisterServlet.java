package com.shopnest.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopnest.dbHandler.DataInjector;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String uname=req.getParameter("uname");
		String mail=req.getParameter("mail");
		String passw=req.getParameter("passw");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String status=DataInjector.addCustomer(uname,mail,passw,gender,address);
		res.sendRedirect("login.jsp");
	}
}
