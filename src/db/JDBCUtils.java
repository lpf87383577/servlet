package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	
	//创建连接池
		private static DataSource dataSource = new ComboPooledDataSource();
		
		//获取连接
		public static Connection getConnection(){
			Connection connection = null;
			try {
				//获取连接
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
		//释放连接
		public static void releaseConnection(Connection connection){
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
}
