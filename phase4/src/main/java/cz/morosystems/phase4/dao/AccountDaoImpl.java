package cz.morosystems.phase4.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase4.entity.AccountEntity;
import cz.morosystems.phase4.entity.BookEntity;

@Repository
public class AccountDaoImpl implements AccountDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<AccountEntity> getAllAccounts(Integer userId) {
		return this.sessionFactory.getCurrentSession().createCriteria(AccountEntity.class).add(Restrictions.eq("userId",userId)).addOrder(Order.asc("id")).list();
	}
	@Transactional
	public AccountEntity getAccount(Integer accountId) {
		return (AccountEntity) this.sessionFactory.getCurrentSession().createQuery("from AccountEntity account where account.id = :accountId").setParameter("accountId", accountId).uniqueResult();
	}
	@Transactional
	public void addAccount(AccountEntity account) {
		// novy ucet
		this.sessionFactory.getCurrentSession().save(account);
	}
	@Transactional
	public void editAccount(AccountEntity account) {
		// editace uctu
		this.sessionFactory.getCurrentSession().merge(account);
	}
	@Transactional
	public void deleteAccount(Integer accountId) {
		AccountEntity account = (AccountEntity) sessionFactory.getCurrentSession().load(
				AccountEntity.class, accountId);
        if (null != account) {
        	this.sessionFactory.getCurrentSession().delete(account);
        }
	}
}
