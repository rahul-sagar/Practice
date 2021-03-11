package emprecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Empdb db=new Empdb();
		ResultSet rs=db.getAllEmployee();
		List<Emplist> al=new ArrayList<Emplist>();
		while(rs.next()) {
		Emplist e=new Emplist(Integer.parseInt(rs.getString("eno")),Double.parseDouble(rs.getString("salary")), rs.getString("ename"),rs.getString("gender"));
		al.add(e);	
		}
		Collections.sort(al);
		Emplist e1=Collections.max(al);
	//	System.out.println("\n"+e1.ename);
		for (int i=0;i<al.size();i++) {
			System.out.println(al.get(i).eno+al.get(i).ename+al.get(i).gender+al.get(i).salary);
		}
		  
		
	}
}
 
class Emplist implements Comparable<Emplist>{
	
	int eno;
	double salary;
	String ename,gender;
	
	public Emplist(int eno,double salary,String ename,String gender) {
		this.eno=eno;
		this.ename=ename;
		this.salary=salary;
		this.gender=gender;
	}

	@Override
	public int compareTo(Emplist o) {
		
		if(this.salary>o.salary) {
			return 1;
		}
		else if(this.salary<o.salary) {
			return -1;
		}
		else
			return 0;
	}
}