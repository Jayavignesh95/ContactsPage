package com.app;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.glassfish.gmbal.ManagedOperation;

import model.User;

public class RegisterController extends HttpServlet {
	 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			User user= new User();
			String name =req.getParameter("user");
			String password =req.getParameter("password");
			user.setUserName(name);
			user.setPassword(password);
			System.out.println(name+password);
			PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
			pm.makePersistent(user);
	        HttpSession session=req.getSession();  
	        session.setAttribute("user", name);
	        resp.sendRedirect("web/welcome.jsp");
	        
//	        RequestDispatcher dispatcher = req.getRequestDispatcher("web/welcome.jsp");
//	        dispatcher.forward(req, resp);

	        //resp.sendRedirect("web/welcome.jsp");
			//super.doPost(req, resp);
		
	}

}
