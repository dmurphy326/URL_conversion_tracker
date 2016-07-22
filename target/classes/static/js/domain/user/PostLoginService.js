angular.module('app').service('PostLoginService', ['$http', function($http) {
	
	var url = 'user/';
	
	this.getUserDetails = function(id) { return $http.get(url + id) };
	
}])