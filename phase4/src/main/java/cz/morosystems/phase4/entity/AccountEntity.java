package cz.morosystems.phase4.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="ACCOUNTTABLE")
public class AccountEntity {

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="USERID")
	private Integer userId;
	
	//@NotNull(message = "Name can not be empty.")
	@Column(name="NAME")
	private String name;
	
	//@NotNull(message = "Prefix can not be empty.")
	//@Pattern(regexp = "[0-9]+", message = "Prefix can have numeric characters only.")
	@Column(name="ACCOUNTPREFIX")
	private String accountPrefix;
	
	//@NotNull(message = "Number can not be empty.")
	//@Pattern(regexp = "[0-9]+", message = "Number can have numeric characters only.")
	@Column(name="ACCOUNTNUMBER")
	private String accountNumber;
	
	//@NotNull(message = "Code can not be empty.")
	//@Pattern(regexp = "[0-9]+", message = "Code can have numeric characters only.")
	@Column(name="BANKCODE")
	private String bankCode;

	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getAccountPrefix() {
		return accountPrefix;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccountPrefix(String accountPrefix) {
		this.accountPrefix = accountPrefix;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
}
