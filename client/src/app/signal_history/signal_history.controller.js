/**
 * Created by sarth on 6/14/2017.
 */
(function(){
    angular.module("tracker")
        .controller("SignalHistoryController", SignalHistoryControllerFn);

    SignalHistoryControllerFn.$inject=['DataService','$scope','$stateParams'];

    function SignalHistoryControllerFn(DataService, $scope, $stateParams){
        $scope.vinNumber = $stateParams.vinNumber;
        $scope.fuelVolume = [];

        DataService.getAllReadings($scope.vinNumber).then(function(data){
            $scope.readings = data;
            $scope.readings.forEach(function(reading) {
                $scope.fuelVolume.push(reading.fuelVolume);
            });
        }, function(error){
            console.log(error);
        });

        $scope.myJson = {
            type : 'line',
            series : [
                { values :  $scope.fuelVolume }
            ]
        };

    }
})();