package com.pu;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
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
import java.sql.Statement;
import java.util.List;


/**
 * Servlet implementation class delsetattr
 */
public class DeleteSchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        String searchName = request.getParameter("tages");
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FamilyLogin","root",""); 
            String sql = "DELETE FROM insertsch WHERE tages=?;"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,searchName); 
            stmt.executeUpdate(); 
            conn.close(); 
            out.println("<script>");
            out.println("alert('Deleted Successfull');"); 
            out.println("</script>"); 
            out.println("<script>");
            out.println("window.location.href = 'DisSServlet';");  
            out.println("</script>");
           }  
            catch (Exception e) 
           {  
            out.println(e);  
        } 
	}

}
