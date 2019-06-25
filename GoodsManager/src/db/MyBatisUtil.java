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
			throw new RuntimeException("�����ļ���ȡʧ�ܣ�");
		}
	}
	//��ȡSqlSession
	public static SqlSession getSqlSession(){
		SqlSession ss = tl.get();
		if(ss==null){
			ss = sqlSessionFactory.openSession();
			tl.set(ss);
		}
		return ss;
	}
	//�ύ����
	public static void commit(){
		SqlSession ss = getSqlSession();
		ss.commit();
	}
	//�ع�����
	public static void rollback(){
		SqlSession ss = getSqlSession();
		ss.rollback();
	}
	//�ر�������Դ
	public static void close(){
		SqlSession ss = getSqlSession();
		ss.close();
		tl.remove();
	}
	//��ȡ�����ӿڵ�ʵ����
	public static Object getMapper(Class clazz){
		return getSqlSession().getMapper(clazz);
	}
}
