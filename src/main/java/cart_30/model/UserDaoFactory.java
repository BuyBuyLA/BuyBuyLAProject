package cart_30.model;


public class UserDaoFactory {
	private static final UserDao USER_DAO = createUserDao();
	
	private static UserDao createUserDao() {
		UserDao userDAO = new UserDao();
		return userDAO;
	}
	public static UserDao getUserDao() {
		return USER_DAO;
	}	
	
}
