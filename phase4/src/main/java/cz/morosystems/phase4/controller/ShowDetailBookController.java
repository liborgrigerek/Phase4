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
@RequestMapping("/admin/detail/book")
public class ShowDetailBookController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private BookManager bookManager;
	
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.GET)
	public String initAddBookForm(@PathVariable("userId") Integer userId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("book", new BookEntity());
		return "addBook";
	}
	
	@RequestMapping(value = "/add/{userId}", method = RequestMethod.POST)
	public String submitAddBookForm(@PathVariable("userId") Integer userId, @ModelAttribute(value="book")@Valid BookEntity book, BindingResult addBookFormBindingResult, Model model) 
	{
		// osetri vysledek kontroly validatoru
		if(addBookFormBindingResult.hasErrors()) {
			model.addAttribute("user",userManager.getUser(userId));
			return "addBook";
		}
		// pridej uzivatele
		// pridej knihu k uzivateli
		UserEntity user = userManager.getUser(userId);
		user.getBooks().add(book);
		userManager.editUser(user);
		return String.format("redirect:/admin/detail/%d", userId);
	}
	
	@RequestMapping(value = "/edit/{userId}/{bookId}", method = RequestMethod.GET)
	public String initEditBookForm(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId, Model model) 
	{
		model.addAttribute("user", userManager.getUser(userId));
		model.addAttribute("book", bookManager.getBook(bookId));
		return "editBook";
	}
	
	@RequestMapping(value = "/edit/{userId}/{bookId}", method = RequestMethod.POST)
	public String submitEditBookForm(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId, @ModelAttribute(value="book")@Valid BookEntity book, BindingResult editBookFormBindingResult, Model model) 
	{
		// osetri vysledek kontroly validatoru
		if(editBookFormBindingResult.hasErrors()) {
			model.addAttribute("user", userManager.getUser(userId));
			return "editBook";
		}
		// pridej uzivatele
		bookManager.editBook(book);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	@RequestMapping("/delete/{userId}/{bookId}")
	public String deleteBook(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId)
	{
		bookManager.deleteBook(bookId);
		return String.format("redirect:/admin/detail/%d", userId);
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}
}
