
(function() {
    'use strict';

    angular.module('tracker', ['ui.router','ngMap','zingchart-angularjs'])
        .config(moduleConfig);

    moduleConfig.$inject=['$stateProvider','$urlRouterProvider'];

    function  moduleConfig($stateProvider,$urlRouterProvider) {
        $stateProvider
            .state('carList',{
                url:'/carlist',
                templateUrl:'app/car/car.tmpl.html',
                controller:'CarController'
            })
            .state('highAlerts',{
                url:'/highalerts',
                templateUrl:'app/high_alerts/high_alerts.tmpl.html',
                controller:'HighAlertsController'
            })
            .state('signalHistory',{
                url:'/carlist/signal_history/:vinNumber',
                templateUrl:'app/signal_history/signal_history.tmpl.html',
                controller:'SignalHistoryController'
            })
            .state('geoLocation',{
                url:'/geolocation',
                templateUrl:'app/geolocation/geolocation.tmpl.html',

            })
            .state('historicAlerts',{
                url:'/carlist/historicalerts/:vinNumber',
                templateUrl:'app/historic_alerts/historic_alerts.tmpl.html',
                controller:'HistoricAlertsController'
            })


        $urlRouterProvider.otherwise('/carlist');

    }



})();