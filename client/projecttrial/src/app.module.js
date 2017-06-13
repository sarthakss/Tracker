var app = angular.module("car-tracker-app", ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when("/vehicles", {
            templateUrl:"vehicle-list.tmpl.html",
            controller:"VehicleServiceController",
            controllerAs:"vehicleController"
        })
        .when("/alerts", {
            templateUrl:"alert-list.tmpl.html",
            controller:"AlertServiceController",
            controllerAs:"alertController"
        })
        .when("/welcome", {
            templateUrl:"welcome.html",
        })
        .otherwise({
            redirectTo: "/welcome"
        });
});
