package serviceimpl;

import org.apache.ibatis.session.SqlSession;

import db.MyBatisUtil;
import dao.UserDao;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = (UserDao) MyBatisUtil.getMapper(UserDao.class);
	static private User u = new User();

	@Override
	public User login(String user_name, String user_password) {
		System.out.println("½øÈëserviceimpl");
		SqlSession session = null;
		session = MyBatisUtil.getSqlSession();
		u = ud.selectone(user_name);
		if (u.getUserpassword().equals(user_password)) {
			return u;
		} else {
			return null;
		}

	}

}
