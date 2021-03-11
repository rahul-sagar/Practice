import java.sql.*;

public class dbcon {

	Statement st;
	Connection cn;
	PreparedStatement ps;
	public dbcon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","12345");
		st=cn.createStatement();
	}
	int insertEmp(String name,String pwd) throws SQLException {
		ps=cn.prepareStatement("insert into record(name,password)values(?,?)");
		ps.setString(1, name);
		ps.setString(2, pwd);		
		int x=ps.executeUpdate();
		return x;
	}
	int deleterecord(String name) throws SQLException {
		ps=cn.prepareStatement("delete from record where name=?");
		ps.setString(1, name);
		int z=ps.executeUpdate();
		return z;
	}
	int updateRecord(String name,String password) throws SQLException{
		ps=cn.prepareStatement("update record set password=? where name=?");
		ps.setString(1, password);
		ps.setString(2, name);
		int z=ps.executeUpdate();
		return z;
	}
}