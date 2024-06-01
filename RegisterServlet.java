package com.pu;

import java.text.SimpleDateFormat;
import java.util.Date;
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

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String un=request.getParameter("username");		
		String pwd=request.getParameter("password");
		SimpleDateFormat time=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String timest=time.format(new Date());
		Family fam = new Family();
		fam.setUsername(un);
		fam.setPassword(pwd);
		fam.setTime(timest);
		request.setAttribute("fam",fam);   
		int result=0;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FamilyLogin","root","");
			String query = "INSERT INTO login_details(Username, pass, RegisteredTime) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fam.getUsername());
			preparedStatement.setString(2, fam.getPassword());
			preparedStatement.setString(3, fam.getTime());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Register Success</title>");
            out.println("<script>");
            out.println("alert('SuccessFully Registered');"); 
            out.println("</script>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("window.location.href = 'Login.html';");  
            out.println("</script>"); 
            out.println("</body>");
            out.println("</html>");
        	}
			catch (Exception e) {
            System.err.println(e);
	}

}
}
