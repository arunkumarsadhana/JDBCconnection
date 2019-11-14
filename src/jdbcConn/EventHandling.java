package jdbcConn;
import java.awt.event.*;
import java.sql.*;
public class EventHandling implements ActionListener{
	String name;
	String id;
	String salary;
public void actionPerformed(ActionEvent ae) {
	String str=ae.getActionCommand();
	if(str.equals("submit")) {
		getData();
		connToDB();
	}
	if(str.equals("clear")) {
		Container.jtf1.setText("");
		Container.jtf2.setText("");
		Container.jtf3.setText("");
	}
}
void getData() {
	name = Container.jtf1.getText();
	id = Container.jtf2.getText();
	salary = Container.jtf3.getText();
}
void connToDB() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		Statement stmt=con.createStatement();
		stmt.executeUpdate("insert into employee values('"+name+"','"+id+"','"+salary+",)");
	}catch(Exception e) {e.printStackTrace();}
}
}
