package com.pu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out=response.getWriter();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FamilyLogin","root","");
            PreparedStatement ps = con.prepareStatement("select * from login_details where username=? and pass=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            if(rs.next()) {
            	 out.println("<script>");
                 out.println("alert('Login Successfull');"); 
                 out.println("</script>");
            	 HttpSession session=request.getSession();
                 session.setAttribute("logindetail", username);
                 response.sendRedirect("home.jsp");
            }
            else{
            	out.println("<script>");
                out.println("alert('Invalid Username or Password');"); 
                out.println("</script>");
            	out.println("<script>");
                out.println("window.location.href = 'Login.html';");  
                out.println("</script>"); 
            }
            con.close();
            
        } 
	catch (Exception e2) {System.out.println(e2);}
    
    out.close();
}
}
