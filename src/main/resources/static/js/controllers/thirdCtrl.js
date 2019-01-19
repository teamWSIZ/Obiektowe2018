angular.module('myApp.controllers').controller('thirdCtrl',
    ['$rootScope','$scope', '$http', '$window', '$log',
        function ($rootScope, $scope, $http, $window, $log) {
            /////////////////////////////////////////////////////////////
            console.log('Loading second controller');
            $scope.M = {};
            $scope.userCount = 0;
            $scope.avgScore = 0;
            $scope.bestScore = 0;

            $scope.selectedAlbum = 1;

            $scope.wybraneZdjecie =
                'https://www.fiftyflowers.com/site_files/FiftyFlowers/Image/Product/Blue_Tinted_Roses_Close_Up_350_985dbbbe.jpg';

            //dane z https://jsonplaceholder.typicode.com/photos


            $scope.pictures = [
                {
                    "albumId": 1,
                    "id": 1,
                    "title": "accusamus beatae ad facilis cum similique qui sunt",
                    "url": "https://via.placeholder.com/600/92c952",
                    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
                },
                {
                    "albumId": 1,
                    "id": 2,
                    "title": "reprehenderit est deserunt velit ipsam",
                    "url": "https://via.placeholder.com/600/771796",
                    "thumbnailUrl": "https://via.placeholder.com/150/771796"
                },
                {
                    "albumId": 1,
                    "id": 3,
                    "title": "officia porro iure quia iusto qui ipsa ut modi",
                    "url": "https://via.placeholder.com/600/24f355",
                    "thumbnailUrl": "https://via.placeholder.com/150/24f355"
                },
                {
                    "albumId": 1,
                    "id": 4,
                    "title": "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
                    "url": "https://via.placeholder.com/600/d32776",
                    "thumbnailUrl": "https://via.placeholder.com/150/d32776"
                },
                {
                    "albumId": 1,
                    "id": 5,
                    "title": "natus nisi omnis corporis facere molestiae rerum in",
                    "url": "https://via.placeholder.com/600/f66b97",
                    "thumbnailUrl": "https://via.placeholder.com/150/f66b97"
                }
            ];

            $scope.getPictures = function () {
                $http.get('https://jsonplaceholder.typicode.com/photos')
                    .success(function (data) {
                        $scope.pictures = data.slice(0,50);
                    })
            };

            $scope.getPicturesOfAlbum = function (albumid) {
                $http.get('https://jsonplaceholder.typicode.com/photos')
                    .success(function (wynik) {
                        // $scope.pictures = [];
                        for(let pic of wynik) {
                            if (pic.albumId===albumid) {
                                $scope.pictures.push(pic);
                            }
                        }
                    })
            };



            // Deklaracja tablicy uczestników z początkowymi danymi
            $scope.uczestnicy = [
                {
                    'imie' : 'Tadeusz',
                    'nazwisko' : 'Zakorczmenny',
                    'wynik' : 3.5
                }, {
                    'imie' : 'Jacek',
                    'nazwisko' : 'Zowakowski',
                    'wynik' : 2.0
                }, {
                    'imie' : 'Sylwia',
                    'nazwisko' : 'Polak',
                    'wynik' : 3.0
                }, {
                    'imie' : 'Marzena',
                    'nazwisko' : 'Polak',
                    'wynik' : 3.5
                }
            ];

            $scope.dodajUsera = function (imie, nazwisko, wynik) {
                console.log('Dodaję usera ' + nazwisko);
                $scope.uczestnicy.push({
                    'imie': imie,
                    'nazwisko': nazwisko,
                    'wynik': wynik
                });
            };


            $scope.sortNazwisko = function () {
                $scope.uczestnicy.sort((a, b) => {
                    return (a.nazwisko > b.nazwisko);
                });
            };

            $scope.sortImie = function () {
                console.log('Sortuję po imionach');
                $scope.uczestnicy.sort((a, b) => {
                    // return (a.imie > b.imie)?1:-1;
                    if (a.imie > b.imie) return 1;
                    else return -1;
                });
            };

            let solveA = function (n, s, v) {
                let mx = 0;
                for(let vv of v) {
                    mx = Math.max(mx, vv);
                }
                console.log(mx);
            };


            $scope.testsA = function () {
                solveA(3, 3, [1, 2, 3]);
            };




        }
    ]
);
