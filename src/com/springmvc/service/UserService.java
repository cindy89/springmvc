package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> findAllUser(){
		return userDao.findAllUser();
	}
	
	public void addUser(User user){
		if(user!=null){
			userDao.addUser(user);
		}
	}

	public void deleteUser(String ids){
		String[] idarr=ids.split(",");
		for(int i=0;i<idarr.length;i++){
			if(idarr[i]!=null){
				int id=Integer.valueOf(idarr[i]);
				User user=new User();
				user.setId(id);
				userDao.deleteUser(user);
			}
		}		
	}
}
