public class DBUtil {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public Connection getConnection() throws ClassNotFoundException,
	SQLException,InstantiationException,IllegalAccessException{
		String driver=Config.getValue("driver");
		String url=Config.getValue("url");
		String user=Config.getValue("user");
		String pwd=Config.getValue("pwd");
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
			return conn;
		}catch(Exception e) {
			throw new SQLException("驱动错误或连接失败！");
		}
	}
	public void closeAll() {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}