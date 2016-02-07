package cz.morosystems.phase4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase4.dao.AccountDAO;
import cz.morosystems.phase4.dao.UserDAO;
import cz.morosystems.phase4.entity.AccountEntity;
import cz.morosystems.phase4.entity.UserEntity;

@Service
public class AccountManagerImpl implements AccountManager {
	
	@Autowired
    private AccountDAO accountDAO;

	@Transactional
	public AccountEntity getAccount(Integer accountId) {
		return accountDAO.getAccount(accountId);
	}
	
	@Transactional
	public void addAccount(AccountEntity account) {
		accountDAO.addAccount(account);
	}
	
	@Transactional
	public void editAccount(AccountEntity account) {
		accountDAO.editAccount(account);
	}
	
	@Transactional
	public void deleteAccount(Integer accountId) {
		accountDAO.deleteAccount(accountId);
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
}
