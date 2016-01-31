package cz.morosystems.phase4.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase4.entity.BookEntity;

@Repository
public class BookDaoImpl implements BookDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<BookEntity> getAllBooks(Integer userId) {
		return this.sessionFactory.getCurrentSession().createCriteria(BookEntity.class).add(Restrictions.eq("userId",userId)).addOrder(Order.asc("id")).list();
	}
	@Transactional
	public BookEntity getBook(Integer bookId) {
		return (BookEntity) this.sessionFactory.getCurrentSession().createQuery("from BookEntity book where book.id = :bookid").setParameter("bookid", bookId).uniqueResult();
	}
	@Transactional
	public void addBook(BookEntity book) {
		if (book.getId() == null) {
			// nova kniha
			this.sessionFactory.getCurrentSession().save(book);
		} else {
			// editace knihy
			this.sessionFactory.getCurrentSession().merge(book);
		}
	}
	@Transactional
	public void deleteBook(Integer bookId) {
		BookEntity book = (BookEntity) sessionFactory.getCurrentSession().load(
				BookEntity.class, bookId);
        if (null != book) {
        	this.sessionFactory.getCurrentSession().delete(book);
        }
	}
}
