<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<a href="${pageContext.request.contextPath}/admin">Packages></a><a href="${pageContext.request.contextPath}/admin/getAllQuesionByPackage/${question.packageId}/${selectedFont}">Questions></a>Answers
</div>
<div class="row">
<form:form method="POST"  commandName="answer"  action="${pageContext.request.contextPath}/admin/addAnswer"  accept-charset="UTF-8">
       <legend><spring:message code="label.enter_answer"/></legend>
       <fieldset>
       			<label for="answerText"></label><form:textarea  path="answerText"  cssStyle="width:100%" />
       			<div class="radio">
       				<label><form:radiobutton path="correctFlg"  value="T" />Correct</label>
					<label><form:radiobutton path="correctFlg"  value="F"/>Wrong</label>
				</div>
				<BR>
       			<form:hidden  path="questionId" />
        		<input type="submit" value="Submit"  class="btn-primary" />
        </fieldset>
</table>  
</form:form>
</div>	
<div class="row">
<h3>${question.questionText}</h3>
<table id="questionsTable"  class="table table-striped table-bordered" width="100%" cellspacing="0">
        <tr>
            <c:forEach var = "ans" items = "${question.answers}"  >
            <tr>
	            <td>
	                <c:out value="${ans.answerId}"/>
	            </td>            
	            <td>
	                <c:out value="${ans.answerText}"/>
	            </td>
	            <td>
	                <c:out value="${ans.correctFlg}"/>
	            </td>	            
	            <td>
	            <a href="<%=request.getContextPath()%>/admin/removeAnswer/${question.questionId}/${ans.answerId}" class="btn btn-danger btn-small"><spring:message code="label.delete"/></a>
	            </td>
	            </tr>
            </c:forEach>
        </tr>
</table>
</div>
<div class="row">
<a href="${pageContext.request.contextPath}/admin/">Go Back to Question</a>
</div>
</div>
</body>
</html>