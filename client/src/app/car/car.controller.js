(function(){
    angular.module('tracker')
        .controller('CarController', CarControllerFn);

    CarControllerFn.$inject = ['DataService','$scope','$location'];

    function CarControllerFn(DataService, $scope, $location) {
        carVm = this;

        DataService.getAllVehicles().then(function(data){
            $scope.carData = data;
        }, function(error){
            console.log(error);
        })

        carVm.sorter = {
            sortBy: 'lastServiceDate',
            sortOrder: true
        };

        $scope.goToGeolocation = function (){
            $location.path('/geolocation');
        }

    }

})();
