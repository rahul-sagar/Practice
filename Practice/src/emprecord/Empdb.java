package emprecord;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Empdb {

	PreparedStatement st;
	Connection cn;
	ResultSet rs;
	public Empdb() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","12345");
	}
	
	public ResultSet getAllEmployee() throws SQLException {
		
		st=cn.prepareStatement("select * from emo_record");
		rs=st.executeQuery();

		return rs;
	}
}