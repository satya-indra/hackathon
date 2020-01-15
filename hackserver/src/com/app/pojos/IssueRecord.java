package com.app.pojos;


import java.sql.Timestamp;

import javax.persistence.*;



@Entity
@Table(name = "issue_record")
public class IssueRecord {

	private Integer id;
	private Timestamp issued;
	private Timestamp returnDue;
	private Timestamp returned;
	private Double fine;
	private Member mem123;
	private BookCopy bookCopy;
	
	public IssueRecord() {
		System.out.println("inside issue record");
	}
	public IssueRecord( Timestamp issued, Timestamp returnDue, Timestamp returned, Double fine) {
		
		this.issued = issued;
		this.returnDue = returnDue;
		this.returned = returned;
		this.fine = fine;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Timestamp getIssued() {
		return issued;
	}
	
	public void setIssued(Timestamp issued) {
		this.issued = issued;
	}

	public Timestamp getReturnDue() {
		return returnDue;
	}
	public void setReturnDue(Timestamp returnDue) {
		this.returnDue = returnDue;
	}
	public Timestamp getReturned() {
		return returned;
	}
	public void setReturned(Timestamp returned) {
		this.returned = returned;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return mem123;
	}
	public void setMember(Member member) {
		this.mem123 = member;
	}
	
	@ManyToOne
	@JoinColumn(name = "copy_id")
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	@Override
	public String toString() {
		return "IssueRecord [ issued=" + issued + ", returnDue=" + returnDue + ", returned=" + returned + ", fine=" + fine + "]";
	}
}