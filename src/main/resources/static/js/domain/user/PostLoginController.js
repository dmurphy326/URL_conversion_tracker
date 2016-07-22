angular.module('app').controller('PostLoginController', ['PostLoginService', '$routeParams', function(PostLoginService, $routeParams)
{
	
	var ctrl = this;
	
	PostLoginService.getUserDetails($routeParams.id).then(function(result){
		ctrl.user = result.data;
	});
	
}]);