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
        <nav class="navbar navbar-inverse" style="width:2200px;">
            <div class="container" style="margin-left:50px;">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">ZenDesk Code Challenge</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/user-options">Back</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="starter-template">
                <h1 class="display-2">User Search Results</h1>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">USER FIELD</th>
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
                            <th scope="col">USER ID</th>
                            <th scope="col">URL</th>
                            <th scope="col">EXTERNAL ID</th>
                            <th scope="col">NAME</th>
                            <th scope="col">ALIAS</th>
                            <th scope="col">CREATED_AT</th>
                            <th scope="col">ACTIVE</th>
                            <th scope="col">VERIFIED</th>
                            <th scope="col">SHARED</th>
                            <th scope="col">LOCALE</th>
                            <th scope="col">TIMEZONE</th>
                            <th scope="col">LAST LOGIN AT</th>
                            <th scope="col">EMAIL</th>
                            <th scope="col">PHONE</th>
                            <th scope="col">SIGNATURE</th>
                            <th scope="col">ORGANIZATION ID</th>
                            <th scope="col">TAGS</th>
                            <th scope="col">SUSPENDED</th>
                            <th scope="col">ROLE</th>
                        </tr>
                    </thead>
                    <tbody>
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
                    </tbody>
               </table>
            </div>
        </div>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

