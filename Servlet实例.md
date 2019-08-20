### 新建类继承HttpServlet
```python
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("接收到请求了");
		//获取参数
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
			
		//返回json数据	
	    resp.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Student student = new Student("小明","17","男");
		
		String json = new Gson().toJson(student);
		out.print(json);
		out.flush();
		out.close();
		System.out.println("响应到请求");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}

```
==注意：doGet()和doPost()方法里面super方法一定要去除，否则报错。==

### 引入第三方jar包
将jar放入WebContent\WEB-INF\lib目录中。


### 引入数据库

1、新建一个config资源文件夹，导入c3p0-config.xml,

```python
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>

	<default-config>
	<!-- 数据库地址 -->
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/bookstore
		</property>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<!-- 账号密码 -->
		<property name="user">root</property>
		<property name="password">root</property>
		<!-- 最小的连接数 -->
		<property name="minPoolSize">5</property>
		<!-- 最大的连接数 -->
		<property name="maxPoolSize">100</property>
		<!-- 初始化的连接数 -->
		<property name="initialPoolSize">10</property>
		<!-- 需要时一次性创建的连接数 -->
		<property name="acquireIncrement">10</property>
		<!-- 缓存多少个Statement对象 -->
		<property name="maxStatements">15</property>
	</default-config>

</c3p0-config>
```
2、导入jar包

3、创建工具类JDBCUtils
```python
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
```

