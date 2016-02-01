package cz.morosystems.phase4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase4.dao.BookDAO;
import cz.morosystems.phase4.dao.UserDAO;
import cz.morosystems.phase4.entity.BookEntity;
import cz.morosystems.phase4.entity.UserEntity;

@Service
public class BookManagerImpl implements BookManager {
	
	@Autowired
    private BookDAO bookDAO;

	@Transactional
	public List<BookEntity> getAllBooks(Integer userId) {
		return bookDAO.getAllBooks(userId);
	}

	@Transactional
	public BookEntity getBook(Integer bookId) {
		return bookDAO.getBook(bookId);
	}
	
	@Transactional
	public void addBook(BookEntity book) {
		bookDAO.addBook(book);
	}
	
	@Transactional
	public void editBook(BookEntity book) {
		bookDAO.editBook(book);
	}
	
	@Transactional
	public void deleteBook(Integer bookId) {
		bookDAO.deleteBook(bookId);
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
}
