'use strict';

/**
 * QuizController
 * @constructor
 */
var QuizController = function($scope,$http,$sanitize,$location,$rootScope) {
	$rootScope.points=0;
	$scope.done = false;
	$scope.questionList = new Array();
	$scope.totalQuestion = 0;
	$scope.noQuestion = false;
	$scope.questionText = 'ေမးခြန္း';
	$scope.chooseText = 'ေရြးရန္';
	$scope.loaded = false;
	$scope.packageName =  $location.search().packageName;
	$scope.userChoice = "";
	$scope.count =0;
	
	
    meSpeak.loadConfig("resources/js/lib/mespeak_config.json");
    meSpeak.loadVoice("resources/voices/en/en-us.json");

	$scope.speakQuestion = function(){
		meSpeak.speak($scope.question.questionText);
	};
	
    
    $scope.getFirstQuestionAndAnswers = function() {
    	/*$http.get('quiz/getQuestionAndAnswers/1').success(function(result) {
        	$scope.question = result[0];
        });*/
    	 $scope.getQuestionAndAnswers(1);
        
    };
   $scope.getAllQuestions =  function(){
	   
	   //$http.get('quiz/getAllQuestions.json').success(function(result) {
	   $http.get('quiz/getQuestionsByPackage/'+$scope.packageName).success(function(result) {	
		   $scope.questionList = result;
       		$scope.totalQuestion = $scope.questionList.length;
       		$scope.getFirstQuestionAndAnswers();
       		$scope.loaded = true;
       });
   }
   
    $scope.getQuestionAndAnswers = function(seq) {
    	
    	if($scope.count>=$scope.totalQuestion){
    		window.location.href = '#/cinemas';
    	}
    	if($scope.userChoice=="T"){
    		
    	}
    	$scope.userChoice="";
    	$scope.question = $scope.questionList[$scope.count];
    	$scope.count++;
    	/*for(var i=0;i<$scope.questionList.length;i++){
    		var q = $scope.questionList[i];
    		if(q.seq==seq){
    			$scope.question = q;
    			break;
    		}
    	}*/
    	meSpeak.stop();
    };
    
    $scope.chooseAnswer= function(answer){
    	if($scope.userChoice==""){
    		$scope.userChoice = answer.correctFlg;
    		if($scope.userChoice=="T"){
    			$rootScope.points = $scope.points + 1;
    		}
    	}
    	
    	if(answer.correctFlg=='T'){
    		answer.result = "<font color='green'><b>Correct</b></font>";
    		
    	}else{
    		answer.result = "<font color='red'><b>Wrong</b></font>";
    	}
    	$scope.done = true;
    };
    $scope.getAllQuestions();
};