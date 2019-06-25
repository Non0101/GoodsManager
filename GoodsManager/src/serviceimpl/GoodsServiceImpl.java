package serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.GoodsDao;
import dao.UserDao;
import db.MyBatisUtil;
import entity.Goods;
import service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao gd = (GoodsDao) MyBatisUtil.getMapper(GoodsDao.class);
	private static List<Goods> g = new ArrayList();
	

	@Override
	public List<Goods> searchone(String goods_tiaoma) {
		SqlSession session = null;
		session = MyBatisUtil.getSqlSession();
		g = gd.selectone(goods_tiaoma);
		if (g != null) {
			return g;
		} else
			return null;
	}

}
