/**
 * Created by sarth on 6/14/2017.
 */
(function(){
    angular.module('tracker')
        .controller('HistoricAlertsController', HistoricAlertsControllerFn);

    HistoricAlertsControllerFn.$inject = ['DataService','$scope','$stateParams'];

    function HistoricAlertsControllerFn(DataService, $scope, $stateParams) {

        $scope.vinNumber = $stateParams.vinNumber;

        DataService.getAlertsByVehicle($scope.vinNumber).then(function(data){
            $scope.alerts = data;
        }, function(error){
            console.log(error);
        });
    }

})();