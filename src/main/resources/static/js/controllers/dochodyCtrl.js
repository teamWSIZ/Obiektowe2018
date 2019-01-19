angular.module('myApp.controllers').controller('dochodyCtrl',
    ['$rootScope','$scope', '$http', '$window', '$log',
        function ($rootScope, $scope, $http, $window, $log) {
            /////////////////////////////////////////////////////////////
            console.log('Loading `dochody` controller');
            $scope.M = {};
            $scope.wynik = [];
            $scope.dane = [
                {pesel: 'AA11', name: 'Koepka', dochod: 413},
                {pesel: 'VA11', name: 'Rose', dochod: 461},
                {pesel: 'VA12', name: 'Johnson', dochod: 362},
                {pesel: 'VX11', name: 'Thomas', dochod: 377}
            ];


            /////////////////////////////////////////////////////////////

            //Filtruje tablicę dochodów tak by pozostali tylko gracze o dochodach między low i high
            //zwraca przefiltrowaną tablicę
            let filterIncomesRange = function (incomes, low, high) {
                console.log('Filtrowanie po range low=' + low + ' high=' + high);
                let wyfiltrowane = [];
                for (let player of incomes) {
                    if (player.dochod >= low && player.dochod <= high) {
                        wyfiltrowane.push(player);
                    }
                }
                return wyfiltrowane;
            };

            //Filtruje tablicę dochodów tak by pozostali tylko gracze o peselach zaczynających się na `prez
            let filterIncomesPesel = function (incomes, pre) {
                console.log('Filtrowanie po peselu; szukany prefix=' + pre);
                let wyfiltrowane = [];
                for (let player of incomes) {
                    if (player.pesel.startsWith(pre)) {
                        wyfiltrowane.push(player);
                    }
                }
                return wyfiltrowane;
            };


            //funkcja biorąca tablicę 'obiektów dochodowych', i filtrująca: od dołu, góry i po peselu
            $scope.filterIncomes = function (incomes) {
                console.log('filtruję tablicę' + JSON.stringify(incomes));
                let filterLow = true;
                let filterHi = true;
                let filterPesel = true;

                if (filterLow) {
                    incomes = filterIncomesRange(incomes, $scope.iLow, $scope.iHigh);
                }
                console.log('Wyfiltrowane:' + JSON.stringify(incomes));

                if (filterPesel) {
                    incomes = filterIncomesPesel(incomes, $scope.iPesel);
                }
                console.log('Wyfiltrowane:' + JSON.stringify(incomes));
                $scope.wynik = incomes;
            };



            $scope.wyszukaj = function () {
                $scope.wynik = [];
                for (let player of $scope.dane) {
                    if ($scope.iLow !== undefined) {    //sprawdzenie czy coś zostało wpisane w pole iLow na UI
                        if (player.dochod >= $scope.iLow) {
                            $scope.wynik.push(player);
                        }
                    }
                }
            };

            //wyszukać po peselu (pesel zaczyna się od...)

            let solve2 = function (arr) {
                let g = "ga";
                if (g.startsWith("g")) {
                    console.log("OK");
                }

            }

        }
    ]
);
