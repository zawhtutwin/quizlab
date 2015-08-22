'use strict';

/**
 * CarController
 * @constructor
 */
var ReportController = function($scope, $http) {
	$scope.taskPerformanceList = new Array();
	$scope.memberList = new Array();
	$scope.dt = new Date();
	$scope.getTimeList = function(){
        $http.get('reports/timelist.json').success(function(rsList){
            $scope.timeList = rsList;
            $scope.taskPerformanceList = new Array();
            $scope.getDefaultTaskPerformanceList();
        });
	};
	
	$scope.getDesignWorkList = function(){
        $http.get('reports/design_work_list.json').success(function(rsList){
            $scope.designWorkList = rsList;
        });
	};	
	
	$scope.addTaskPerformance = function(){
		//get the start index and end index of time list
		var startIndex = findWithAttr($scope.timeList,"time",$scope.selectedStartTime);
		var endIndex = findWithAttr($scope.timeList,"time",$scope.selectedEndTime);
		//if the design work is not selected set the work no and work to blank
		if($scope.selectedDesignWork===undefined || $scope.selectedDesignWork==null){
			for(var i=startIndex;i<endIndex;i++){
				$scope.taskPerformanceList[i].workNo = "";
				$scope.taskPerformanceList[i].work = "";
				$scope.taskPerformanceList[i].time = $scope.timeList[i].time;
				$scope.taskPerformanceList[i].regDate = $scope.dt;
			}
			
		}else{
			for(var i=startIndex;i<endIndex;i++){
				$scope.taskPerformanceList[i].workNo = $scope.selectedDesignWork.workNo;
				$scope.taskPerformanceList[i].work = $scope.selectedDesignWork.work;
				$scope.taskPerformanceList[i].time = $scope.timeList[i].time;
				$scope.taskPerformanceList[i].regDate = $scope.dt;
				$scope.taskPerformanceList[i].memberId = $scope.selectedMember.memberId;
			}
			
			$http.post('reports/add', $scope.taskPerformanceList).success(function() {
	            alert("Done Adding Tasks");
	        }).error(function() {
	            $scope.setError('Could not add tasks');
	        });
		}
	};
	
	$scope.search = function(){
		alert($scope.selectedDesignWork);
	}
	
	$scope.getDefaultTaskPerformanceList = function(){
		var dList = $scope.timeList;
		$scope.selectedDesignWork = null;
		$scope.selectedStartTime = 0;
		$scope.selectedEndTime = 0;
		for(var i=0;i<dList.length;i++){
			var tp = new TaskPerformance("",dList[i].time,"");
			$scope.taskPerformanceList.push(tp);
		}
	};		
	
	
	$scope.$watch('dt',function(){
		if(!($scope.dt===undefined)){
			$scope.getTimeList();
		}
	});
	
	$scope.getMemberList = function(){
		 $http.get('reports/member_list.json').success(function(rsList){
	            $scope.memberList = rsList;
	        });
	};
	
	$scope.getMemberList();
	$scope.getTimeList();
	$scope.getDesignWorkList();
	
}