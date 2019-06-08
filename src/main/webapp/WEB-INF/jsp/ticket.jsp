<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Message: ${message}</h2>
			<h2>Message: ${field}</h2>
			<h2>Message: ${value}</h2>
			<table border="1">
                <tr>
                    <th>TICKET ID</th>
                    <th>URL</th>
                    <th>EXTERNAL ID</th>
                    <th>CREATED_AT</th>
                    <th>TYPE</th>
                    <th>SUBJECT</th>
                    <th>DESCRIPTION</th>
                    <th>PRIORITY</th>
                    <th>STATUS</th>
                    <th>SUBMITTER ID</th>
                    <th>ASSIGNEE ID</th>
                    <th>ORGANIZATION ID</th>
                    <th>TAGS</th>
                    <th>HAS_INCIDENTS</th>
                    <th>DUE AT</th>
                    <th>VIA</th>
                </tr>
               <c:forEach var="ticket" items="${tickets}">
                   <tr>
                       <td>${ticket.id}</td>
                       <td>${ticket.url}</td>
                       <td>${ticket.externalId}</td>
                       <td>${ticket.createdAt}</td>
                       <td>${ticket.type}</td>
                       <td>${ticket.subject}</td>
                       <td>${ticket.description}</td>
                       <td>${ticket.priority}</td>
                       <td>${ticket.status}</td>
                       <td>${ticket.submitterId}</td>
                       <td>${ticket.assigneeId}</td>
                       <td>${ticket.organizationId}</td>
                       <td>${ticket.tags}</td>
                       <td>${ticket.hasIncidents}</td>
                       <td>${ticket.dueAt}</td>
                       <td>${ticket.via}</td>
                   </tr>
                </c:forEach>
           </table>
		</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
