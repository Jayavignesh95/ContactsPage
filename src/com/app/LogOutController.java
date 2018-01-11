package com.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		  req.getSession().invalidate();
	        System.out.println("Session invalidated");
	        RequestDispatcher dispatcher1 = req.getRequestDispatcher("/index.html");
	        dispatcher1.forward(req, resp);
		//super.doPost(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("GET");
	      doPost(req, resp);
	}

}
