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

/**
 * Servlet implementation class UpdateSCHServlet
 */
public class UpdateACTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateACTServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String dat=request.getParameter("date");		
		String tim=request.getParameter("time");
		String tag=request.getParameter("tages");
		String desc=request.getParameter("descript");
		int result=0;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FamilyLogin","root","");
			String query = "update insertact set Adate=?, Atime=?,Descrip=? where tages=? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dat);
			preparedStatement.setString(2, tim);
			preparedStatement.setString(4, tag);
			preparedStatement.setString(3, desc);
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Updated SuccessFully</title>");
            out.println("<script>");
            out.println("alert('SuccessFully Updated');"); 
            out.println("</script>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("window.location.href = 'DisAServlet';");  
            out.println("</script>"); 
            out.println("</body>");
            out.println("</html>");
        	}
			catch (Exception e) {
            System.err.println(e);
	}
	}

}
