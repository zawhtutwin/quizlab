'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngSanitize','ngRoute','AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: 'cars/layout',
        controller: CarController
    });

    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout',
        controller: TrainController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });
    
    $routeProvider.when('/cinemas', {
        templateUrl: 'cinemas/layout',
        controller: CinemaController
    });
      
    
    $routeProvider.when('/quizes', {
        templateUrl: 'quiz/layout',
        controller: QuizController
    });   
   
}]);
location.href="#/quizes?packageName=istqb1";
