package com.rosspatil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Controller
 */
@MultipartConfig
@WebServlet
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		ServletContext  context=config.getServletContext();
		context.setAttribute("URL","http://localhost:8080/Cwitter/Controller");
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		String base ="" ; 
		String url = "Default.jsp"; 
		String action = request.getParameter("action"); 
		PrintWriter out = response.getWriter();
		
		System.out.println("Controller....");
		if (action!=null) {

			if(action.equals("login")){
				
				String userId=new DbBean().loginCheck(request.getParameter("userName"), request.getParameter("password"));
				if(userId!=null){
					session.setAttribute("UserId", userId);
					session.setAttribute("Login", "yes");
					url="HomePage.jsp";
				}else{
					out.println("Login Fail.....");
				}
				
			}else if(action.equals("signup")){
				
				if(request.getParameter("password").equals(request.getParameter("rpassword"))){
					FileInputStream fileInputStream=new FileInputStream("E:\\Cwitter\\Cwitter\\WebContent\\Images\\Guest.JPG");
					String userId=new DbBean().singUp(new UserInfo(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("emailId"),request.getParameter("mobile"),request.getParameter("dob"),request.getParameter("password")),fileInputStream);
					
					session.setAttribute("UserId", userId);
					session.setAttribute("Login", "yes");
					session.setAttribute("Photo", new DbBean().getImage(userId));
					System.out.println("Successfull signup");
					url="Update.jsp";
				}
				
				
			}else if (action.equals("upload")) {
				Part filepart=request.getPart("upload");
				InputStream fin=filepart.getInputStream();
				new FileUpload(fin,session.getAttribute("UserId").toString());
				url=base+"Update.jsp";
			}else if(action.equals("next")){
				url="HomePage.jsp";
			}else if(action.equals("post")){
				String tweet=request.getParameter("tweet");
				new DbBean().storeTweets(session.getAttribute("UserId").toString(),tweet);
				url="HomePage.jsp";
			}else if(action.equals("update")){
				url=base+"Update.jsp";
			}

		} 

		RequestDispatcher requestDispatcher =request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response); 



	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		String base ="" ; 
		String url = "Default.jsp"; 
		String action = request.getParameter("action"); 
		PrintWriter out = response.getWriter();
		
		System.out.println("Controller....");
		if (action!=null) {

			if(action.equals("login")){
				
				String userId=new DbBean().loginCheck(request.getParameter("userName"), request.getParameter("password"));
				if(userId!=null){
					session.setAttribute("UserId", userId);
					session.setAttribute("Login", "yes");
					url="HomePage.jsp";
				}else{
					out.println("Login Fail.....");
				}
				
			}else if(action.equals("signup")){
				
				if(request.getParameter("password").equals(request.getParameter("rpassword"))){
					FileInputStream fileInputStream=new FileInputStream("E:\\Cwitter\\Cwitter\\WebContent\\Images\\Guest.JPG");
					String userId=new DbBean().singUp(new UserInfo(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("emailId"),request.getParameter("mobile"),request.getParameter("dob"),request.getParameter("password")),fileInputStream);
					
					session.setAttribute("UserId", userId);
					session.setAttribute("Login", "yes");
					session.setAttribute("Photo", new DbBean().getImage(userId));
					System.out.println("Successfull signup");
					url="Update.jsp";
				}
				
				
			}else if (action.equals("upload")) {
				Part filepart=request.getPart("upload");
				InputStream fin=filepart.getInputStream();
				new FileUpload(fin,session.getAttribute("UserId").toString());
				url=base+"Update.jsp";
			}else if(action.equals("next")){
				url="HomePage.jsp";
			}else if(action.equals("post")){
				String tweet=request.getParameter("tweet");
				new DbBean().storeTweets(session.getAttribute("UserId").toString(),tweet);
				url="HomePage.jsp";
			}else if(action.equals("update1")){
				url=base+"Update.jsp";
			}

		} 

		RequestDispatcher requestDispatcher =request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response); 

	}

}
