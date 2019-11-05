
import java.sql.CallableStatement;
import java.sql.Connection;

public class DBDemo {
	public static void main(String[]args) {
		DBUtil db=new DBUtil();
		Connection con=null;
		try {
			con=db.getConnection();
			for(int i=0;i<50;i++) {
			CallableStatement cstmt=con.prepareCall("{call padd(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, "张三");
			cstmt.setString(2, "123456");
			cstmt.setString(3, "867414568@163.com");
			cstmt.setInt(4, 1);
			cstmt.setString(5, "15924567987");
			cstmt.setString(6,"2019-08-27");
			cstmt.setString(7,"2019-09-27");
			cstmt.setString(8, "1");
			cstmt.execute();}
			for(int i=51;i<100;i++) {
				CallableStatement cstmt=con.prepareCall("{call padd(?,?,?,?,?,?,?,?)}");
				cstmt.setString(1, "张三");
				cstmt.setString(2, "123456");
				cstmt.setString(3, "867414568@163.com");
				cstmt.setInt(4, 1);
				cstmt.setString(5, "15924567987");
				cstmt.setString(6,"2019-09-27");
				cstmt.setString(7,"2019-09-27");
				cstmt.setString(8, "1");
				cstmt.execute();}
			System.out.println("成功插入记录");
			CallableStatement cstmt=con.prepareCall("{call pdelete(?)}");
			cstmt.setInt(1,8);
			cstmt.execute();
			System.out.println("删除成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}