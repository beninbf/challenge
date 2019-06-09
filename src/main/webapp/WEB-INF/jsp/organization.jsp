<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <c:url value="/css/main.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
    </head>
    <body>
        <nav class="navbar navbar-inverse" style="width:1290px;">
            <div class="container" style="margin-left:50px;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">ZenDesk Code Challenge</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/organization-options">Back</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="starter-template">
                <h1 class="display-2">Organization Search Results</h1>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">ORGANIZATION FIELD</th>
                            <th scope="col">FIELD VALUE</th>
                        <tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${field}</td>
                            <td>${value}</td>
                        </tr>
                    </tbody>
                </table>
                <table class="table table-striped table-bordered">
                    <thead class="thead-light">
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
                    </thead>
                    <tbody>
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
                    </tbody>
               </table>
            </div>
        </div>
	    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
