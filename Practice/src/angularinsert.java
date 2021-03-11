

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/angularinsert")
public class angularinsert extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");
		response.setHeader("content-type", "application/json");
		
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		
		try {
		
			dbcon db=new dbcon();
			int x=db.insertEmp(name, pwd);
			if(x>0) {
				p.print("Record Inserted");
			}
			else{
				p.print("Not Inserted");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}