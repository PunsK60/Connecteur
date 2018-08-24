package com.mastertech;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			doProcess(request, response);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			doProcess(request, response);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Connection connect = null;
		Statement state = null;
		ResultSet result = null;
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demoservlet", "root", "1234");
			state = connect.createStatement();
			result = state.executeQuery("select * from userinfomation");
			
			out.println(
				"<html>" 
				+	"<head>"
				+		"<title>Hello Connect DB</title>"
				+	"</head>"
				+	"<body>"
				+	"<h1>Name from DB</h1>"
				+	"<br>"																		
			);
			System.out.println("Get value from table userinformation");
			
			while(result.next()){
				out.print(
					"<tr>" 
					+	"Name : " + result.getString("username")
					+	"\t\t\t"
						
					+	"Sex : " + result.getString("gender")
						
					+	"Address : " + result.getString("address")
						
					+"</tr><br>"
					
				);
				out.print(
					"</body>" 
					+"</html>"
				);
			}
		}finally{
			if(state != null){
				state.close();
			}
		}
		if(connect != null){
			connect.close();
		}
	}
}
