package signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		Connection conn=null;
	       String id="SHAHARYARSHAMSHI";
	       String passcode="shahbazshamshi";
	       String url="jdbc:mysql://localhost/cookbook?useSSL=false";
	       int k=0;  //use to check whether the user id is present
	       int c=0;  //use to check whether password is correct
	       String msg=null;
	       try
	       {
	          Class.forName("com.mysql.jdbc.Driver").newInstance();
	          conn=DriverManager.getConnection(url, id, passcode);
	          
	       }
	       catch (Exception e)
	       {
	           System.out.println(e);
	       }
	       try
	       {
	    	   PreparedStatement s;
	    	   s=conn.prepareStatement("SELECT *FROM user where username=?");
	    	   s.setString(1,userid );
	    	   ResultSet rs=s.getResultSet();
	    	   if(rs.next()==false)
	    	   {
	    		   k=1;
	    		   msg="user id do not exist";
	    	   }
	    	  // rs.close();
	    	   //s.close();
	    	   if(k==0)
	    	   {
	    		   s=conn.prepareStatement("Select password from user where  username=?");
	    		 // s.setString(1, password);
	    		  s.setString(1, userid);
	    		   rs=s.getResultSet();
	    		   while(rs.next())
	    		   {
	    			   if(rs.getString(1).equals(password))
	    				   c=0;
	    			   else
	    				   c=1;
	    		   }
	    		   if(c==1)
	    		   {
	    			   msg="password is invalid";
	    		   }
	    		  
	    	   }
	    	   
	       }
	       catch (Exception e)
	       {
	    	  System.out.println(e); 
	       }
	       PrintWriter printer=response.getWriter();
	       printer.println(msg);
	       
	}

}
