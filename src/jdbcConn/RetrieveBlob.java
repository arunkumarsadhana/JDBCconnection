package jdbcConn;
import java.io.*;
import java.sql.*;
public class RetrieveBlob {
public static void main(String args[])throws SQLException,ClassNotFoundException,IOException {
	FileOutputStream fos =new FileOutputStream("D:\\Java Projects\\file\\myfile.wmv");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	PreparedStatement ps=con.prepareStatement("select * from mtab9 where id = ?");
	ps.setString(1, "123");
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		Blob b = rs.getBlob(2);
		byte by[]=b.getBytes(1, (int)b.length());
		fos.write(by);
		fos.close();
	}else {
		System.out.println("Invalid id");
	}
	}
}
