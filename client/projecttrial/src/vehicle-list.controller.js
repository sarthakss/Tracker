(function(){
    var app = angular.module("car-tracker-app");
    app.controller("VehicleServiceController", vehicleController);

    function vehicleController(VehicleService) {
        // console.log("controller called");
        var self = this;
        VehicleService.getVehicles()
            .then(function(data) {
                self.vehicles = data;
            });

    }
})();