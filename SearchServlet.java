package com.pu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        String searchName = request.getParameter("tages");
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FamilyLogin","root",""); 
            String sql = "SELECT * FROM insertsch WHERE tages=?"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,searchName); 
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();  
            int total=rsmd.getColumnCount();  
            out.println("<link rel='stylesheet' type='text/css' href='Display.css' />"); 
            out.println("<h1>Fetched SuccessFully</h1>");
            out.println("<table id="+"Search");
            out.println("<tr>");  
            for(int i=1;i<=total;i++)  
            {  
            out.println("<th>"+rsmd.getColumnName(i)+"</th>");  
            }  
              
            out.println("</tr>");  
              
            while(rs.next())  
            {  
            out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");  
                              
            }  
              
            out.println("</table>");  
                          
            conn.close();
            
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        } 
	}

}
