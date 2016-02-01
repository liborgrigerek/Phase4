package cz.morosystems.phase4.service;

import java.util.List;

import cz.morosystems.phase4.entity.AccountEntity;
import cz.morosystems.phase4.entity.UserEntity;

public interface AccountManager {
	public AccountEntity getAccount(Integer accountId);
    public List<AccountEntity> getAllAccounts(Integer userId);
    public void addAccount(AccountEntity account);
    public void editAccount(AccountEntity account);
    public void deleteAccount(Integer accountId);
}
