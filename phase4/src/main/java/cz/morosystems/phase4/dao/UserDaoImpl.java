package cz.morosystems.phase4.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase4.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		//return this.sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
		return this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class).addOrder(Order.asc("id")).list();
	}
	@Transactional
	public UserEntity getUser(Integer userId) {
		return (UserEntity) this.sessionFactory.getCurrentSession().createQuery("from UserEntity user where user.id = :userid").setParameter("userid", userId).uniqueResult();
	}
	@Transactional
	public void addUser(UserEntity user) {
		if (user.getId() == null) {
			// novy uzivatel
			this.sessionFactory.getCurrentSession().save(user);
		} else {
			// editace stavajiciho uzivatele
			this.sessionFactory.getCurrentSession().merge(user);
		}
	}
	@Transactional
	public void deleteUser(Integer userId) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().load(
				UserEntity.class, userId);
        if (null != user) {
        	this.sessionFactory.getCurrentSession().delete(user);
        }
	}
}
