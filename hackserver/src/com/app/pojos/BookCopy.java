package com.app.pojos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "book_copy")
public class BookCopy {

	private Integer id;
	private int rack;
	private BookStatus status;
	private Book book;
	private List<IssueRecord> issueRecords;
	
	public BookCopy() {
		System.out.println("inside bookcopy ctor");
	}

	public BookCopy(int rack, BookStatus status) {
		this.rack = rack;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRack() {
		return rack;
	}

	public void setRack(int rack) {
		this.rack = rack;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@OneToMany(mappedBy = "bookCopy",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<IssueRecord> getIssueRecords() {
		return issueRecords;
	}

	public void setIssueRecords(List<IssueRecord> issueRecords) {
		this.issueRecords = issueRecords;
	}

	@Override
	public String toString() {
		return "BookCopy [id=" + id + ", rack=" + rack + ", status=" + status + "]";
	}
}
