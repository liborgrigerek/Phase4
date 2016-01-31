package cz.morosystems.phase4.service;

import java.util.List;

import cz.morosystems.phase4.entity.UserEntity;

public interface UserManager {
	public UserEntity getUser(Integer id);
    public List<UserEntity> getAllUsers();
    public void addUser(UserEntity user);
    public void deleteUser(Integer userId);
}
