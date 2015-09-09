<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html id='result'>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">.
<title>ISTQB Mock Test</title>
<link rel="shortcut icon" type="image/png" href="/media/images/favicon.png">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/app.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/jquery.dataTables.css" />

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/bootstrap/css/bootstrap-combined.min.css" />
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery/jquery-1.11.3.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery/jquery.dataTables.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery/dataTables.bootstrap.min.js"></script>
<title>Login</title>
<script>
$(document).ready(function() {
    $('#questionsTable').DataTable( {
        "paging":   true,
        "ordering": true,
        "info":     true
    } );
} );
</script>
</head>
<body>
<div class="container">

<div class="row">
	<a href="${pageContext.request.contextPath}/admin/getAllQuesionByPackage/<c:out value="${question.packageId}"/>/Zawgyi">Zawgyi</a>
	|
	<a href="${pageContext.request.contextPath}/admin/getAllQuesionByPackage/<c:out value="${question.packageId}"/>/Unicode">Unicode</a>
</div>


<a href="${pageContext.request.contextPath}/admin">Packages></a>Questions
<form:form method="POST"  commandName="question"  action="${pageContext.request.contextPath}/admin/addQuestion"  accept-charset="UTF-8">
       <legend>${questionLabel }</legend>
       <fieldset>
       			<label for="questionText"></label><form:textarea  path="questionText"  cssStyle="width:100%"/>
       			<form:hidden path="packageId" />
        		<input type="submit" value="Submit"  class="btn-primary" />
        </fieldset>
</table>  
</form:form>
<div class="fw-body">

<table id="questionsTable"  class="table table-striped table-bordered" width="100%" cellspacing="0">
        <thead>
        <th>No.
        </th>
        <th>Question
        </th>
        <th>Action</th>        
        </thead>
		<tfoot>
			<tr>
				<th>No.</th>
				<th>Question</th>
				<th>Action</th>
			</tr>
		</tfoot>
        <tbody>
            <c:forEach var = "question"  items = "${questionList}">
            	<tr>
		            <td>
		                <c:out value="${question.questionId}"/>
		            </td>            
		            <td>
		                <c:out value="${question.questionText}"/>
		            </td>
		            <td>
		            	<a href="<%= request.getContextPath() %>/admin/answer/view/<c:out value="${question.questionId}"/>"   class="btn btn-success btn-small">${addAnswerLabel}</a>
		            </td>
		            <td>
		            	<a href="<%= request.getContextPath() %>/admin/removeQuestion/<c:out value="${question.questionId}"/>/${question.packageId}"   class="btn btn-danger btn-small">${deleteAnswerLabel}</a>
		            </td>	            
	            </tr>
            </c:forEach>
        </tbody>
</table>
</div>
</div>
</body>
</html>