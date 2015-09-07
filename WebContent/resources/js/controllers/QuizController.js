'use strict';

/**
 * QuizController
 * @constructor
 */
var QuizController = function($scope,$http,$sanitize,$location,$rootScope,$resource) {
	$rootScope.points=0;
	$scope.done = false;
	$scope.questionList = new Array();
	$scope.noQuestion = false;
	$scope.questionText = '';
	$scope.chooseText = '';
	$scope.loaded = false;
	$scope.userChoice = "";
	$scope.encodingItems=[{id:1,name:"Zawgyi"},{id:2,name:"Unicode"}];
	$scope.encoding=1;
	
	$scope.$on("$routeUpdate", function(event, route) {
			$scope.init();
     });
	
	$scope.init = function(){
		  $scope.count =0;
		  $scope.totalQuestion = 0;
		  $scope.packageName =  $location.search().packageName;  
		  $scope.translate();
		  $scope.getAllQuestions();
	};
	
    $scope.translate=function(){
    	var encodingFilePath = "";
    	if($scope.encoding == 1){
    		encodingFilePath="resources/Encoding/zawgyi.json";
    	}
    	else{
    		encodingFilePath="resources/Encoding/unicode.json";
    	}
    	$resource(encodingFilePath).get(function(data){
    		$scope.translation = data;
    		$scope.questionText=data.QUESTION;
    		$scope.chooseText=data.SELECT;
    	});
    };
    
    $scope.changedValue=function(item){
    	$scope.encoding=item.id;
    	$scope.translate();
    	var flg = window.confirm("Clicking 'OK' will restart the Quiz and change the font. If you don't want to lose your data click 'Cancel'?");
    	if(flg){
    		$scope.init();
    	}
    };
    
    meSpeak.loadConfig("resources/js/lib/mespeak_config.json");
    meSpeak.loadVoice("resources/voices/en/en-us.json");

	$scope.speakQuestion = function(){
		meSpeak.speak($scope.question.questionText);
	};
	
    
    $scope.getFirstQuestionAndAnswers = function() {
    	 $scope.getQuestionAndAnswers(1);
        
    };
   $scope.getAllQuestions =  function(){
	   var font = "zawgyi";
	   if($scope.encoding== 2){
		   font = "unicode";
	   }
	   //$http.get('quiz/getAllQuestions.json').success(function(result) {
	   $http.get('quiz/getQuestionsByPackage/'+$scope.packageName+"/"+font).success(function(result) {	
		   $scope.questionList = result;
       		$scope.totalQuestion = $scope.questionList.length;
       		$scope.getFirstQuestionAndAnswers();
       		$scope.loaded = true;
       });
   };
   
    $scope.getQuestionAndAnswers = function(seq) {
    	
    	if($scope.count>=$scope.totalQuestion){
    		window.location.href = '#/cinemas';
    	}
    	if($scope.userChoice=="T"){
    		
    	}
    	$scope.userChoice="";
    	$scope.question = $scope.questionList[$scope.count];
    	$scope.count++;

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
    $scope.init();
    
};