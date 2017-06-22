/**
 * Created by andrey on 12.06.2017.
 */
(function () {
    angular.module("TestBMS")
        .service("MainService", ['$http', function ($http) {
            this.getInfo = function () {
                return  $http.get("api/info")
            }
            this.postInfo =  function (info) {
                return $http.post("api/info", info)
            }
            this.time = 0;
            this.started = false;
            this.getMessages = function(){
                return  $http({
                    method  : 'GET',
                    url     : 'api/messages',
                    timeout : 100000000000000,
                    params  : {},  // Query Parameters (GET)
                    transformResponse : function(data) {
                        // string -> XML document object
                        return data;
                    }
                })
            }
        }])

})();