angular.
  module('app').
  config(['$routeProvider', 'baseRoute', 'homePage',
    function config($routeProvider, baseRoute, homePage) {

      $routeProvider.
      	when('/home', {
          
          templateUrl: homePage,
          controller: 'HomeController',
          controllerAs: 'homeController'
          
        }).
      	when('/user', {
          
          templateUrl: baseRoute + 'user/userTemplate.html',
          controller: 'UserController',
          controllerAs: 'userController'     
        }).
        when('/registeredUser', {
            
            templateUrl: baseRoute + 'user/postLoginTemplate.html',
            controller: 'PostLoginController',
            controllerAs: 'postLoginController' 
          }).
          when('/admin', {
              
              templateUrl: baseRoute + 'admin/adminTemplate.html',
              controller: 'AdminController',
              controllerAs: 'adminController',
            	//should resolve get list of URLs
              resolve: {
            	  allURLs: function(AdminService){
            		  return AdminService.getAllURLs()
            		  }
          }
            }).
        otherwise('/home')
    }
  ]);