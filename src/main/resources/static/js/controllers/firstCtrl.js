
angular.module('myApp.controllers',[]);


angular.module('myApp.controllers').controller('firstCtrl',
    ['$rootScope','$scope', '$http', '$window', '$log',
        function ($rootScope, $scope, $http, $window, $log) {
            /////////////////////////////////////////////////////////////
            console.log('Loading first controller');
            $scope.M = {};
            $scope.M.results = [];
            $scope.M.todo = [];


            $scope.search = {};
            $scope.iloraz = 0;

            $scope.AABB = 12; //to jest liczba
            $scope.nazwaArtykulu = 'BREAKING NEWS'; //to jest napis

            $scope.getTodos = function(){
                return $http({
                    url: 'https://jsonplaceholder.typicode.com/posts',
                    method: 'GET',
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data){
                    $scope.M.todo = data.slice(0,10);
                });
            };

            $scope.wyliczIloraz = function(xxx, yyy) {
                $scope.iloraz = xxx / yyy;
            };


            ////// INIT STATE
            //można załadować z https://jsonplaceholder.typicode.com/posts
            $scope.M.results = [
                {imie:'Ariel', nazwisko:'Wrong', score:11},
                {imie:'Ban', nazwisko:'Xiao', score:10},
                {imie:'Wong', nazwisko:'Li', score:88},
            ];

            /////////////////////////////////////////////////////////////
        }
    ]
);
