angular.module('myApp.controllers').controller('engineCtrl',
    ['$rootScope','$scope', '$http', '$window', '$log',
        function ($rootScope, $scope, $http, $window, $log) {
            /////////////////////////////////////////////////////////////
            console.log('Loading `dochody` controller');
            $scope.M = {};
            $scope.wynik = [];
            $scope.enginestatus = {};
            const URL = "http://localhost:8081";



            /////////////////////////////////////////////////////////////

            let callEngine = function (arg) {
                $http({
                    url: URL + '/engine/' + arg,
                    method: 'GET',
                    params: {

                    }
                }).success(function (dane) {
                    $scope.enginestatus = dane;
                });
            };

            $scope.loadEngineState = function () {
                callEngine("status");
            };

            $scope.startEngine = function () {
                callEngine("start");
            };
            $scope.stopEngine = function () {
                callEngine("stop");
            };
            $scope.reverseEngine = function () {
                callEngine("reverse");
            };






            ////// odpalane przy aktualizacji widoku

            $scope.loadEngineState();


        }
    ]
);
