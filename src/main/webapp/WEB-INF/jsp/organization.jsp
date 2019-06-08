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
                    <th>ORGANIZATION ID</th>
                    <th>URL</th>
                    <th>EXTERNAL ID</th>
                    <th>NAME</th>
                    <th>DOMAIN NAMES</th>
                    <th>CREATED_AT</th>
                    <th>DETAILS</th>
                    <th>SHARED_TICKETS</th>
                    <th>TAGS</th>
                </tr>
               <c:forEach var="organization" items="${organizations}">
                   <tr>
                       <td>${organization.id}</td>
                       <td>${organization.url}</td>
                       <td>${organization.externalId}</td>
                       <td>${organization.name}</td>
                       <td>${organization.domainNames}</td>
                       <td>${organization.createdAt}</td>
                       <td>${organization.details}</td>
                       <td>${organization.sharedTickets}</td>
                       <td>${organization.tags}</td>
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
