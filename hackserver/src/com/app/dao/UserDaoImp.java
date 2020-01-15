package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImp implements IuserDao
{
	@Autowired
	SessionFactory sf;
	
	public UserDaoImp() {
		System.out.println("inside UserDao");
	}

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:email and u.passwd=:password";
		return (User)sf.getCurrentSession().createQuery(jpql).setParameter("email", email).setParameter("password", password).getSingleResult();
	}

	@Override
	public void addUser(User user) {
		sf.getCurrentSession().persist(user);
	}

	@Override
	public void changePassword(String email, String password, String newPassword) {
		User user = validateUser(email, password);
		user.setPasswd(newPassword);
	}

	@Override
	public void editProfile(User user) {
		User user2 = sf.getCurrentSession().get(User.class, user.getId());
		user2.setEmail(user.getEmail());
		user2.setName(user.getName());
		user2.setPasswd(user.getPasswd());
		user2.setPhone(user.getPhone());
		user2.setRole(user.getRole());
	}
	
	
	
}
