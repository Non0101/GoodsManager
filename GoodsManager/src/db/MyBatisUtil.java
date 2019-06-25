package db;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	private static final ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("配置文件读取失败！");
		}
	}
	//获取SqlSession
	public static SqlSession getSqlSession(){
		SqlSession ss = tl.get();
		if(ss==null){
			ss = sqlSessionFactory.openSession();
			tl.set(ss);
		}
		return ss;
	}
	//提交事务
	public static void commit(){
		SqlSession ss = getSqlSession();
		ss.commit();
	}
	//回滚事务
	public static void rollback(){
		SqlSession ss = getSqlSession();
		ss.rollback();
	}
	//关闭连接资源
	public static void close(){
		SqlSession ss = getSqlSession();
		ss.close();
		tl.remove();
	}
	//获取参数接口的实现类
	public static Object getMapper(Class clazz){
		return getSqlSession().getMapper(clazz);
	}
}
