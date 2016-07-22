package com.cooksys.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.angular.entity.URLEntity;

public interface SpringDataURLRepository extends JpaRepository<URLEntity, Long> {

	public URLEntity findById(long id);

	public List<URLEntity> findAll();
}
