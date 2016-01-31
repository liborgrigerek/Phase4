package cz.morosystems.phase4.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import cz.morosystems.phase4.entity.AccountEntity;
import cz.morosystems.phase4.entity.BookEntity;
import cz.morosystems.phase4.entity.UserEntity;
import cz.morosystems.phase4.service.AccountManager;
import cz.morosystems.phase4.service.BookManager;
import cz.morosystems.phase4.service.UserManager;

@Controller
@RequestMapping("/admin/detail/account")
public class ShowDetailAccountController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private AccountManager accountManager;
	
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.GET)
	public String initAddAccountForm(@PathVariable("userId") Integer userId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("account", new AccountEntity());
		return "editAccount";
	}
	
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.POST)
	public String submitAddAccountForm(@PathVariable("userId") Integer userId, @ModelAttribute(value="account")@Valid AccountEntity account, BindingResult addAccountFormBindingResult) 
	{
		// osetri vysledek kontroly validatoru
		if(addAccountFormBindingResult.hasErrors()) {
			return "editAccount";
		}
		// pridej uzivatele
		accountManager.addAccount(account);
		return String.format("redirect:/admin/detail/%d", userId);
	}
	
	@RequestMapping(value = "/edit/{userId}/{accountId}", method = RequestMethod.GET)
	public String initEditAccountForm(@PathVariable("userId") Integer userId, @PathVariable("accountId") Integer accountId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("account", accountManager.getAccount(accountId));
		return "editAccount";
	}

	@RequestMapping("/delete/{userId}/{accountId}")
	public String deleteAccount(@PathVariable("userId") Integer userId, @PathVariable("accountId") Integer accountId)
	{
		accountManager.deleteAccount(accountId);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}