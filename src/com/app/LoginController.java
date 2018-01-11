package com.app;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class LoginController extends HttpServlet {

	@Override
	protected void  doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HELLO LOGIN SERVLET");
		String userName= req.getParameter("user");
		String passWord=req.getParameter("password");
		System.out.println(userName+passWord);
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		javax.jdo.Query q = pm.newQuery(User.class);
		List<User> results = null;
		User user = new User();
		boolean loginFlag=false;
		try {
			results = (List<User>) q.execute();
			for (Iterator iterator = results.iterator(); iterator.hasNext();) {
				 user = (User) iterator.next();
				System.out.println(user.getUserName() +" ===  " + userName);
				
				if(userName.equals(user.getUserName()))
				{
					System.out.println(user  +"Logged in ");
					loginFlag=true;
				} 
				else
				{
					System.out.println("Failed");

				}
								
			}
			System.out.println(results.toString());
			HttpSession session=req.getSession();  
	        session.setAttribute("user",userName);
	        if(loginFlag==true){ resp.sendRedirect("web/welcome.jsp");}else{  resp.sendRedirect("/index2.html");
}

		} finally {
			q.closeAll();
			pm.close();
		}

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}

































						<label>Email</label>
			
			<div>
			
				<div class="dropdown">
				
					<button class="btn btn-default dropdown-toggle" type="button"
						id="phone" data-toggle="dropdown">
						Email <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li><a tabindex="-1">Personal</a></li>
						<li><a tabindex="-1">Work</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1">Other</a></li>
					</ul>
				</div>
				<input type="text" class="phonefield" id="rguser" name="user"
					placeholder="Email Address" style="display: inline-block""><br>
			</div>
			
