package org.camunda.loanApplication.loanApprovalPkg;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="LoanRequestList")

public class LoanRequestList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String borrowername;
	
	@Column
	private int amount;
	
	@Column
	private boolean docverify;
	
	@Column
	private String status;
	
	public LoanRequestList(){}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowername() {
		return borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isDocverify() {
		return docverify;
	}

	public void setDocverify(boolean docverify) {
		this.docverify = docverify;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}

