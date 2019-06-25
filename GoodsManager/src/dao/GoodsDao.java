package dao;

import java.util.List;

import entity.Goods;

public interface GoodsDao {
  public List<Goods> selectone(String goods_tiaoma);
  
}
