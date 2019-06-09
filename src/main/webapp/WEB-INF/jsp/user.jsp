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
                <a class="navbar-brand" style="padding: 15px 0;" href="/user-options">Back</a>
            </div>
        </div>
        <div class="container">
            <div class="starter-template">
                <h2 style="color: #03363d;" class="display-2">User Search Results</h2>
                <table class="table table-bordered" style="max-width:30%;">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">USER FIELD</th>
                            <th scope="col">FIELD VALUE</th>
                            <th scope="col">NUMBER OF USERS</th>
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
                            <td>${usersCount}</td>
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
               <h2 style="color: #03363d;" class="display-2">Organizations related to the Users</h2>
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

