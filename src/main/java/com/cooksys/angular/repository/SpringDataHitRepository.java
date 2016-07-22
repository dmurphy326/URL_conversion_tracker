package com.cooksys.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.angular.entity.HitEntity;

public interface SpringDataHitRepository extends JpaRepository<HitEntity, Long> {

	public List<HitEntity> findByUrlEntityId(long urlId);

	public HitEntity findById(long id);
}
