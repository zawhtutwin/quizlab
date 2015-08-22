'use strict';

/**
 * CarController
 * @constructor
 */
var CinemaController = function($scope, $http) {
	$scope.cinemas = new Array();
    
	$scope.addNewCinema = function(cinemaName) {
    	$scope.cinemas.push(cinemaName);
    };
	
    $scope.removeCinema = function(cinemaName) {
		var index = $scope.cinemas.indexOf(cinemaName);
		if(index>-1){
			$scope.cinemas.splice(index,1);
		}
    };
}