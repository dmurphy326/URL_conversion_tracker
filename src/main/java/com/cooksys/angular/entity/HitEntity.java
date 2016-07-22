package com.cooksys.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HitEntity")
public class HitEntity {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "URLEntity")
	URLEntity urlEntity;

	// range 1-365
	@Column(name = "HitDay")
	Long hitDay;

	@Column(name = "HitYear")
	Long hitYear;

	public HitEntity() {
	}

	public HitEntity(URLEntity urlEntity, Long hitDay, Long hitYear) {
		this.urlEntity = urlEntity;
		this.hitDay = hitDay;
		this.hitYear = hitYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public URLEntity getUrlEntity() {
		return urlEntity;
	}

	public void setUrlEntity(URLEntity urlEntity) {
		this.urlEntity = urlEntity;
	}

	public Long getHitDay() {
		return hitDay;
	}

	public void setHitDay(Long hitDay) {
		this.hitDay = hitDay;
	}

	public Long getHitYear() {
		return hitYear;
	}

	public void setHitYear(Long hitYear) {
		this.hitYear = hitYear;
	}
	
	

}
