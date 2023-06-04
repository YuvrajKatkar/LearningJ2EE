package jdbcdemo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingDemo {
	
	public static void main(String[] args) throws SQLException {
		String query = "insert into student values (?,?,?);";
		PreparedStatement ps= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql").prepareStatement(query);
//		.createStatement();
//		st.addBatch("insert into student values (17,'Rohit17',17);");
//		st.addBatch("delete from student where id = 12;");
//		st.addBatch("update  student set name = 'abc' where id = 13;");
//		st.addBatch("insert into student values (18,'Rohit18',184);");
//		st.addBatch("delete from student where id = 15;");
//		st.addBatch("update  student set name = 'abc' where id = 16;");
//		st.executeBatch();
//
//		System.out.println("Zala re");
		for(int i =20;i<23;i++) {
			ps.setInt(1, i);
			String value = "oqweir";
			ps.setString(2, value);
			ps.setInt(3, i+5);
			ps.addBatch();
		}
		ps.executeBatch();
		System.out.println("zala re");
	}
}
