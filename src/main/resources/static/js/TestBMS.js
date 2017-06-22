
angular.module('TestBMS', [
    'ngRoute'
    ])
    .config( ['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/info.html',
                controller: 'InfoController'
            })
            .when('/info',{
                templateUrl: 'views/info.html',
                controller: 'InfoController'
            })
            .when('/messages',{
                templateUrl: 'views/messages.html',
                controller: 'MessageController'
            })
            .when('/default',{
                templateUrl: 'views/default.html',
                controller: 'InfoController'
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.hashPrefix('').html5Mode(true);
    }]);