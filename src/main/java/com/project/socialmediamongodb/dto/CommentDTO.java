package com.project.socialmediamongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String text;
	private Date data;
	private AuthorDTO authotDto;
	
	public CommentDTO() {
		
	}

	public CommentDTO(String text, Date data, AuthorDTO authotDto) {
		super();
		this.text = text;
		this.data = data;
		this.authotDto = authotDto;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AuthorDTO getAuthotDto() {
		return authotDto;
	}

	public void setAuthotDto(AuthorDTO authotDto) {
		this.authotDto = authotDto;
	}
	
}
