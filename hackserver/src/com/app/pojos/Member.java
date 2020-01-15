package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "member_lib")
@PrimaryKeyJoinColumn(name = "Id")
public class Member extends User {
	private List<IssueRecord> issueRecords;
	private List<Payment> payments;
	
	public Member() {
		System.out.println("inside member ctor");
	}
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	public List<IssueRecord> getIssueRecords() {
		return issueRecords;
	}

	public void setIssueRecords(List<IssueRecord> issueRecords) {
		this.issueRecords = issueRecords;
	}

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
