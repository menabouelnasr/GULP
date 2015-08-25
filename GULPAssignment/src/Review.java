

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet 
{
	static Connection conn;
	static String name, output="";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Date current_date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy ");
		String ID,Name, Address, Description, Rating, RatingDate,Review;
	
		name= request.getParameter("name");
		// TODO Auto-generated method stub
		try {
	       	//URL of Oracle database server
	       	 
	            String url = "jdbc:oracle:thin:testuser/password@localhost"; 
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
	         
	            Statement stmt = conn.createStatement();
	            System.out.println(name);
	            System.out.println("select * from Restaurants where ID= " + name);
	            ResultSet rs = stmt.executeQuery("select * from Restaurants where ID=" + name);
	            
	        output+="<table border=2 color=white>";
	        output+="<tr><th>ID </th><th>Restuarant Name</th><th>Restaurant Address </th><th> Description</th></tr> "; 
	       rs.next();
	        
	        	ID= rs.getString("ID");
	        	System.out.println(ID);
	       		Name= rs.getString("NAME");
	       		System.out.println(Name);
	       		Address= rs.getString("ADDRESS");
	       		Description= rs.getString("description");
	       		System.out.println(Description);
	       		output+= "<tr><td>" + ID + "</td><td>"+ Name + "</td><td>"+ Address+ "</td><td>"+ Description+ "</td></tr>"; 
	       		
	       		conn.close();
	       		
	       stmt = conn.createStatement();
	       System.out.println("select * from Reviews where ID= " + name);
           ResultSet rs2 = stmt.executeQuery("select * from Restaurants where ID=" + name);
           
           output+="<table border=2 color=white>";
           output+="<tr><th>ID </th><th>Restuarant Name</th><th>Restaurant Address </th><th> Description</th></tr> "; 
           
           rs2.next();
       
      		Rating= rs.getString("Rating");
      		Review= rs.getString("Reviews");
      		
      		output+= "<tr><td>" + Rating +  "</td><td>"+ Review+ "</td></tr>"; 
      		
      		conn.close();
	       		
	       		
		}
		catch (Exception e) 
        {
    	   e.getMessage();
        }
		 
        request.setAttribute("message", output);
        getServletContext().getRequestDispatcher("/InputReview.jsp").forward(request,response);
        output="";
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
