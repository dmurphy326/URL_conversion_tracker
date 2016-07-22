/**
 * 
 */

angular.module('app').controller('UserController', ['UserService', '$location', function UserController(UserService, $location) {
	
	var ctrl = this;
	
	this.login = function () {
		var unverified = {
				"username": ctrl.username,
				"password": ctrl.password,
		}
		UserService.getUser(unverified).then(function(result) { 
			ctrl.user = result.data 
			console.dir(ctrl.user)
		
		
		if (ctrl.user != "") {
			if (ctrl.user.roleEntity.id === 1) {
				$location.path('/admin')
			} else if (ctrl.user.roleEntity.id === 2) {
				$location.path('/registeredUser')
			} else {
				alert('Welcome guest!!! You have no access')
				$location.path('/daFuq')
			}
		} else {
			alert('No such user, try again')
			$location.path('/user')
		}
	})
	}
	
}])