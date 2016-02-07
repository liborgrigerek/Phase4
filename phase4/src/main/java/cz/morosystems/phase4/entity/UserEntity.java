package cz.morosystems.phase4.entity;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "READERTABLE")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Firstname can not be empty.")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Firstname can have alphabetical characters only.")
	@Column(name = "FIRSTNAME")
	private String firstname;

	@NotNull(message = "Lastname can not be empty.")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Lastname can have alphabetical characters only.")
	@Column(name = "LASTNAME")
	private String lastname;

	@NotNull(message = "Email can not be empty.")
	@Email(message = "Email does not have correct format.")
	@Column(name = "EMAIL")
	private String email;

	@Size(min = 9, max = 13, message = "Length of Telephone number is not correct.")
	@Pattern(regexp = "[+]?[0-9]+", message = "Telephone does not have correct format. Please enter the numbers without spaces.")
	@Column(name = "TELEPHONE")
	private String telephone;

	@ManyToMany(fetch=FetchType.EAGER, targetEntity = cz.morosystems.phase4.entity.BookEntity.class, cascade = { CascadeType.ALL })
	// definice spojeni - tabulka user_book_table musi existovat a obsahuje primarni klice obou tabulek - viz. definice tabulek v readme-db.txt
	@JoinTable(name = "USERS_BOOKS_TABLE", joinColumns = @JoinColumn(name = "USERID") , inverseJoinColumns = @JoinColumn(name = "BOOKID") )
	private Set<BookEntity> books;

	@OneToMany(fetch=FetchType.EAGER, targetEntity = cz.morosystems.phase4.entity.AccountEntity.class, cascade = { CascadeType.ALL})
	@JoinTable(name = "USER_ACCOUNTS_TABLE", joinColumns = @JoinColumn(name = "USERID") , inverseJoinColumns = @JoinColumn(name = "ACCOUNTID") )
	private Set<AccountEntity> accounts;

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}
	
	public Set<BookEntity> getBooks() {
		return books;
	}
	
	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}
	
	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}
}