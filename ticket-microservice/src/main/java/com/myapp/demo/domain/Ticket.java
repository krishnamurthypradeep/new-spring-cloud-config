package com.myapp.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="TICKET_ID")
	private Integer id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Integer application_id;
	
	@Column(nullable = false)
	private Integer person_id;
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}


	public Ticket(String title, String description, Integer application_id, Integer person_id) {
		this.title = title;
		this.description = description;
		this.application_id = application_id;
		this.person_id = person_id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getApplication_id() {
		return application_id;
	}


	public void setApplication_id(Integer application_id) {
		this.application_id = application_id;
	}


	public Integer getPerson_id() {
		return person_id;
	}


	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", application_id=");
		builder.append(application_id);
		builder.append(", person_id=");
		builder.append(person_id);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
