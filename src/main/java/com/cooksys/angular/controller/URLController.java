package com.cooksys.angular.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.angular.entity.HitEntity;
import com.cooksys.angular.entity.URLEntity;
import com.cooksys.angular.service.URLService;

@RestController
@RequestMapping("stats")
public class URLController {

	@Autowired
	URLService urlService;

	// returns all URLs
	@RequestMapping(value = "/url", method = RequestMethod.GET)
	public List<URLEntity> getAll() {
		return urlService.allURLs();
	}

	// returns the specific URL by id
	@RequestMapping(value = "/url/{id}", method = RequestMethod.GET)
	public URLEntity getURL(@PathVariable("id") long id) {
		return urlService.getURLById(id);
	}

	// returns a list of hits from a specific URL
	@RequestMapping(value = "/url/{id}/hits", method = RequestMethod.GET)
	public List<HitEntity> getHits(@PathVariable("id") long id) {
		return urlService.allHits(id);
	}

	// returns the total number of hits from a specific URL
	@RequestMapping(value = "/url/{id}/hitsTotal", method = RequestMethod.GET)
	public long getHitsTotal(@PathVariable("id") long id) {
		return getHits(id).size();
	}

	// takes a list of hits and returns a list of hits that associate with today
	@RequestMapping(value = "/url/{id}/hitsTotal/day", method = RequestMethod.GET)
	public List<HitEntity> getHitsDay(@PathVariable("id") long id) {
		List<HitEntity> oringinalList = getHits(id);
		List<HitEntity> newList = new ArrayList<>(); // no pun intended
		long currentDay = getDay();
		long currentYear = getYear();

		for (HitEntity hit : oringinalList) {
			if (currentDay == hit.getHitDay() && currentYear == hit.getHitYear()) {
				newList.add(hit);
			}
		}
		return newList;
	}

	// returns the total number of hits from a specific URL that associate with
	// today
	@RequestMapping(value = "/url/{id}/hitsTotal/dayAmount", method = RequestMethod.GET)
	public long getHitsDayAmount(@PathVariable("id") long id) {
		return getHitsDay(id).size();
	}

	// takes a list of hits and returns a list of hits that associate with the
	// last 7 days
	@RequestMapping(value = "/url/{id}/hitsTotal/week", method = RequestMethod.GET)
	public List<HitEntity> getHitsWeek(@PathVariable("id") long id) {
		List<HitEntity> oringinalList = getHits(id);
		List<HitEntity> newList = new ArrayList<>(); // pun is now intended
		long currentDay = getDay();
		long currentYear = getYear();

		for (HitEntity hit : oringinalList) {
			long hitYear = hit.getHitYear();
			long hitDay = hit.getHitDay();
			if (currentYear == hitYear) {
				if ((currentDay - hitDay) >= 0 && (currentDay - hitDay) <= 7) {
					newList.add(hit);
				}
			}
		}
		return newList;
	}

	// returns the total number of hits from a specific URL that associate with
	// the last 7 days
	@RequestMapping(value = "/url/{id}/hitsTotal/weekAmount", method = RequestMethod.GET)
	public long getHitsWeekAmount(@PathVariable("id") long id) {
		return getHitsWeek(id).size();
	}

	// takes a list of hits and returns a list of hits that associate with the
	// last 30 days
	@RequestMapping(value = "/url/{id}/hitsTotal/month", method = RequestMethod.GET)
	public List<HitEntity> getHitsMonth(@PathVariable("id") long id) {
		List<HitEntity> oringinalList = getHits(id);
		List<HitEntity> newList = new ArrayList<>(); // pun is still intended
		long currentDay = getDay();
		long currentYear = getYear();

		for (HitEntity hit : oringinalList) {
			long hitYear = hit.getHitYear();
			long hitDay = hit.getHitDay();
			if (currentYear == hitYear) {
				if ((currentDay - hitDay) >= 0 && (currentDay - hitDay) <= 30) {
					newList.add(hit);
				}
			}
		}
		return newList;
	}

	// returns the total number of hits from a specific URL that associate with
	// the last 30 days
	@RequestMapping(value = "/url/{id}/hitsTotal/monthAmount", method = RequestMethod.GET)
	public long getHitsMonthAmount(@PathVariable("id") long id) {
		return getHitsMonth(id).size();
	}

	// takes a list of hits and returns a list of hits that associate with the
	// last 365 days
	@RequestMapping(value = "/url/{id}/hitsTotal/year", method = RequestMethod.GET)
	public List<HitEntity> getHitsYear(@PathVariable("id") long id) {
		List<HitEntity> oringinalList = getHits(id);
		List<HitEntity> newList = new ArrayList<>(); // enough is enough
		long currentDay = getDay();
		long currentYear = getYear();

		for (HitEntity hit : oringinalList) {
			long hitYear = hit.getHitYear();
			long hitDay = hit.getHitDay();
			long yearDiffernece = currentYear - hitYear;

			if (yearDiffernece == 0) { // same year
				if ((currentDay - hitDay) >= 0 && (currentDay - hitDay) <= 365) {
					newList.add(hit);
				}
			} else if (yearDiffernece == 1) { // previous year
				hitDay = (365 - hitDay) + 365;
				if ((currentDay - hitDay) >= 0 && (currentDay - hitDay) <= 365) {
					newList.add(hit);
				}

			} else {
				// do nothing, illogical situation or too old
			}
		}
		return newList;
	}

	// returns the total number of hits from a specific URL that associate with
	// the last 365 days
	@RequestMapping(value = "/url/{id}/hitsTotal/yearAmount", method = RequestMethod.GET)
	public long getHitsYearAmount(@PathVariable("id") long id) {
		return getHitsYear(id).size();
	}

	/*******************************************************************************
	 * Helper Methods Section
	 ********************************************************************************/

	// returns current day
	public long getDay() {
		GregorianCalendar date = new GregorianCalendar();
		Date todaysDate = new Date();
		date.setTime(todaysDate);

		return date.get(Calendar.DAY_OF_YEAR);
	}

	// returns current year
	public long getYear() {
		GregorianCalendar date = new GregorianCalendar();
		Date todaysDate = new Date();
		date.setTime(todaysDate);

		return date.get(Calendar.YEAR);
	}

}
