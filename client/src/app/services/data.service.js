(function(){

    angular.module('tracker')
        .service('DataService', DataServiceFn);

    DataServiceFn.$inject =['$http','$q'];

    function DataServiceFn($http,$q){
        var self = this;

        self.getAllVehicles = function (){
            var defer = $q.defer();

            $http({
                method:'GET',
                url:'http://localhost:8085/api/api-module/vehicles/getAll'
            })
                .success(function(data){
                    defer.resolve(data);
                })
                .error(function(error){
                    defer.reject(error);
                })
            return defer.promise;
        };

        self.getAllAlerts = function (){
            var defer = $q.defer();

            $http({
                method:'GET',
                url:'http://localhost:8085/api/api-module/alerts/getAll'
            })
                .success(function(data){
                    defer.resolve(data);
                })
                .error(function(error){
                    defer.reject(error);
                })
            return defer.promise;
        };

        self.getAllReadings = function (vin){
            var defer = $q.defer();

            $http({
                method:'GET',
                url:'http://localhost:8085/api/api-module/readings/'+ vin
            })
                .success(function(data){
                    defer.resolve(data);
                })
                .error(function(error){
                    defer.reject(error);
                })
            return defer.promise;
        };

        self.getAlertsByVehicle = function (vin){
            var defer = $q.defer();
            console.log("vin", vin);
            $http({
                method:'GET',
                url:'http://localhost:8085/api/api-module/alerts/' + vin
            })
                .success(function(data){
                    defer.resolve(data);
                })
                .error(function(error){
                    defer.reject(error);
                })
            return defer.promise;
        };

    }
})();