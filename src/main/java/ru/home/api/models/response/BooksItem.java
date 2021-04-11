package ru.home.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksItem{

	@JsonProperty("website")
	private String website;

	@JsonProperty("pages")
	private int pages;

	@JsonProperty("subTitle")
	private String subTitle;

	@JsonProperty("author")
	private String author;

	@JsonProperty("isbn")
	private String isbn;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("description")
	private String description;

	@JsonProperty("title")
	private String title;

	@JsonProperty("publish_date")
	private String publishDate;

	public String getWebsite(){
		return website;
	}

	public int getPages(){
		return pages;
	}

	public String getSubTitle(){
		return subTitle;
	}

	public String getAuthor(){
		return author;
	}

	public String getIsbn(){
		return isbn;
	}

	public String getPublisher(){
		return publisher;
	}

	public String getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	public String getPublishDate(){
		return publishDate;
	}
}