package com.sapient;

public class Myclass {

	Double amount;
	int people;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public Myclass(Double amount, int people) {
		super();
		this.amount = amount;
		this.people = people;
	}
}
