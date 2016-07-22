/**
 * 
 */

angular.module('app').service('AdminService', function($http){
	
	var url = 'stats/'
	var url2= 'stats/url/'
	
	this.getAllURLs = function() {return $http.get(url + 'url')}

	// total url hits
	this.totalHitAmount = function(urlID){return $http.get(url2 + urlID + '/hitsTotal')}
		
	//url hits by day
	this.getHitsDayAmount = function(urlID){return $http.get(url2 + urlID + '/hitsTotal/dayAmount')}
	
	//url hits by week
	this.getHitsWeekAmount = function(urlID){return $http.get(url2 + urlID + '/hitsTotal/weekAmount')}
	
	//url hits by month
	this.getHitsMonthAmount = function(urlID){return $http.get(url2 + urlID + '/hitsTotal/monthAmount')}
	
	//url hits by year
	this.getHitsYearAmount = function(urlID){return $http.get(url2 + urlID + '/hitsTotal/yearAmount')}
})