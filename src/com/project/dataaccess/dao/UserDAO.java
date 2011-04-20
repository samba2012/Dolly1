package com.project.dataaccess.dao;

import java.util.List;

import com.project.web.form.*;

public interface UserDAO {
	public void addUser(User user) throws Exception;
    public User selectUser(int userId);
    //public void removeUser(Integer id);

}
