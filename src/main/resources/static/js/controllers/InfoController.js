/**
 * Created by andrey on 12.06.2017.
 */
(function(){
    angular.module("TestBMS")
        .controller("InfoController", ['$scope', '$location', '$routeParams', 'MainService',
            function ($scope, $location, $routeParams, MainService) {
                MainService.getInfo().then(function (res) {
                    $scope.currentFilePath = res.data.filePath;
                    $scope.time = res.data.time;
                    MainService.time = res.data.time;
                })
                $scope.onSubmit = function () {
                    var info = {};
                    info.filePath = $scope.currentFilePath;
                    info.time = $scope.time;
                    MainService.postInfo(info).then(function (res) {
                        console.log(res);
                        $location.path('/info');
                    })
                }
                $scope.onCancel = function(){
                    $location.path('/info');
                }
            }
        ]);
})();