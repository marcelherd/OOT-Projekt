package com.marcelherd.oot.persistence.domain;

import java.sql.Date;

/**
 * This domain type defines a highscore, as it is
 * used in the game "Wer Wird Millionär".
 * 
 * @author Marcel Herd
 */
public class Highscore extends Entity {

	private static final long serialVersionUID = 6386427441659349048L;
	
	private String name;
	private Date date;
	private int sum;
	
	public Highscore() {
		super();
	}
	
	public Highscore(Long id, String name, Date date, int sum) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.sum = sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Highscore [name=");
		builder.append(name);
		builder.append(", date=");
		builder.append(date);
		builder.append(", sum=");
		builder.append(sum);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
}
