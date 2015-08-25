

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	static Connection conn;
	static String name, grade, output, ID;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String UserID, Email, RatingDate, Rating, Review, Password;
					output="";
				 String url = "jdbc:oracle:thin:testuser/password@localhost"; 
			    try {
							
			        	Class.forName("oracle.jdbc.driver.OracleDriver");
						
			            //properties for creating connection to Oracle database
			            Properties props = new Properties();
			            props.setProperty("user", "testdb");
			            props.setProperty("password", "password");
			          
			            //creating connection to Oracle database using JDBC
			            try {
			    			conn = DriverManager.getConnection(url,props);
			    		} catch (SQLException e) {
			    			// TODO Auto-generated catch block
			    			e.printStackTrace();
			    		}

			    
			    Email=request.getParameter("email");
			    System.out.println(Email);
				Password= request.getParameter("password");
				System.out.println(Password);
				
		        Statement stmt = conn.createStatement();
			    ResultSet rs2 = stmt.executeQuery("select * from AppUsers where email='" + Email + "'");
			    
		         if(rs2.next()==false)
		         {
		        	 output= "Please try again, you have entered an invalid email and/or password";
		        	 request.setAttribute("message", output);
				     getServletContext().getRequestDispatcher("/ReviewsOutput.jsp").forward(request,response);
				     output="";
		         }
		         else
		         {
		        	ID= rs2.getString("ID");
		        	HttpSession session = request.getSession();
		        	session.setAttribute("UserID", ID);
		         
		    		conn.close();
		    		
		    		url = "jdbc:oracle:thin:testuser/password@localhost"; 
		    		Class.forName("oracle.jdbc.driver.OracleDriver");
					
		            //properties for creating connection to Oracle database
		            props = new Properties();
		            props.setProperty("user", "testdb");
		            props.setProperty("password", "password");
		          
		            //creating connection to Oracle database using JDBC
		            try {
		    			conn = DriverManager.getConnection(url,props);
		    		} catch (SQLException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}	
		            stmt = conn.createStatement();
		            System.out.println("select * from Reviews where UserID= '" + ID + "'");
		            ResultSet rs = stmt.executeQuery("select * from Reviews where UserID= '" + ID + "'");
		            output+="<table border=2 color=white>";
		            output+="<tr><th>Rating Date </th><th>Rating</th><th>Review</th></tr> "; 
		            while(rs.next())
		            {
		            	RatingDate= rs.getString("ratingDate");
		            	System.out.println(RatingDate);
		         		Rating= rs.getString("Rating");
		         		Review= rs.getString("reviews");
		    		
		         		output+= "<tr><td>" + RatingDate + "</td><td>"+ Rating+ "</td><td>"+ Review+ "</td></tr>"; 
		            }
		         }
				}
  
				catch (Exception e) 
		      {
		  	   e.getMessage();
		      }
				 
		      request.setAttribute("message", output);
		      getServletContext().getRequestDispatcher("/Profile.jsp").forward(request,response);
		      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
