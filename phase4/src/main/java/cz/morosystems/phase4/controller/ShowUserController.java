package cz.morosystems.phase4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import cz.morosystems.phase4.entity.UserEntity;
import cz.morosystems.phase4.service.UserManager;

@Controller
@RequestMapping("/admin")
public class ShowUserController {
	
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUsers(Model model) 
	{
		model.addAttribute("userList", userManager.getAllUsers());
		return "userList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String initAddForm(Model model) 
	{
		model.addAttribute("user", new UserEntity());
		return "editUser";
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitAddForm(@ModelAttribute(value="user")@Valid UserEntity user, BindingResult result) 
	{
		// osetri vysledek kontroly validatoru
		if(result.hasErrors()) {
			return "editUser";
		}
		// pridej uzivatele nebo ho edituj
		if (user.getId() == null) {
			userManager.addUser(user);			
		} else {
			userManager.editUser(user);
		}
		return "redirect:/admin/";
	}

	@RequestMapping("/edit/{userId}")
	public String editUser(@PathVariable("userId") Integer userId, Model model)
	{
		model.addAttribute("user", userManager.getUser(userId));
		return "editUser";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId)
	{
		userManager.deleteUser(userId);
		return "redirect:/admin/";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
