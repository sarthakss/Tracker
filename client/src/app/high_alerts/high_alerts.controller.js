/**
 * Created by sarth on 6/14/2017.
 */
(function(){

    angular.module("tracker")
        .controller("HighAlertsController", HighAlertsControllerFn);

    HighAlertsControllerFn.$inject = ['DataService', '$http','$scope'];

    function HighAlertsControllerFn(DataService, $http,$scope) {

        DataService.getAllAlerts().then(function(data){

            $scope.allAlerts = data.filter(function(value) {
                return value.alertPriority == "HIGH";
            })
        }).then(function () {
            console.log("all alerts",$scope.vehicles);
            $scope.vehicles.forEach(function(vehicle) {
                var count = 0;
                $scope.allAlerts.forEach(function(alert) {
                    if (vehicle.vin == alert.vin) {
                        count++;
                        vehicle.hightAlertCount = count;
                    }
                })
            });
        });

        DataService.getAllVehicles().then(function(data){
            $scope.vehicles = data;
            console.log("get all",$scope.vehicles);
        });
    }
})();