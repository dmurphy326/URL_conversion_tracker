package com.cooksys.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URLEntity")
public class URLEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "Base")
	private String base;

	@Column(name = "Label")
	private String label;

	@Column(name = "Description")
	private String description;

	public URLEntity() {
	}

	public URLEntity(String base, String label, String description) {
		this.base = base;
		this.label = label;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
