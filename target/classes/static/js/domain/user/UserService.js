/**
 * 
 */

angular.module('app').service('UserService', function($http){

	var url = 'user/'
	
	// getUser from the information returned from Java server
	// needs a body
	this.getUser = function(unverified) { return $http.post(url + 'get', unverified) }

	
})