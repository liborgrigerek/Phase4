package cz.morosystems.phase4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase4.dao.UserDAO;
import cz.morosystems.phase4.entity.UserEntity;

@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
    private UserDAO userDAO;

	@Transactional
	public List<UserEntity> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	public UserEntity getUser(Integer id) {
		return userDAO.getUser(id);
	}
	
	@Transactional
	public void addUser(UserEntity user) {
		userDAO.addUser(user);
	}
	
	@Transactional
	public void editUser(UserEntity user) {
		userDAO.editUser(user);
	}
	
	@Transactional
	public void deleteUser(Integer userId) {
		userDAO.deleteUser(userId);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
