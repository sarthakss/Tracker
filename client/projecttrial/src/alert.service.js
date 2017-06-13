(function() {
    var app = angular.module("car-tracker-app");
    app.service("AlertService", function($http) {
        var self = this;

        self.getAlerts = function(vin) {
            var promise1 = $http.get("http://localhost:8085/api/api/alerts/" + vin);
            var promise2 = promise1.then(function(response) {
                return response.data;
            });
            return promise2;
        }
    });
})();
	