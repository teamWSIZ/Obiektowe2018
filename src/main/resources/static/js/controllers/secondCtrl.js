angular.module('myApp.controllers').controller('secondCtrl',
    ['$rootScope','$scope', '$http', '$window', '$log',
        function ($rootScope, $scope, $http, $window, $log) {
            /////////////////////////////////////////////////////////////
            console.log('Loading second controller');
            $scope.M = {};
            $scope.M.bokA = 0;
            $scope.M.bokB = 0;
            $scope.M.bokC = 0;
            $scope.isVisible = true;
            $scope.napis_wynik = '';

            $scope.sprawdzTrojkat = function() {
                // $scope.xxx = (Math.random() * 10);

                // == oznacza sprawdzenie czy lewa storna równa się prawej
                let a = parseInt($scope.M.bokA);
                let b = parseInt($scope.M.bokB);
                let c = parseInt($scope.M.bokC);


                console.log('Abra kadabra');
                console.log('typ a to ' + (typeof a));

                // A + B > C
                if (a + b <= c) {
                    $scope.M.wynik = 'Trójkąt nie istnieje';
                    return;
                }

                // A + C > B
                if (a + c <= b) {
                    $scope.M.wynik = 'Trójkąt nie istnieje';
                    return;
                }
                // B + C > A
                if (b + c <= a) {
                    $scope.M.wynik = 'Trójkąt nie istnieje';
                    return;
                }


                $scope.M.wynik = 'OK -- trójkąt istnieje';
            };

            // Ustawia $scope.M.wynik w zależności która z liczb, $scope.A / .B jest większa.
            $scope.liczbaMniejsza = function () {
                let a = parseInt($scope.A);
                let b = parseInt($scope.B);

                if (a<b) {
                    $scope.M.wynik = 'Mniejsza liczba to:' + a;
                }
                if (a>=b) {
                    $scope.M.wynik = 'Mniejsza liczba to:' + b;
                }
            };



            $scope.potnij = function (tekst_napisu) {
                console.log('Napis to: `' + tekst_napisu + '`');
                let tablica = tekst_napisu.split(',');  // Tnie podany napis na tablicę napisów, używając ',' jako rozdzielnika
                let inna_tablica = ['a','aa','b'];  // Zadeklarowanie tablicy i wypełnienie jej danymi.
                inna_tablica[2] = 'dwa';  // zmiana zawartości drugiego (licząc od 0 włącznie) elementu tablicy

                console.log('Tablica to:' + JSON.stringify(tablica));
                console.log('Element 0 to:' + tablica[0]);
                console.log('Element 1 to:' + tablica[1]);
                console.log('Element 2 to:' + tablica[2]);
                console.log('Elementów w tablicy:' + tablica.length);

                tablica.sort();
                $scope.napis_wynik = tablica;

            };


            $scope.potnijX = function (tekst) {
                console.log('Do pocięcia: ' + tekst);
                let w = tekst.split(",");
                w.sort();
                $scope.napis_wynik = w; //wszystkie elementy
                console.log(w.length);
                let ww = Array(100).fill(0);
                $scope.napis_wynik = ww;

                //podwójna tablica
                let rows = tekst.split(":");
                console.log('----');

                for(let r of rows) {
                    console.log(r);
                }

                let s = [];
                s['a'] = 11;
                console.log('>>' + s['a']);

                let g = 'aa s r aww d a w ddd c a aa aa';
                let gg = g.split(' ');
                console.log(gg);
                let mu = [];
                let mx = 0;
                let mm = '';
                for(let gx of gg) {
                    if (mu[gx]===undefined) mu[gx]=0;
                    mu[gx]++;
                    if (mu[gx]>mx) {
                        mx = mu[gx];
                        mm = gx;
                    }
                }
                console.log('Word: ' + mm + ' count:' + mu[mm]);
            }

        }
    ]
);
