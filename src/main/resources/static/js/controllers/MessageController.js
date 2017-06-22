/**
 * Created by andrey on 12.06.2017.
 */
(function(){
    angular.module("TestBMS")
        .controller("MessageController", ['$scope', '$location', '$routeParams', 'MainService', '$interval',
            function ($scope, $location, $routeParams,  MainService, $interval) {
                    MainService.started = true;
                    MainService.getMessages().then(function (res) {
                        $scope.xmlString = vkbeautify.xml(res.data);
                        $interval(function () {
                             MainService.getMessages().then(function (res) {
                                  $scope.xmlString = vkbeautify.xml(res.data);
                                  });
                             console.log("request  send");
                        }, MainService.time)

                    })
            }
        ]);
})();
