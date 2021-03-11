import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Updaterecord")
public class Updaterecord extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin ", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");
		response.setHeader("content-type", "applicatin/json");
		
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
				
		try {
			dbcon db=new dbcon();
			db.updateRecord(name, password);
		} 
		catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}	
	}
}