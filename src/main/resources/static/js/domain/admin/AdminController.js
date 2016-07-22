
angular.module('app').controller('AdminController', ['AdminService', 'allURLs', '$location', '$routeParams', function AdminController(AdminService, allURLs, $location, $routeParams) {
	
	
	var ctrl = this;
	
	ctrl.path = $location.path()
	
	ctrl.urls = allURLs.data
		
	//check routeParams may need to change
	// total hits from an url
	AdminService.totalHitAmount($routeParams).then(function(result){
		ctrl.hitTotalAmount = result.data
		console.dir(ctrl.hitTotalAmount)
	})
	
	// total hits from today from an url
	AdminService.getHitsDayAmount($routeParams).then(function(result){
		ctrl.hitDayTotalAmount = result.data
		console.dir(ctrl.hitDayTotalAmount)
	})
	
	// total hits from last 7 days from an url
	AdminService.getHitsWeekAmount($routeParams).then(function(result){
		ctrl.hitWeekTotalAmount = result.data
		console.dir(ctrl.hitWeekTotalAmount)
	})
	
	// total hits from last 30 days from an url
	AdminService.getHitsMonthAmount($routeParams).then(function(result){
		ctrl.hitMonthTotalAmount = result.data
		console.dir(ctrl.hitMonthTotalAmount)
	})
	
	// total hits from last 365 days from an url
	AdminService.getHitsYearAmount($routeParams).then(function(result){
		ctrl.hitYearTotalAmount = result.data
		console.dir(ctrl.hitYearTotalAmount)
	})
	
	// console.dir()
}])

