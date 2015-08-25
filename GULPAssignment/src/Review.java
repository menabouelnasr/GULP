

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet 
{
	static Connection conn;
	static String name, output="", output2="", output3="";
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
		
		String ID,Name, Address, Description, Rating, RatingDate,Review;
		double calc=0, ave=0;
		int count=0;
	
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
	            ResultSet rs = stmt.executeQuery("select * from Restaurants where ID=" + name);
	            
	        output+="<table border=2 color=white>";
	        output+="<tr><th>ID </th><th>Restuarant Name</th><th>Restaurant Address </th><th> Description</th></tr> "; //
	       
	        rs.next();
	        	ID= rs.getString("ID");
	       		Name= rs.getString("NAME");
	       		Address= rs.getString("ADDRESS");
	       		Description= rs.getString("description");
	       		
	       		output+= "<tr><td>" + ID + "</td><td>"+ Name + "</td><td>"+ Address+ "</td><td>"+ Description+ "</td><td></table>"; 
	     
           
	       conn.close();
		}
		catch (Exception e) 
        {
    	   e.getMessage();
        }
		try
		{
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
	       ResultSet rs2 = stmt.executeQuery("select * from Reviews where ID= '" + name +"'");
           
	       System.out.println("select * from Reviews where ID= '" + name +"'");
           output2+="<table border=2 color=white>";
           output2+="<tr><th>Rating Date </th><th>Rating</th><th>Review</th></tr> "; 
           
           	while(rs2.next())
           	{
           		RatingDate= rs2.getString("ratingDate");
           		Rating= rs2.getString("Rating");
           		Review= rs2.getString("reviews");
           		
           		calc+= Double.parseDouble(Review);
           		count++;
           		System.out.println(RatingDate + " "+ Rating+ " "+ Review);
           		output2+= "<tr><td>" + RatingDate + "</td><td>"+ Rating+ "</td><td>"+ Review+ "</td></tr>"; 
           	}
           	if(count==0)
           	{
           		ave=0;
           	}
           	else
           	{
           		ave= calc/count;
           	}
           	
            output3+="<table border=2 color=white>";
            output3+="<tr><th>Restaurant Average Rating </th><th>Restaurant Total Reviews</th></tr> "; 
            output3+= "<tr><td>" + ave + "</td><td>"+ count+"</td></tr>";
           	System.out.println(ave);
           	System.out.println(count); 
      		conn.close();
	       	
	       		
		}
		catch (Exception e) 
        {
    	   e.getMessage();
        }
		 
        request.setAttribute("message", output);
        request.setAttribute("message2", output2);
        request.setAttribute("message3", output3);
        getServletContext().getRequestDispatcher("/InputReview.jsp").forward(request,response);
        output="";
        output2="";
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
