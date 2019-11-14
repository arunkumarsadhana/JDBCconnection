package jdbcConn;
import java.util.*;
import java.io.*;
import java.sql.*;
public class MDataLoad {
public static void main(String args[])throws SQLException,ClassNotFoundException,IOException {
	Scanner sc=new Scanner(System.in);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	PreparedStatement ps = con.prepareStatement("insert into mtab9 values(?,?)");
	System.out.println("Enter the id : ");
	String id = sc.nextLine();
	System.out.println("Enter the path : ");
	String fPath = sc.nextLine();
	File f = new File(fPath);
	FileInputStream fis = new FileInputStream(f);
	ps.setString(1, id);
	ps.setBinaryStream(2, fis,(int)f.length());
	int k = ps.executeUpdate();
	if(k==1) {System.out.println("File loaded successfully....");}
	con.close();fis.close();sc.close();
}
}
