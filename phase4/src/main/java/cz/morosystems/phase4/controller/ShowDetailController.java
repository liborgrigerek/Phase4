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

import cz.morosystems.phase4.entity.BookEntity;
import cz.morosystems.phase4.entity.UserEntity;
import cz.morosystems.phase4.service.AccountManager;
import cz.morosystems.phase4.service.BookManager;
import cz.morosystems.phase4.service.UserManager;

@Controller
@RequestMapping("/admin/detail")
public class ShowDetailController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private BookManager bookManager;

	@Autowired
	private AccountManager accountManager;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String listDetail(@PathVariable("userId") Integer userId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("bookList", bookManager.getAllBooks(userId));
		model.addAttribute("accountList", accountManager.getAllAccounts(userId));
		return "detailList";
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}
