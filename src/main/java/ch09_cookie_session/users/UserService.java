package ch09_cookie_session.users;

import org.mindrot.jbcrypt.BCrypt;

public class UserService {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWORD = 1;
	public static final int UID_NOT_EXIST = 2;
	
	// 세가지 경우가있어서 boolean으로 안하고 int로함
	public int login(String uid, String pwd) {
		//DB만들기
		UserDao uDao = new UserDao();
		User user = uDao.getUser(uid);
		if (user == null)
			return UID_NOT_EXIST;
		if (BCrypt.checkpw(pwd, user.getPassword()))
			return CORRECT_LOGIN;
		else
			return WRONG_PASSWORD;
	}
}
