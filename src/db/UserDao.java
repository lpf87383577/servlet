package db;



public interface UserDao {

	
	/**
	 * 根据用户名和密码从数据库中查询对应的记录
	 * 
	 * @param user
	 * @return User 用户名和密码正确 null 用户名或密码不正确
	 */
	public User checkUserNameAndPssword(User user);

	/**
	 * 根据用户名查询数据库中是否有对应的记录
	 * 
	 * @param user
	 * @return true 数据库中已经有该用户名 false 数据库中没有该用户名
	 */
	public boolean checkUserName(User user);

	/**
	 * 将用户保存到数据库中
	 */
	public void saveUser(User user);
	
}
