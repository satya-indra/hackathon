package com.app.pojos;


import java.sql.Timestamp;
import javax.persistence.*;


@Entity
@Table(name = "payment")
public class Payment {
	private Integer id;
	private double amount;
	private Paidtype type;
	private Timestamp txTime;
	private Timestamp dueDate;
	private Member member;
	
	public Payment() {
		this(0.0, Paidtype.FINE, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis() + Config.BORROW_DURATION_MILLIS));
	}

	public Payment(double amount, Paidtype fine, Timestamp txTime, Timestamp dueDate) {
		this.amount = amount;
		this.type = fine;
		this.txTime = txTime;
		this.dueDate = dueDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	public Paidtype getType() {
		return type;
	}

	public void setType(Paidtype type) {
		this.type = type;
	}

	public Timestamp getTxTime() {
		return txTime;
	}

	public void setTxTime(Timestamp txTime) {
		this.txTime = txTime;
	}


	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	@ManyToOne
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", type=" + type + ", txTime="
				+ txTime + ", dueDate=" + dueDate + "]";
	}
	
}
