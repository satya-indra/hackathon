package com.app.dao;

import com.app.pojos.User;

public interface IuserDao {
 public User validateUser(String email,String password);
 public void addUser(User user);
 public void changePassword(String email,String password,String newPassword);
 public void editProfile(User user);
}
