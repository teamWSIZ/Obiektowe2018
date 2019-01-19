angular.module('myApp.controllers').controller('fourthCtrl',
    ['$rootScope','$scope', '$http', '$window', '$log',
        function ($rootScope, $scope, $http, $window, $log) {
            /////////////////////////////////////////////////////////////
            console.log('Loading fourth controller');
            $scope.M = {};
            $scope.M.x = '12';


            solveA = function (n) {
                console.log('solving for ' + n);
                if (n%2===0) {
                    console.log('OK');
                } else {
                    console.log('--')
                }
            };


            $scope.problemA = function () {
                solveA(12);
                solveA(121);
            };

            /////////////////////////////////////////////////////////////
            $scope.x = '.---...-.-...-..-';


            let solve1 = function () {
                console.log('Uruchamiam funkcję "solve"');
            };

            //funkcja ma znaleźć największą z liczb tabeli `arr`
            // założenie: arr to tablica liczb
            let solve2 = function (arr) {
                console.log('Uruchamiam funkcję "solve2", arr=' + arr);

                let najwieksza = -1000;
                let n = 0;

                for(let liczba of arr) {
                    n = n + 1; //do liczby `n` wstawiamy to co w niej jest + 1
                    console.log('Liczę dla liczba=' + liczba);
                    if (liczba>najwieksza) {
                        najwieksza = liczba;
                    }
                }
                console.log('------------------');
                console.log('Najwieksza liczba to:' + najwieksza);
                console.log('Wszystkich liczb w tablicy jest: ' + n);
                //todo: wyliczć średnią liczb w z tablicy `arr`

                //suma elementów tablicy:
                let suma = 0;
                for(let liczba of arr) {
                    suma += liczba;  //często używany skrót, zamiast zapisu: suma = suma + liczba
                }
                console.log('Suma:' + suma);
                console.log('Średnia:' + suma / arr.length);
            };

            //funkcja połączona ze "scope" jest czymś, co można "podłączyć" pod "ng-click"
            $scope.zadanie1 = function () {
                console.log('Uruchamiam zadanie 1');

                //uruchomienie funkcji "solve1"
                solve1();

                solve2([2, 4, 6, 1,16]);

            }
        }
    ]
);
