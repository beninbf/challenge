<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <style>
            .zendesk-logo {
                display: block;
                -ms-flex: 0 0 auto;
                flex: 0 0 auto;
                width: 200px;
                height: 40px;
                background: url(//d1eipm3vz40hy0.cloudfront.net/images/navigation/header/zendesk-logo.svg) left top no-repeat transparent;
                overflow: hidden;
                text-indent: -9999px;
                border: none;
                margin-top: 5%;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <c:url value="/css/main.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <a href="/" class="zendesk-logo"></a>
            <div class="navbar-header">
                <a class="navbar-brand" style="padding: 15px 0;" href="/organization-options">Back</a>
            </div>
        </div>
        <div class="container">
            <div class="starter-template">
                <h2 style="color: #03363d;" class="display-2">Organization Search Results</h2>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">ORGANIZATION FIELD</th>
                            <th scope="col">FIELD VALUE</th>
                            <th scope="col">NUMBER OF ORGANIZATIONS</th>
                        <tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${field}</td>
                            <td>
                                <c:if test="${empty value}">
                                    NULL
                                </c:if>
                                <c:if test="${not empty value}">
                                    ${value}
                                </c:if>
                            </td>
                            <td>${organizationsCount}</td>
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
