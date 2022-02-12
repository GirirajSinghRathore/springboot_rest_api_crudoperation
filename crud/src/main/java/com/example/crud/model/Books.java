package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Books {
	@Column
	@Id
	private int bookid;
	@Column
	private String bookname;
	@Column
	private String author;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Books(int bookid, String bookname, String author) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
	}

	public Books() {
		super();
	}
}