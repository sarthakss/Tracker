(function(){
    var app = angular.module("car-tracker-app");
    app.controller("AlertServiceController", alertController);

    function alertController(AlertService, $http) {
        console.log("alert controller");
        var self = this;
        // this.alerts = AlertService.alerts;

        self.getAlerts = function() {
            // console.log("The vin is" + this.vin);
            AlertService.getAlerts(self.vin)
                .then(function (data) {
                    self.alerts = data;
                });
        }
    }
})();