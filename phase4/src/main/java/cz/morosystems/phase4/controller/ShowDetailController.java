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

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String listDetail(@PathVariable("userId") Integer userId, Model model) 
	{
		UserEntity user = userManager.getUser(userId);
		model.addAttribute("user", user);
		model.addAttribute("bookList", user.getBooks());
		model.addAttribute("accountList", user.getAccounts());
		return "detailList";
	}
}
