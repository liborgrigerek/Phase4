package cz.morosystems.phase4.dao;

import java.util.List;

import cz.morosystems.phase4.entity.BookEntity;
import cz.morosystems.phase4.entity.UserEntity;

public interface BookDAO {
	public BookEntity getBook(Integer bookId);
    public void addBook(BookEntity book);
    public void editBook(BookEntity book);
    public void deleteBook(Integer bookId);
}