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
        <nav class="navbar navbar-inverse" style="width:1765px;">
            <div class="container" style="margin-left:50px;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">ZenDesk Code Challenge</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/ticket-options">Back</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="starter-template">
                <h1 class="display-2">Ticket Search Results</h1>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">TICKET FIELD</th>
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
                    </thead>
                    <tbody>
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
                    </tbody>
               </table>
            </div>
        </div>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
