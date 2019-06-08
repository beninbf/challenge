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
                        <th>USER ID</th>
                        <th>URL</th>
                        <th>EXTERNAL ID</th>
                        <th>NAME</th>
                        <th>ALIAS</th>
                        <th>CREATED_AT</th>
                        <th>ACTIVE</th>
                        <th>VERIFIED</th>
                        <th>SHARED</th>
                        <th>LOCALE</th>
                        <th>TIMEZONE</th>
                        <th>LAST LOGIN AT</th>
                        <th>EMAIL</th>
                        <th>PHONE</th>
                        <th>SIGNATURE</th>
                        <th>ORGANIZATION ID</th>
                        <th>TAGS</th>
                        <th>SUSPENDED</th>
                        <th>ROLE</th>
                    </tr>
                   <c:forEach var="user" items="${users}">
                       <tr>
                           <td>${user.id}</td>
                           <td>${user.url}</td>
                           <td>${user.externalId}</td>
                           <td>${user.name}</td>
                           <td>${user.alias}</td>
                           <td>${user.createdAt}</td>
                           <td>${user.active}</td>
                           <td>${user.verified}</td>
                           <td>${user.shared}</td>
                           <td>${user.locale}</td>
                           <td>${user.timezone}</td>
                           <td>${user.lastLoginAt}</td>
                           <td>${user.email}</td>
                           <td>${user.phone}</td>
                           <td>${user.signature}</td>
                           <td>${user.organizationId}</td>
                           <td>${user.tags}</td>
                           <td>${user.suspended}</td>
                           <td>${user.role}</td>
                       </tr>
                    </c:forEach>
               </table>
            </div>
        </div>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

