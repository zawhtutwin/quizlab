<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">.
<title>ISTQB Mock Test</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/app.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/bootstrap/css/bootstrap-combined.min.css" />
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery/jquery-1.11.3.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery/jquery.dataTables.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery/dataTables.bootstrap.min.js"></script>
<title>Login</title>
<script>
$(document).ready(function() {
	$("#questionsTable").dataTable("order":[[ 0, "desc" ]]);
});
</script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-sm-2">
<form:form method="POST"  commandName="question"  action="/QuizLab/admin/addQuestion"  accept-charset="UTF-8">
       <legend>ေမးခြန္းထည့္ရန္</legend>
       <fieldset>
       			<label for="questionText"></label><form:textarea  path="questionText"  cssStyle="width=100%"/>
        		<input type="submit" value="Submit"  class="btn-primary" />
        </fieldset>
</table>  
</form:form>
</div>
<div class="col-sm-2">
<table id="questionsTable"  class="table table-striped table-bordered" width="100%" cellspacing="0">
        <tr>
            <c:forEach var = "question" items = "${questionList}">
            <tr>
	            <td>
	                <c:out value="${question.questionId}"/>
	            </td>            
	            <td>
	                <c:out value="${question.questionText}"/>
	            </td>
	            <td>
	            	<a href="<%= request.getContextPath() %>/admin/answer/view/<c:out value="${question.questionId}"/>"   class="btn-success btn-small">အေျဖထည့္ရန္</a>
	            </td>
	            </tr>
            </c:forEach>
        </tr>
</table>
</div>
</div>
</div>
</body>
</html>