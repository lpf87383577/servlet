package db;



public class UserDaoImpl extends BaseDao<User> implements UserDao{

	
	
	@Override
	public User checkUserNameAndPssword(User user) {
		
		String sql = "select id,username,password,email from users where username = ? and password = ?";
		
		User user2 = getBean(sql, user.getUsername(),user.getPassword());
		
		return user2;
	}

	
	
	@Override
	public boolean checkUserName(User user) {
		
		String sql = "select id,username,password,email from users where username = ?";
		
		User user2 = getBean(sql, user.getUsername());
		
		return user2!=null;
		
	}

	
	
	@Override
	public void saveUser(User user) {
		//写sql语句
		String sql = "insert into users(username,password,email) values(?,?,?)";
		
		//调用BaseDao中通过增删改的方法
		update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}

}
