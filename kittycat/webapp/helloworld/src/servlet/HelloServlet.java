package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

	    /**
	     * Default constructor. 
	     */
	    public HelloServlet() {
	        // TODO Auto-generated constructor stub
	    }
	    
	    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	    	System.out.println("servlet service......");
	    	if(request==null||response==null)
				System.out.println("request or response null");
	    	
	    	
	    	doGet(request, response);
	    }
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			if(request==null||response==null)
				System.out.println("request or response null");
			response.getWriter().append("hello kittycat!").flush();
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	


}
