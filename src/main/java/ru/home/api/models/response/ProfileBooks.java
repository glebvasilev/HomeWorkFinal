package ru.home.api.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileBooks{

	@JsonProperty("books")
	private List<BooksItem> books;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("username")
	private String username;

	public List<BooksItem> getBooks(){
		return books;
	}

	public String getUserId(){
		return userId;
	}

	public String getUsername(){
		return username;
	}
}