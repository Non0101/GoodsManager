package dao;

import entity.User;

public interface UserDao {
  public User selectone(String username);
}
