'use strict';

/**
 * QuizController
 * @constructor
 */
var QuizController = function($scope, $http,$sanitize) {
	$scope.points=0;
	$scope.done = false;
	$scope.questionList = new Array();
	$scope.questionText = $sanitize('ေမးခြန္း');
	$scope.chooseText = $sanitize('ေရြးရန္');
    $scope.getFirstQuestionAndAnswers = function() {
    	/*$http.get('quiz/getQuestionAndAnswers/1').success(function(result) {
        	$scope.question = result[0];
        });*/
    	 $scope.getQuestionAndAnswers(1);
        
    };
   $scope.getAllQuestions =  function(){
	   $http.get('quiz/getAllQuestions.json').success(function(result) {
       		$scope.questionList = result;
       		$scope.getFirstQuestionAndAnswers();
       });
	   
   }
   
    $scope.getQuestionAndAnswers = function(questionId) {
    	for(var i=0;i<$scope.questionList.length;i++){
    		var q = $scope.questionList[i];
    		if(q.questionId==questionId){
    			$scope.question = q;
    			break;
    		}
    	}
    	
    	/*$http.get('quiz/getQuestionAndAnswers/'+questionId).success(function(result) {
        	$scope.question = result[0];
        	var ans = result[0].answers;
        	for(var i=0;i<ans.length;i++){
        		if(ans[i].correctFlg=='T'){
        			$scope.correctResult = $sanitize(ans[i].answerText);
        		}
        	}
        	$scope.done = false;*/
    };
    
    $scope.chooseAnswer= function(answer){
    	if(answer.correctFlg=='T'){
    		answer.result = "<font color='green'><b>Correct</b></font>";
    		$scope.points = $scope.points + 1;
    	}else{
    		answer.result = "<font color='red'><b>Wrong</b></font>";
    		if($scope.points >0){
    			$scope.points = $scope.points - 1;
    		}
    	}
    	$scope.done = true;
    };
    $scope.getAllQuestions();
};