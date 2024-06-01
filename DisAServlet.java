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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class DisServlet
 */
public class DisAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisAServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head>");
        out.println("<link rel='stylesheet' type='text/css' href='Display.css' />"); 
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Your Schedules</h1>");
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FamilyLogin","root",""); 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from insertact");  
            out.println("<table id="+"Search");  
            out.println("<tr><th>Due Date</th><th>Time</th><th>Tages</th><th>Description</th><tr>");  
            while (rs.next()) 
            {  
            	 String due = rs.getString("Adate");
                 String time = rs.getString("Atime");
                 String tag = rs.getString("Tages");
                 String desc = rs.getString("Descrip");
                out.println("<tr><td>" + due + "</td><td>" + time + "</td><td>" + tag + "</td><td>" + desc + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        } 
	}

}
