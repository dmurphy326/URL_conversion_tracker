package com.cooksys.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.angular.entity.HitEntity;
import com.cooksys.angular.entity.URLEntity;
import com.cooksys.angular.repository.SpringDataHitRepository;
import com.cooksys.angular.repository.SpringDataURLRepository;

@Service
public class URLService {

	@Autowired
	SpringDataHitRepository hitRepo;

	@Autowired
	SpringDataURLRepository urlRepo;

	public List<URLEntity> allURLs() {
		return urlRepo.findAll();
	}

	public URLEntity getURLById(long id) {
		return urlRepo.findById(id);
	}

	public List<HitEntity> allHits(long urlId) {
		return hitRepo.findByUrlEntityId(urlId);
	}

}
