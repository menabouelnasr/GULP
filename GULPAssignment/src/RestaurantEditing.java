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
 * Servlet implementation class UserEditing
 */
@WebServlet("/RestaurantEditing")

public class RestaurantEditing extends HttpServlet 
{	static Connection conn;
	static String name, grade, output, ID;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantEditing() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String UserID, Name, Address, RatingDate, Rating, Review, Password, RestaurantName, RName, output="", output2="";
		String url = "jdbc:oracle:thin:testuser/password@localhost"; 
				
		try {
									
				Class.forName("oracle.jdbc.driver.OracleDriver");
								
				//properties for creating connection to Oracle database
				Properties props = new Properties();
				props.setProperty("user", "testdb");
				props.setProperty("password", "password");
					          
				//creating connection to Oracle database using JDBC
					 conn = DriverManager.getConnection(url,props);
			      
					    HttpSession session= request.getSession(true);
					    ID= session.getAttribute("restaurantID").toString();
					    
					    Name=request.getParameter("Name");
					    System.out.println(Name);
					    Address= request.getParameter("Address");
					    System.out.println( Address);
					
						if(Name != null)
						{
							 Statement stmt = conn.createStatement();
							 ResultSet rs = stmt.executeQuery("Update Restaurants set Name = '" + Name + "' where ID= '" + ID + "'");
							 output= "Your new email Restaurant Name has been updated to '"+ Name +"'\n.";
						}
						
						if( Address != null)
						{
							conn.close();
							Class.forName("oracle.jdbc.driver.OracleDriver");
							//properties for creating connection to Oracle database
							props = new Properties();
							props.setProperty("user", "testdb");
							props.setProperty("password", "password");
								          
							//creating connection to Oracle database using JDBC
							conn = DriverManager.getConnection(url,props);
							
							Statement stmt = conn.createStatement();
							//System.out.println("Update reviews set Reviews = '" + Review + "' where RestaurantName= '" + RName + "'");
							ResultSet rs = stmt.executeQuery("Update Restaurants set Address = '" + Address + "' where ID= '" + ID + "'");
						}
						     output+=" \nYour Restaurant Address has been updated as follows: '" + Address + "'.";
				           
					}
		  
						catch (Exception e) 
				      {
				  	   e.getMessage();
				      }
						 
				      request.setAttribute("message", output);
				      getServletContext().getRequestDispatcher("/Profile.jsp").forward(request,response);	
				      output="";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
